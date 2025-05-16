package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.LoginAlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginAlunoModel, Integer> {
    Optional<LoginAlunoModel> findByUsernameAndPassword(String username, String password);
}
