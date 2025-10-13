package org.scoutingrvp.insigniApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Data
public class ScoutGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Length(min = 3, max = 128)
    private String name;

    @OneToMany(mappedBy = "group")
    private List<Scout> scouts;
}
