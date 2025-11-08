package org.scoutingrvp.insigniApi.util.mapper;

import org.scoutingrvp.insigniApi.dto.joinTables.ScoutInsigniaDto;
import org.scoutingrvp.insigniApi.dto.joinTables.ScoutRequirementDto;
import org.scoutingrvp.insigniApi.dto.scout.ScoutDto;
import org.scoutingrvp.insigniApi.model.Scout;
import org.scoutingrvp.insigniApi.model.joinTables.ScoutInsignia;
import org.scoutingrvp.insigniApi.model.joinTables.ScoutRequirement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoutMapper {
    public ScoutDto toDto(Scout scout) {
        ScoutDto dto = new ScoutDto();
        dto.setId(scout.getId());
        dto.setFirstName(scout.getFirstName());
        dto.setLastName(scout.getLastName());
        dto.setGroupId(scout.getGroup().getId());
        dto.setEarnedInsignias(mapInsignias(scout.getInsignias()));
        dto.setEarnedRequirements(mapRequirements(scout.getRequirements()));
        return dto;
    }

    private List<ScoutInsigniaDto> mapInsignias(List<ScoutInsignia> insignias) {
        return insignias.stream()
                .map(si -> {
                    ScoutInsigniaDto dto = new ScoutInsigniaDto();
                    dto.setId(si.getId());
                    dto.setInsigniaId(si.getInsignia().getId());
                    dto.setInsigniaName(si.getInsignia().getName());
                    dto.setInsigniaImageUrl(si.getInsignia().getImageUrl());
                    dto.setEarnedAt(si.getEarnedAt());
                    dto.setSignedOffByName(si.getSignedOffBy().getLeaderName());
                    return dto;
                }).toList();
    }

    private List<ScoutRequirementDto> mapRequirements(List<ScoutRequirement> requirements) {
        return requirements.stream()
                .map(sr -> {
                    ScoutRequirementDto dto = new ScoutRequirementDto();
                    dto.setId(sr.getId());
                    dto.setRequirementId(sr.getRequirement().getId());
                    dto.setRequirementName(sr.getRequirement().getName());
                    dto.setRequirementDescription(sr.getRequirement().getDescription());
                    dto.setEarnedAt(sr.getEarnedAt());
                    dto.setSignedOffByName(sr.getSignedOffBy().getLeaderName());
                    return dto;
                }).toList();
    }
}
