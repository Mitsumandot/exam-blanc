package com.example.exam.dao.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@DiscriminatorValue("INVITE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invite extends Participant{

    private String affiliation;

    @OneToMany(mappedBy = "invite")
    private List<Inscription> inscriptions;
}
