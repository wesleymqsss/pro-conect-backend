package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
    // Add custom query methods here if needed
}