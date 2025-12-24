package com.example.exam.dao.controllers;

import com.example.exam.dao.entities.Conference;
import com.example.exam.dao.entities.Session;
import com.example.exam.dao.entities.Speaker;
import com.example.exam.services.ConferenceService;
import com.example.exam.services.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("conference")
public class ConferenceController {
    private final ConferenceService conferenceService;
    private final SessionService sessionService;

    public ConferenceController(ConferenceService conferenceService, SessionService sessionService){
        this.conferenceService = conferenceService;
        this.sessionService = sessionService;
    }

    @GetMapping("/index")
    public String listConference(Model model){
        List<Conference> conferences = conferenceService.getAll();
        model.addAttribute("listConferences", conferences);
        List<Session> sessions = sessionService.getAllSession();
        model.addAttribute("listSessions", sessions);
        return "conferences";
    }

//    @GetMapping("/session")
//    public String getSessionConferences(Model model, @RequestParam(name = "session") Session session){
//        List<Conference> conferences = conferenceService.getBySession(session);
//        model.addAttribute("listConferences", conferences);
//        return "conferences";
//
//    }



    @PostMapping("/add")
    public String addConference(Model model,
                                @RequestParam(name = "title") String title,
                                @RequestParam(name = "date") LocalDate date,
                                @RequestParam(name = "startHour")LocalTime startHour,
                                @RequestParam(name = "endHour")LocalTime endHour,
                                @RequestParam(name = "description") String description,
                                @RequestParam(name = "session")Long session){
        Conference conference = new Conference();
        conference.setDate(date);
        conference.setTitle(title);
        conference.setStartHour(startHour);
        conference.setEndHour(endHour);
        conference.setDescription(description);
        Optional<Session> optionalSession = sessionService.getSessionById(session);
        optionalSession.ifPresent(conference::setSession);

        conferenceService.addConference(conference);

        return "redirect:/conference/index";

    }



}
