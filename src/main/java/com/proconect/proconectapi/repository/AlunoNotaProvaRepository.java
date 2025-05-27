// src/main/java/com/proconect/proconectapi/repository/AlunoNotaProvaRepository.java
package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.AlunoNotaProva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoNotaProvaRepository extends JpaRepository<AlunoNotaProva, Long> {
}
