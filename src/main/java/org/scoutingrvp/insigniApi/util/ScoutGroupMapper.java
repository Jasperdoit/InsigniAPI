package org.scoutingrvp.insigniApi.util;

import org.scoutingrvp.insigniApi.dto.scoutGroup.ScoutGroupDto;
import org.scoutingrvp.insigniApi.model.ScoutGroup;
import org.springframework.stereotype.Component;

@Component
public class ScoutGroupMapper {

    public ScoutGroupDto toDto(ScoutGroup scoutGroup) {
        ScoutGroupDto dto = new ScoutGroupDto();
        dto.setId(scoutGroup.getId());
        dto.setName(scoutGroup.getName());
        dto.setScoutCount(scoutGroup.getScouts().size());
        return dto;
    }
}
