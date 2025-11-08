package org.scoutingrvp.insigniApi.util.mapper;

import org.scoutingrvp.insigniApi.dto.insignia.InsigniaDto;
import org.scoutingrvp.insigniApi.model.Insignia;
import org.springframework.stereotype.Component;

@Component
public class InsigniaMapper {
    private final InsigniaRequirementMapper insigniaRequirementMapper;

    public InsigniaMapper(InsigniaRequirementMapper insigniaRequirementMapper) {
        this.insigniaRequirementMapper = insigniaRequirementMapper;
    }

    public InsigniaDto toDto(Insignia insignia) {
        return InsigniaDto.builder()
                .id(insignia.getId())
                .name(insignia.getName())
                .imageUrl(insignia.getImageUrl())
                .insigniaRequirements(insignia.getRequirements().stream().map(insigniaRequirementMapper::toDto).toList())
                .requiredInsigniaRequirements(insignia.getMinimumRequirements())
                .build();
    }
}
