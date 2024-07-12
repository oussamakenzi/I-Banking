package com.kenzi.service;

import com.E_Bank.Solution.dto.TransferDTO;

import java.util.List;

public interface TransferService {
    TransferDTO createInternalTransfer(TransferDTO transferDTO);
    List<TransferDTO> getAllTransfers();
    TransferDTO getTransferById(Long id);
}
