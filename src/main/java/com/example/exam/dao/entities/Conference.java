package com.example.exam.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;

    private String title;

    private LocalTime startHour;

    private LocalTime endHour;

    private String description;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @OneToOne
    @JoinColumn(name = "speaker_id")
    private Speaker speaker;

    @OneToMany(mappedBy = "conference", fetch = FetchType.LAZY)
    private List<Commentaire> commentaires;
}
