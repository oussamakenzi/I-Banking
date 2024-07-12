package com.kenzi.service.impl;

import com.E_Bank.Solution.dto.TransactionDTO;
import com.E_Bank.Solution.mapper.CarteMapper;
import com.E_Bank.Solution.mapper.TransactionMapper;
import com.E_Bank.Solution.model.Compte;
import com.E_Bank.Solution.model.Transaction;
import com.E_Bank.Solution.repository.CompteRepository;
import com.E_Bank.Solution.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private CarteMapper carteMapper;

    @Override
    @Transactional
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = transactionMapper.toEntity(transactionDTO);
        Compte compte = compteRepository.findById(transactionDTO.getCompteId())
                .orElseThrow(() -> new RuntimeException("Compte not found"));

        // Update the balance based on the type of transaction


        if ("Credit".equalsIgnoreCase(transaction.getTypeDeTransaction())) {
            compte.setSoldeInitial(compte.getSoldeInitial() + transaction.getMontant());
        } else if ("Debit".equalsIgnoreCase(transaction.getTypeDeTransaction())) {
            if (compte.getSoldeInitial() >= transaction.getMontant()) {
                compte.setSoldeInitial(compte.getSoldeInitial() - transaction.getMontant());
            } else {
                throw new RuntimeException("Insufficient balance");
            }
        } else {
            throw new RuntimeException("Invalid transaction type");
        }

        transaction.setCompte(compte);
        transaction = transactionRepository.save(transaction);
        return transactionMapper.toDTO(transaction);
    }


    @Override
    public TransactionDTO getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
        return transactionMapper.toDTO(transaction);
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(transactionMapper::toDTO)
                .collect(Collectors.toList());
    }

}
