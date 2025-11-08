package org.scoutingrvp.insigniApi.dto.joinTables;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScoutRequirementDto {
    private Integer id;
    private Integer requirementId;
    private String requirementName;
    private String requirementDescription;
    private LocalDateTime earnedAt;
    private String signedOffByName;
}
