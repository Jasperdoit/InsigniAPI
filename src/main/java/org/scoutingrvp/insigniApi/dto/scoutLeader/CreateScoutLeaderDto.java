package org.scoutingrvp.insigniApi.dto.scoutLeader;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class CreateScoutLeaderDto {
    @NotBlank
    @Range(min = 3, max = 128)
    private String name;
    @NotBlank
    @Range(min = 3, max = 256)
    @Email
    private String email;
    @NotBlank
    @Range(min = 8, max = 128)
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s]).+$",
            message = "Password must contain uppercase, lowercase, digit, and special character"
    )
    private String password;
    @NotNull(message = "Scout must be supplied a group")
    private Integer groupId;
}
