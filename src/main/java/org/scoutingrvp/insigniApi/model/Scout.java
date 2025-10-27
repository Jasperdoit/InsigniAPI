package org.scoutingrvp.insigniApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

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
