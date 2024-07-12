package com.kenzi.service.impl;

import com.E_Bank.Solution.dto.CarteDTO;
import com.E_Bank.Solution.mapper.CarteMapper;
import com.E_Bank.Solution.model.Carte;
import com.E_Bank.Solution.repository.CarteRepository;
import com.E_Bank.Solution.service.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarteServiceImpl implements CarteService {

    @Autowired
    private CarteRepository carteRepository;

    @Autowired
    private CarteMapper carteMapper;

    @Override
    public CarteDTO getCarteDetails(Long id) {
        Carte carte = carteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte not found"));
        return carteMapper.toDTO(carte);
    }

    @Override
    public CarteDTO activateCarte(Long id) {
        Carte carte = carteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte not found"));
        carte.setActive(true);
        carteRepository.save(carte);
        return carteMapper.toDTO(carte);
    }

    @Override
    public CarteDTO deactivateCarte(Long id) {
        Carte carte = carteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte not found"));
        carte.setActive(false);
        carteRepository.save(carte);
        return carteMapper.toDTO(carte);
    }

    @Override
    public CarteDTO blockCarte(Long id, String reason) {
        Carte carte = carteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte not found"));
        carte.setActive(false);  // Blocking the card
        // Add additional logic for reason if needed
        carteRepository.save(carte);
        return carteMapper.toDTO(carte);
    }

    @Override
    public List<CarteDTO> getAllCartes() {
        return carteRepository.findAll().stream()
                .map(carteMapper::toDTO)
                .collect(Collectors.toList());
    }
}
