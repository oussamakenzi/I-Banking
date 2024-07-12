package com.kenzi.repository;


import com.kenzi.model.Beneficiaire;
import com.kenzi.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Long> {
    List<Beneficiaire> findByCompte(Compte compte);
}
