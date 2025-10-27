package org.scoutingrvp.insigniApi.dto.scout;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
public class UpdateScoutDto {
    @NotBlank
    @Length(min = 3, max = 128)
    private String firstName;
    @NotBlank
    @Length(min = 3, max = 128)
    private String lastName;
    @NotNull
    @Range(min = 1, max = 4)
    private Integer ageGroup;
}
