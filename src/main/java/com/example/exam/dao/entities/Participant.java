package com.example.exam.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role")
@DiscriminatorValue("PARTICIPANT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;

    private String picture;

    private Boolean genre; // true for male and false for female

    @OneToMany(mappedBy = "participant")
    private List<Commentaire> commentaires;
}
