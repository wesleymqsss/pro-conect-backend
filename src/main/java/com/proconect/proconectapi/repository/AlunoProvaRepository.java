// src/main/java/com/proconect/proconectapi/repository/AlunoRepository.java
package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoProvaRepository extends JpaRepository<Aluno, Long> {
}
