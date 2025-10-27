package org.scoutingrvp.insigniApi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Insignia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String imageUrl;
    // Denotes the amount of requirements needed. -1 denotes all
    private Integer minimumRequirements;

    @ManyToMany
    @JoinTable(
            name = "scout_insignia",
            joinColumns = @JoinColumn(name = "insignia_id"),
            inverseJoinColumns = @JoinColumn(name = "scout_id")
    )
    private List<Scout> earnedByScouts;
    @OneToMany(mappedBy = "insignia")
    private List<InsigniaRequirement> requirements;
}
