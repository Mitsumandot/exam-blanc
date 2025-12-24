package com.example.exam.dao.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@DiscriminatorValue("SPEAKER")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Speaker extends Participant{

    private String link;

    @OneToOne(mappedBy = "speaker")
    private Conference conference;
}
