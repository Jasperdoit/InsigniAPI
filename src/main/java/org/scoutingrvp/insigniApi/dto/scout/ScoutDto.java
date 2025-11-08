package org.scoutingrvp.insigniApi.dto.scout;

import lombok.Data;
import org.scoutingrvp.insigniApi.dto.joinTables.ScoutInsigniaDto;
import org.scoutingrvp.insigniApi.dto.joinTables.ScoutRequirementDto;

import java.util.List;

@Data
public class ScoutDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer ageGroup;
    private Integer groupId;
    private String groupName;

    private List<ScoutInsigniaDto> earnedInsignias;
    private List<ScoutRequirementDto> earnedRequirements;
}