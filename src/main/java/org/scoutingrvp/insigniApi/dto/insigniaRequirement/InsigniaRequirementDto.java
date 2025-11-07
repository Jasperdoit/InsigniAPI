package org.scoutingrvp.insigniApi.dto.insigniaRequirement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsigniaRequirementDto {
    private Integer id;
    private String name;
    private String description;
}
