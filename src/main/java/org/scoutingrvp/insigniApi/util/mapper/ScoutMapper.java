package org.scoutingrvp.insigniApi.util.mapper;

import org.scoutingrvp.insigniApi.dto.scout.ScoutDto;
import org.scoutingrvp.insigniApi.model.Scout;
import org.springframework.stereotype.Component;

@Component
public class ScoutMapper {
    public ScoutDto toDto(Scout scout) {
        ScoutDto dto = new ScoutDto();
        dto.setId(scout.getId());
        dto.setFirstName(scout.getFirstName());
        dto.setLastName(scout.getLastName());
        dto.setGroupId(scout.getGroup().getId());
        return dto;
    }
}
