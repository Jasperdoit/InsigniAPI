package org.scoutingrvp.insigniApi.dto.scoutGroup.scout;

import lombok.Data;

@Data
public class ScoutDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer ageGroup;
    private Integer groupId;
    private String groupName;
}
