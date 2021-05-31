package com.example.travelTheWorld.repo;

import com.example.travelTheWorld.controllers.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}

