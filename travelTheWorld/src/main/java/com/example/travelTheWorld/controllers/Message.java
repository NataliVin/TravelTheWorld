package com.example.travelTheWorld.controllers;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String message;
    String user;
    Date msgDate;

    public Message(MessageDTO msgDto) {
        this.message = msgDto.message;
        this.user = msgDto.user;
    }

    @PrePersist
    void createAt() {
        this.msgDate = new Date();
    }

}
