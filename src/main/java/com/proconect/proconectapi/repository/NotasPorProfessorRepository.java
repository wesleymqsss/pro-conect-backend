package com.proconect.proconectapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.proconect.proconectapi.model.Professor;
import java.util.List;

public interface NotasPorProfessorRepository extends CrudRepository<Professor, Long> {

    @Query(value = """
        SELECT 
            p.id AS prova_id,
            p.descricao AS descricao_prova,
            p.data_prova AS data_prova,
            p.professor_id AS professor_id,
            a.id AS aluno_id,
            a.nome AS aluno_nome,
            a.matricula AS matricula,
            a.curso AS curso,
            a.turma AS turma,
            n.nota AS nota
        FROM notas n
        JOIN provas p ON n.prova_id = p.id
        JOIN alunos a ON n.aluno_id = a.id
        """, nativeQuery = true)
    List<Object[]> getNotasPorProfessor();
}
