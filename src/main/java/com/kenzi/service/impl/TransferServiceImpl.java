package com.kenzi.service.impl;

import com.E_Bank.Solution.dto.TransferDTO;
import com.E_Bank.Solution.mapper.TransferMapper;
import com.E_Bank.Solution.model.Compte;
import com.E_Bank.Solution.model.Transfer;
import com.E_Bank.Solution.repository.CompteRepository;
import com.E_Bank.Solution.repository.TransferRepository;
import com.E_Bank.Solution.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private TransferMapper transferMapper;

    @Override
    @Transactional
    public TransferDTO createInternalTransfer(TransferDTO transferDTO) {
        Compte compteSource = compteRepository.findById(transferDTO.getCompteSourceId())
                .orElseThrow(() -> new RuntimeException("Source account not found"));
        Compte compteDestination = compteRepository.findById(transferDTO.getCompteDestinationId())
                .orElseThrow(() -> new RuntimeException("Destination account not found"));

        // Ensure both accounts belong to the same user
        if (!compteSource.getUser().getUserId().equals(compteDestination.getUser().getUserId())) {
            throw new RuntimeException("Internal transfers can only be made between accounts of the same user");
        }

        // Check if source account has sufficient balance
        if (compteSource.getSoldeInitial() < transferDTO.getMontant()) {
            throw new RuntimeException("Insufficient funds in the source account");
        }

        // Perform the transfer
        compteSource.setSoldeInitial(compteSource.getSoldeInitial() - transferDTO.getMontant());
        compteDestination.setSoldeInitial(compteDestination.getSoldeInitial() + transferDTO.getMontant());

        // Save the updated accounts
        compteRepository.save(compteSource);
        compteRepository.save(compteDestination);

        // Create and save the transfer record
        Transfer transfer = transferMapper.toEntity(transferDTO);
        transfer.setDateHeure(LocalDateTime.now());
        transfer = transferRepository.save(transfer);

        return transferMapper.toDTO(transfer);
    }

    @Override
    public List<TransferDTO> getAllTransfers() {
        return transferRepository.findAll().stream()
                .map(transferMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransferDTO getTransferById(Long id) {
        Transfer transfer = transferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transfer not found"));
        return transferMapper.toDTO(transfer);
    }
}