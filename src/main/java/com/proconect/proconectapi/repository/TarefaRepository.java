package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByAlunoId(Long alunoId);
}

