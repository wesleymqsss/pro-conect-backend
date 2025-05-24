package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    // Novo método para buscar alunos por turma
    List<Aluno> findByTurma(String turma);
}
