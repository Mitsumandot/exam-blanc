package com.example.exam.DTO;

import com.example.exam.dao.entities.Session;
import jakarta.persistence.Inheritance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConferenceDTO {
    private LocalDate date;
    private String title;
    private LocalTime startHour;
    private LocalTime endHour;
    private String description;
}
