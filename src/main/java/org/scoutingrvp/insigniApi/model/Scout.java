package org.scoutingrvp.insigniApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
@Data
public class Scout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Length(min = 3, max = 128)
    private String firstName;
    @NotBlank
    @Length(min = 3, max = 128)
    private String lastName;
    @NotNull
    @Range(min = 1, max = 4)
    private Integer ageGroup;
    @ManyToOne
    @JoinColumn(name = "group_id")
    @NotNull
    private ScoutGroup group;
}
