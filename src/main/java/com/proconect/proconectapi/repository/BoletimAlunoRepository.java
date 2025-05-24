package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.DTO.BoletimAlunoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoletimAlunoRepository extends CrudRepository<com.proconect.proconectapi.model.Aluno, Long> {

    @Query(value = """
        SELECT 
          a.id AS alunoId,
          a.nome AS alunoNome,
          a.matricula AS matricula,
          a.curso AS curso,
          a.turma AS turma,
          m.nome AS materia,
          ROUND(AVG(n.nota), 2) AS mediaFinal
        FROM notas n
        JOIN provas p ON n.prova_id = p.id
        JOIN materias m ON p.materia_id = m.id
        JOIN alunos a ON n.aluno_id = a.id
        GROUP BY a.id, m.nome, a.turma
        """, nativeQuery = true)
    List<Object[]> getBoletimAlunos();
}
