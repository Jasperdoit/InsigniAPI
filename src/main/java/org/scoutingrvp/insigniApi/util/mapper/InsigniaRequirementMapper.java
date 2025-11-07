package org.scoutingrvp.insigniApi.util.mapper;

import org.scoutingrvp.insigniApi.dto.insigniaRequirement.InsigniaRequirementDto;
import org.scoutingrvp.insigniApi.model.InsigniaRequirement;
import org.springframework.stereotype.Component;

@Component
public class InsigniaRequirementMapper {
    public InsigniaRequirementDto toDto(InsigniaRequirement insigniaRequirement) {
        return InsigniaRequirementDto.builder()
                .id(insigniaRequirement.getId())
                .name(insigniaRequirement.getName())
                .description(insigniaRequirement.getDescription())
                .build();
    }
}
