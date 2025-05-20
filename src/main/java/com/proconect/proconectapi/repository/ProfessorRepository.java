package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    // Add custom query methods here if needed
}