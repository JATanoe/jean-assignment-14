package com.coderscampus.web;

import com.coderscampus.domain.Channel;
import com.coderscampus.domain.Message;
import com.coderscampus.domain.User;
import com.coderscampus.service.ChannelService;
import com.coderscampus.service.MessageService;
import com.coderscampus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChatController {

    private final ChannelService channelService;
    private final UserService userService;
    private final MessageService messageService;

    @Autowired
    public ChatController(ChannelService channelService, UserService userService, MessageService messageService) {
        this.channelService = channelService;
        this.userService = userService;
        this.messageService = messageService;
    }

    @PostMapping("/login")
    @ResponseBody
    public User login(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/welcome")
    public String getWelcome(ModelMap model) {
        model.addAttribute("channels", channelService.getAllChannels());
        return "welcome";
    }

    @GetMapping("/channels")
    @ResponseBody
    public List<Channel> getChannelMessages() {
        return channelService.getAllChannels();
    }

    @GetMapping("/channels/{id}")
    public String getChannelMessages(@PathVariable Long id, ModelMap model) {
        Channel channel = channelService.getChannelById(id);
        model.addAttribute("channel", channel);
        return "channel";
    }

    @GetMapping("/channels/{id}/messages")
    @ResponseBody
    public List<Message> getMessages(@PathVariable Long id) {
        return messageService.getMessagesByChannelId(id);
    }

    @PostMapping("/channels/{id}/messages/create")
    @ResponseBody
    public Message postMessage(@RequestBody Message message) {
        return messageService.save(message);
    }

}
