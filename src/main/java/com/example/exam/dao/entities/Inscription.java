package com.example.exam.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    private String status;

    private double price;

    @ManyToOne
    @JoinColumn(name = "invite_id", nullable = false)
    private Invite invite;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

}
