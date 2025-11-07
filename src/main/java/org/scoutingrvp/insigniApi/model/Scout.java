package org.scoutingrvp.insigniApi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Scout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer ageGroup;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ScoutGroup group;

    @ManyToMany(mappedBy = "earnedByScouts", fetch = FetchType.EAGER)
    private List<Insignia> earnedInsignias;
    @ManyToMany(mappedBy = "earnedByScouts", fetch = FetchType.EAGER)
    private List<InsigniaRequirement> earnedRequirements;
}
