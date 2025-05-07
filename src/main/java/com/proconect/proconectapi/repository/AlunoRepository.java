package com.proconect.proconectapi.repository;
import com.proconect.proconectapi.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
