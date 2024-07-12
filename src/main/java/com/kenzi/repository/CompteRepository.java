package com.kenzi.repository;

import com.E_Bank.Solution.model.Compte;
import com.E_Bank.Solution.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    List<Compte> findByUser(Users user);

}
