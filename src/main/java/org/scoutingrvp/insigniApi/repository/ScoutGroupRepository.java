package org.scoutingrvp.insigniApi.repository;

import org.scoutingrvp.insigniApi.model.ScoutGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoutGroupRepository extends JpaRepository<ScoutGroup, Integer> {
    Boolean existsByName(String name);
}
