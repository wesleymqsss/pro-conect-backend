package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.VisaoAlunoDashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisaoAlunoDashboardRepository extends JpaRepository<VisaoAlunoDashboard, String> {
}
