package com.proconect.proconectapi.repository;

import com.proconect.proconectapi.model.DashBoardCardsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardCardsRepository extends JpaRepository<DashBoardCardsModel, Long> {
}
