package org.scoutingrvp.insigniApi.dto.scoutLeader;

import lombok.Data;

@Data
public class ScoutLeaderDto {
    private Integer id;
    private String leaderName;
    private String leaderEmail;
    private Integer groupId;
    private String groupName;
}
