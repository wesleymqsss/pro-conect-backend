// src/main/java/com/proconect/proconectapi/repository/RespostaRepository.java
package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}
