package com.kenzi.service;

import com.E_Bank.Solution.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    TransactionDTO createTransaction(TransactionDTO transactionDTO);
    List<TransactionDTO> getAllTransactions();
    TransactionDTO getTransactionById(Long id);
}
