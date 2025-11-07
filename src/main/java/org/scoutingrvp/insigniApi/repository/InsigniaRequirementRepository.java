package org.scoutingrvp.insigniApi.repository;

import org.scoutingrvp.insigniApi.model.InsigniaRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsigniaRequirementRepository extends JpaRepository<InsigniaRequirement, Long> {
    List<InsigniaRequirement> findByInsigniaId(Long insigniaId);
}
