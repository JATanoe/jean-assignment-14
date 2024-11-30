package com.coderscampus.service;

import com.coderscampus.repository.ChannelRepository;
import com.coderscampus.repository.MessageRepository;
import com.coderscampus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChannelRepository channelRepo;
    private final UserRepository userRepo;
    private final MessageRepository messageRepo;

    @Autowired
    public ChatService(ChannelRepository channelRepo, UserRepository userRepo, MessageRepository messageRepo) {
        this.channelRepo = channelRepo;
        this.userRepo = userRepo;
        this.messageRepo = messageRepo;
    }

}
