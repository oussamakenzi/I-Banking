package com.kenzi.service.impl;

import com.E_Bank.Solution.dto.BeneficiaireDTO;
import com.E_Bank.Solution.mapper.BeneficiaireMapper;
import com.E_Bank.Solution.model.Beneficiaire;
import com.E_Bank.Solution.model.Compte;
import com.E_Bank.Solution.repository.BeneficiaireRepository;
import com.E_Bank.Solution.repository.CompteRepository;
import com.E_Bank.Solution.service.BeneficiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiaireServiceImpl implements BeneficiaireService {

    @Autowired
    private BeneficiaireRepository beneficiaireRepository;

    @Autowired
    private BeneficiaireMapper beneficiaireMapper;

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public BeneficiaireDTO addBeneficiaire(BeneficiaireDTO beneficiaireDTO) {
        Beneficiaire beneficiaire = beneficiaireMapper.toEntity(beneficiaireDTO);
        Compte compte = compteRepository.findById(beneficiaireDTO.getCompteId())
                .orElseThrow(() -> new RuntimeException("Compte not found"));
        beneficiaire.setCompte(compte);
        beneficiaire = beneficiaireRepository.save(beneficiaire);
        return beneficiaireMapper.toDTO(beneficiaire);
    }

    @Override
    public BeneficiaireDTO updateBeneficiaire(Long id, BeneficiaireDTO beneficiaireDTO) {
        Beneficiaire beneficiaire = beneficiaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Beneficiaire not found"));
        beneficiaire.setName(beneficiaireDTO.getName());
        beneficiaire.setAccountNumber(beneficiaireDTO.getAccountNumber());
        beneficiaire.setBankName(beneficiaireDTO.getBankName());
        if (beneficiaireDTO.getCompteId() != null) {
            Compte compte = compteRepository.findById(beneficiaireDTO.getCompteId())
                    .orElseThrow(() -> new RuntimeException("Compte not found"));
            beneficiaire.setCompte(compte);
        }
        beneficiaire = beneficiaireRepository.save(beneficiaire);
        return beneficiaireMapper.toDTO(beneficiaire);
    }

    @Override
    public void deleteBeneficiaire(Long id) {
        beneficiaireRepository.deleteById(id);
    }

    @Override
    public List<BeneficiaireDTO> getAllBeneficiaires() {
        return beneficiaireRepository.findAll().stream()
                .map(beneficiaireMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BeneficiaireDTO getBeneficiaireById(Long id) {
        Beneficiaire beneficiaire = beneficiaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Beneficiaire not found"));
        return beneficiaireMapper.toDTO(beneficiaire);
    }
}


