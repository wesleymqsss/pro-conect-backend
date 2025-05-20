package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.Opcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcaoRepository extends JpaRepository<Opcao, Long> {
    // Add custom query methods here if needed
}