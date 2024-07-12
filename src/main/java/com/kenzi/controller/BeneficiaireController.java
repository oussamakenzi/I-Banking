package com.kenzi.controller;

import com.kenzi.dto.BeneficiaireDTO;
import com.kenzi.service.BeneficiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiaires")
public class BeneficiaireController {

    @Autowired
    private BeneficiaireService beneficiaireService;

    @PostMapping
    public BeneficiaireDTO addBeneficiaire(@RequestBody BeneficiaireDTO beneficiaireDTO) {
        return beneficiaireService.addBeneficiaire(beneficiaireDTO);
    }

    @PutMapping("/{id}")
    public BeneficiaireDTO updateBeneficiaire(@PathVariable Long id, @RequestBody BeneficiaireDTO beneficiaireDTO) {
        return beneficiaireService.updateBeneficiaire(id, beneficiaireDTO);
    }

    @GetMapping("/{id}")
    public BeneficiaireDTO getBeneficiaireById(@PathVariable Long id) {
        return beneficiaireService.getBeneficiaireById(id);
    }

    @GetMapping
    public List<BeneficiaireDTO> getAllBeneficiaires() {
        return beneficiaireService.getAllBeneficiaires();
    }

    @DeleteMapping("/{id}")
    public void deleteBeneficiaire(@PathVariable Long id) {
        beneficiaireService.deleteBeneficiaire(id);
    }
}

