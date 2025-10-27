package org.scoutingrvp.insigniApi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class InsigniaRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "insignia_id")
    private Insignia insignia;

    @ManyToMany
    @JoinTable(
            name = "scout_requirement",
            joinColumns = @JoinColumn(name = "requirement_id"),
            inverseJoinColumns = @JoinColumn(name = "scout_id")
    )
    private List<Scout> earnedByScouts;
}
