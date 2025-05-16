package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
}