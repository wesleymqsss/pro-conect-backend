package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.AlunoView;
import com.proconect.proconectapi.model.AlunoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoViewRepository
        extends JpaRepository<AlunoView, AlunoView> {

    /** busca só as matérias/médias de um aluno */
    List<AlunoView> findByAlunoId(Long alunoId);
}
