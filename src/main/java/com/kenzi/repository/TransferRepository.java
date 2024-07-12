package com.kenzi.repository;

import com.E_Bank.Solution.model.Compte;
import com.E_Bank.Solution.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findByCompteSource(Compte compteSource);
    List<Transfer> findByCompteDestination(Compte compteDestination);
}
