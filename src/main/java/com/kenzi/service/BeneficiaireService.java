package com.kenzi.service;

import com.E_Bank.Solution.dto.BeneficiaireDTO;

import java.util.List;

public interface BeneficiaireService {
    BeneficiaireDTO addBeneficiaire(BeneficiaireDTO beneficiaireDTO);
    BeneficiaireDTO updateBeneficiaire(Long id, BeneficiaireDTO beneficiaireDTO);
    void deleteBeneficiaire(Long id);
    List<BeneficiaireDTO> getAllBeneficiaires();
    BeneficiaireDTO getBeneficiaireById(Long id);
}

