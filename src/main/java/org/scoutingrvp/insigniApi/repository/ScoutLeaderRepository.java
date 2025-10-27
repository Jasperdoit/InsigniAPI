package org.scoutingrvp.insigniApi.repository;

import org.scoutingrvp.insigniApi.model.ScoutLeader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoutLeaderRepository extends JpaRepository<ScoutLeader, Long> {
    Optional<ScoutLeader> findByEmail(String email);
}
