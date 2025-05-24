package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.Prova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProvaRepository extends JpaRepository<Prova, Long> {

    @Query("select distinct p from Prova p " +
            "left join fetch p.questoes q " +
            "left join fetch q.opcoes " +
            "where p.id = :id")
    Optional<Prova> findByIdWithQuestoesEOpcoes(@Param("id") Long id);

}
