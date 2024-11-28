package com.coderscampus.service;

import com.coderscampus.domain.Message;
import com.coderscampus.domain.User;
import com.coderscampus.repository.MessageRepository;
import com.coderscampus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepo;
    private Long count = 1L;

    @Autowired
    public MessageService(MessageRepository messageRepo, UserRepository userRepo) {
        this.messageRepo = messageRepo;
    }
    
    public Message save(Message message) {
        if (message.getId() == null) {
            message.setId(count++);
        }
        message.setTimestamp(LocalDateTime.now());
        return messageRepo.save(message);
    }

    public List<Message> getMessagesByChannelId(Long id) {
        return messageRepo.findByChannelId(id);
    }

}