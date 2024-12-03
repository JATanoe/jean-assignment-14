package com.coderscampus.service;

import com.coderscampus.domain.Channel;
import com.coderscampus.domain.Message;
import com.coderscampus.repository.ChannelRepository;
import com.coderscampus.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    private final ChannelRepository channelRepo;

    public ChannelService(ChannelRepository channelRepo) {
        this.channelRepo = channelRepo;
    }

    public Channel save(Channel channel) {
        return channelRepo.save(channel);
    }

    public List<Channel> getAllChannels() {
        return channelRepo.findAll().values().stream().toList();
    }

    public Channel getChannelById(Long id) {
        return channelRepo.findById(id);
    }

}
