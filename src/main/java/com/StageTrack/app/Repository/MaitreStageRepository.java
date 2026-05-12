package com.StageTrack.app.repository;

import com.StageTrack.app.domain.MaitreStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaitreStageRepository extends JpaRepository<MaitreStage, Long> {
}