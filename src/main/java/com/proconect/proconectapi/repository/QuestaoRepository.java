package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestaoRepository extends JpaRepository<questao, Long> {
    // Add custom query methods here if needed
}