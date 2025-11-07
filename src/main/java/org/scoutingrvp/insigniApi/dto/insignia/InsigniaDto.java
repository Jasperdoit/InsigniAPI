package org.scoutingrvp.insigniApi.dto.insignia;

import lombok.Builder;
import lombok.Data;
import org.scoutingrvp.insigniApi.dto.insigniaRequirement.InsigniaRequirementDto;

import java.util.List;

@Data
@Builder
public class InsigniaDto {
    private Integer id;
    private String name;
    private String imageUrl;
    private Integer requiredInsigniaRequirements;
    private List<InsigniaRequirementDto> insigniaRequirements;
}
