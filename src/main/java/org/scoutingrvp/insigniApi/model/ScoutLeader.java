package org.scoutingrvp.insigniApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class ScoutLeader {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    private String leaderName;
    private String email;
    private String passwordHash;
    private String passwordSalt;
    @ManyToOne
    @JoinColumn(name = "group_id")
    @NotNull
    private ScoutGroup group;
}
