package com.example.travelTheWorld.controllers;

import com.example.travelTheWorld.repo.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Scanner;


@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("title", "Main Page");
        return "home";
    }

    @GetMapping("/about")
    public String about (Model model) {
        model.addAttribute("title", "About Us");
        return "about";
    }
final MessageRepository messageRepository;
    @GetMapping("/messages")
    public String getMessages(Model model) {

        model.addAttribute("messages", messageRepository.findAll());
        return "messages";
    }

    @PostMapping("/addmessage")
    public String addMessage(String user, String message) {
        MessageDTO messageDTO = new MessageDTO(message, user);
        messageRepository.save(new Message(messageDTO));
        return "redirect:/messages";
    }


}