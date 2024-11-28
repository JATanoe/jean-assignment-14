package com.coderscampus.repository;

import com.coderscampus.domain.Channel;
import com.coderscampus.domain.Message;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ChannelRepository {
    private final Map<Long, Channel> channels = new HashMap<>();
    private Long count = 1L;

    public ChannelRepository() {
        initializeChannels();
    }

    public Channel save(Channel channel) {
        if (channel.getId() == null) {
            channel.setId(count++);
        }
        channels.put(channel.getId(), channel);
        return channel;
    }

    public Map<Long, Channel> findAll() {
        return channels;
    }

    public Channel findById(Long id) {
        Optional<Channel> optChannel = channels
                .values()
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
        return optChannel.orElse(null);
    }

    public void initializeChannels() {
        if (findAll().isEmpty()) {
            Channel channel1 = new Channel("General");
            Channel channel2 = new Channel("Full Stack");
            Channel channel3 = new Channel("Frontend");

            save(channel1);
            save(channel2);
            save(channel3);
        }
    }
}
