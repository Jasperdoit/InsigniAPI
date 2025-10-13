package org.scoutingrvp.insigniApi.dto.scoutGroup;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateScoutGroupDto {
    @NotBlank
    @Length(min=1, max=128)
    private String name;
}
