package org.scoutingrvp.insigniApi.dto.joinTables;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScoutInsigniaDto {
    private Integer id;
    private Integer insigniaId;
    private String insigniaName;
    private String insigniaImageUrl;
    private LocalDateTime earnedAt;
    private String signedOffByName;
}