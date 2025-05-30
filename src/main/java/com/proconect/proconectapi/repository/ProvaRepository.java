package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.Prova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProvaRepository extends JpaRepository<Prova, Long> {

    @Query("select distinct p from Prova p " +
            "left join fetch p.questoes q " +
            "left join fetch q.opcoes " +
            "where p.id = :id")
    Optional<Prova> findByIdWithQuestoesEOpcoes(@Param("id") Long id);

    @Query("select p from Prova p where p.professor.id = :professorId")
    List<Prova> buscarPorProfessor(@Param("professorId") Long professorId);

    // ✅ Novo método para evitar duplicação (upsert)
    Optional<Prova> findByDescricaoAndDataProvaAndProfessorId(
            String descricao,
            LocalDate dataProva,
            Long professorId
    );
}
