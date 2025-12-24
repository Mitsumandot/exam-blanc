package com.example.exam.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
    private List <Conference> conferences;

    @OneToOne
    @JoinColumn(name = "moderator_id")
    private Moderator moderator;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscription> inscriptions;

    @OneToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

}
