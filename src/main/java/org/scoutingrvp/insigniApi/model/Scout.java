package org.scoutingrvp.insigniApi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.scoutingrvp.insigniApi.model.joinTables.ScoutInsignia;
import org.scoutingrvp.insigniApi.model.joinTables.ScoutRequirement;

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

    @OneToMany(mappedBy = "scout", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ScoutInsignia> insignias;

    @OneToMany(mappedBy = "scout", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ScoutRequirement> requirements;
}
