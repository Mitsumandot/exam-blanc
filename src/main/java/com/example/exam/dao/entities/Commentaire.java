package com.example.exam.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime date;

    private String content;

    private int likes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne()
    @JoinColumn(name = "conference_id")
    private Conference conference;

}
