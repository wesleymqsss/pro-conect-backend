package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.StatusDisciplinaView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusDisciplinaViewRepository extends JpaRepository<StatusDisciplinaView, Long> {
    List<StatusDisciplinaView> findByIdAluno(Long idAluno);
}
