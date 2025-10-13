package org.scoutingrvp.insigniApi.repository;

import org.scoutingrvp.insigniApi.model.Scout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ScoutRepository extends JpaRepository<Scout, Integer> {
    List<Scout> findAllByGroupId(Integer id);
}
