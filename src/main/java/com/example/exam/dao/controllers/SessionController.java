package com.example.exam.dao.controllers;


import com.example.exam.dao.entities.Session;
import com.example.exam.services.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("session")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @GetMapping("/index")
    public String listSession(Model model){
        List<Session> sessions = sessionService.getAllSession();
        model.addAttribute("listSessions", sessions);
        return "sessions";
    }

    @PostMapping("/add")
    public String addSession(Model model, @RequestParam(name = "name")String name){
        Session session = new Session();
        session.setName(name);

        sessionService.addSession(session);

        return "redirect:/session/index";
    }

    @PostMapping("/delete")
    public String deleteConference(Model model, @RequestParam Long id){
        Optional<Session> session = sessionService.getSessionById(id);

        session.ifPresent(sessionService::deleteSession);

        return "redirect:/session/index";
    }
}
