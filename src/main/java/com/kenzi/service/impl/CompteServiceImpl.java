package com.kenzi.service.impl;

import com.E_Bank.Solution.dto.CompteDTO;
import com.E_Bank.Solution.mapper.CompteMapper;
import com.E_Bank.Solution.model.Compte;
import com.E_Bank.Solution.model.Users;
import com.E_Bank.Solution.repository.CompteRepository;
import com.E_Bank.Solution.repository.UserRepository;
import com.E_Bank.Solution.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private CompteMapper compteMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CompteDTO createCompte(CompteDTO compteDTO) {
        Compte compte = compteMapper.toEntity(compteDTO);
        Users user = userRepository.findById(compteDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        compte.setUser(user);
        compte = compteRepository.save(compte);
        return compteMapper.toDTO(compte);
    }

    @Override
    public CompteDTO closeCompte(Long id, String reason) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte not found"));
        compte.setStatus("Closed");
        compte.setRaisonClosure(reason);
        compteRepository.save(compte);
        return compteMapper.toDTO(compte);
    }

    @Override
    public List<CompteDTO> getAllComptes() {
        return compteRepository.findAll().stream()
                .map(compteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompteDTO getCompteById(Long id) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte not found"));
        return compteMapper.toDTO(compte);
    }

    @Override
    public CompteDTO updateCompte(Long id, CompteDTO compteDTO) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte not found"));
        compte.setTypeDeCompte(compteDTO.getTypeDeCompte());
        compte.setSoldeInitial(compteDTO.getSoldeInitial());
        compte.setDateDeCreation(compteDTO.getDateDeCreation());
        compte.setStatus(compteDTO.getStatus());
        compte.setRaisonClosure(compteDTO.getRaisonClosure());
        compteRepository.save(compte);
        return compteMapper.toDTO(compte);
    }

    @Override
    public double getCompteBalance(Long id) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte not found"));
        return compte.getSoldeInitial();
    }

    @Override
    public String getCopteType(Long id) {

        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte not found"));

        return compte.getTypeDeCompte();
    }
}
