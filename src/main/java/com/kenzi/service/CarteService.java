package com.kenzi.service;

import com.E_Bank.Solution.dto.CarteDTO;

import java.util.List;

public interface CarteService {
    CarteDTO getCarteDetails(Long id);
    CarteDTO activateCarte(Long id);
    CarteDTO deactivateCarte(Long id);
    CarteDTO blockCarte(Long id, String reason);
    List<CarteDTO> getAllCartes();
}
