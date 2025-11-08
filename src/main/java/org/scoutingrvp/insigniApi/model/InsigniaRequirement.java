package org.scoutingrvp.insigniApi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.scoutingrvp.insigniApi.model.joinTables.ScoutRequirement;

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

    @OneToMany(mappedBy = "requirement", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ScoutRequirement> options;
}