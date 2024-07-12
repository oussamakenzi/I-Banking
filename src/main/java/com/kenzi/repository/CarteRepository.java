package com.kenzi.repository;


import com.kenzi.model.Carte;
import com.kenzi.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarteRepository extends JpaRepository<Carte, Long> {
    Optional<Carte> findByCompte(Compte compte);
}
