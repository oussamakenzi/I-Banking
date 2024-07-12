package com.kenzi.controller;


import com.kenzi.dto.TransferDTO;
import com.kenzi.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/internal")
    public TransferDTO createInternalTransfer(@RequestBody TransferDTO transferDTO) {
        return transferService.createInternalTransfer(transferDTO);
    }

    @GetMapping("/{id}")
    public TransferDTO getTransferById(@PathVariable Long id) {
        return transferService.getTransferById(id);
    }

    @GetMapping
    public List<TransferDTO> getAllTransfers() {
        return transferService.getAllTransfers();
    }
}