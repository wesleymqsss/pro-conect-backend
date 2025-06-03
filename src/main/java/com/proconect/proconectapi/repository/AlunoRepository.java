package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.Aluno;
import com.proconect.proconectapi.DTO.AlunoNotaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findByTurma(String turma);

    @Query("SELECT DISTINCT a.turma FROM Aluno a")
    List<String> findDistinctTurmas();

    @Query(value = """
        SELECT 
            a.id AS alunoId,
            AVG(n.nota) AS nota
        FROM notas n
        JOIN provas p ON n.prova_id = p.id
        JOIN alunos a ON n.aluno_id = a.id
        GROUP BY a.id
        """, nativeQuery = true)
    List<AlunoNotaProjection> buscarNotasFinaisPorAluno();
}
