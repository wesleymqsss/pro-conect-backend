package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findByTurma(String turma);

    @Query("SELECT DISTINCT a.turma FROM Aluno a")
    List<String> findDistinctTurmas();
}

