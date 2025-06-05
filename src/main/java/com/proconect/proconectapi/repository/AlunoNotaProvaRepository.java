package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.AlunoNotaProva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoNotaProvaRepository extends JpaRepository<AlunoNotaProva, Long> {

    @Query("SELECT CASE WHEN COUNT(anp) > 0 THEN true ELSE false END " +
            "FROM AlunoNotaProva anp " +
            "WHERE anp.aluno.id = :alunoId AND anp.prova.id = :provaId")
    boolean existsByAlunoIdAndProvaId(@Param("alunoId") Long alunoId, @Param("provaId") Long provaId);
}
