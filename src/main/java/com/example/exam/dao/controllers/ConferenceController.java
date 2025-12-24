package com.example.exam.dao.controllers;

import com.example.exam.DTO.ConferenceDTO;
import com.example.exam.dao.entities.Conference;
import com.example.exam.dao.entities.Session;
import com.example.exam.dao.entities.Speaker;
import com.example.exam.services.ConferenceService;
import com.example.exam.services.SessionService;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.jar.Attributes;

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
    public String listConferences(Model model){
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
            @ModelAttribute ConferenceDTO conferenceDTO, @RequestParam Long sessionId){
        Conference conference = conferenceService.dtoToConference(conferenceDTO);

        Optional<Session> session = sessionService.getSessionById(sessionId);
        session.ifPresent(conference::setSession);

        conferenceService.addConference(conference);

        return "redirect:/conference/index";



    }



}
