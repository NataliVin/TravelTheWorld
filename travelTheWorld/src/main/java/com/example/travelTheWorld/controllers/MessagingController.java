package com.example.travelTheWorld.controllers;

import com.example.travelTheWorld.repo.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/messaging")
@RequiredArgsConstructor
public class MessagingController {

    private final MessageRepository messageRepository;

    @GetMapping
    public Iterable<Message> getMessage() {
        return messageRepository.findAll();
    }

    @PostMapping
    public Message addMessage(@RequestBody MessageDTO message) {
        return messageRepository.save(new Message(message));
    }

}
