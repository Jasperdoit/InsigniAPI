package org.scoutingrvp.insigniApi.model.joinTables;

import jakarta.persistence.*;
import lombok.Data;
import org.scoutingrvp.insigniApi.model.InsigniaRequirement;
import org.scoutingrvp.insigniApi.model.Scout;
import org.scoutingrvp.insigniApi.model.ScoutLeader;

import java.time.LocalDateTime;

@Entity
@Data
public class ScoutRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "scout_id")
    private Scout scout;
    @ManyToOne
    @JoinColumn(name = "requirement_id")
    private InsigniaRequirement requirement;

    @ManyToOne
    @JoinColumn(name = "signed_off_by_id")
    private ScoutLeader signedOffBy;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;
}
