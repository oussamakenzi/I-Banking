package com.kenzi.service;

import com.E_Bank.Solution.dto.CompteDTO;

import java.util.List;

public interface CompteService {
    CompteDTO createCompte(CompteDTO compteDTO);
    CompteDTO closeCompte(Long id, String reason);
    List<CompteDTO> getAllComptes();
    CompteDTO getCompteById(Long id);
    CompteDTO updateCompte(Long id, CompteDTO compteDTO);
    double getCompteBalance(Long id);
    String getCopteType(Long id);
}

