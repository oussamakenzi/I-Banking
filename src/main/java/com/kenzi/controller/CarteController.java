package com.kenzi.controller;


import com.kenzi.dto.CarteDTO;
import com.kenzi.service.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartes")
public class CarteController {

    @Autowired
    private CarteService carteService;



    @GetMapping
    public List<CarteDTO> getAllCartes() {
        return carteService.getAllCartes();
    }

    @PutMapping("/{id}/activate")
    public CarteDTO activateCarte(@PathVariable Long id) {
        return carteService.activateCarte(id);
    }

    @PutMapping("/{id}/deactivate")
    public CarteDTO deactivateCarte(@PathVariable Long id) {
        return carteService.deactivateCarte(id);
    }

    @PutMapping("/{id}/block")
    public CarteDTO blockCarte(@PathVariable Long id, @RequestParam String reason) {
        return carteService.blockCarte(id, reason);
    }

    @GetMapping("{id}")
    public CarteDTO getCarte(@PathVariable Long id) {

        return carteService.getCarteDetails( id);
    }
}
