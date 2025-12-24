package com.example.exam.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@DiscriminatorValue("Moderator")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Moderator extends Participant{

    private String specialization;

    @OneToOne(mappedBy = "moderator")
    private Session session;

}
