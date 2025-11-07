package org.scoutingrvp.insigniApi.dto.insigniaRequirement;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class CreateInsigniaRequirementDto {
    @NotBlank
    @Range(min = 3, max = 256)
    private String name;
    @NotBlank
    @Range(min = 3, max = 2048)
    private String description;
}
