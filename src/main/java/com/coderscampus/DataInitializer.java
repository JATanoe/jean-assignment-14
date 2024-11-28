package com.coderscampus;

import com.coderscampus.domain.Channel;
import com.coderscampus.domain.Message;
import com.coderscampus.domain.User;
import com.coderscampus.service.ChannelService;
import com.coderscampus.service.MessageService;
import com.coderscampus.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final ChannelService channelService;
    private final MessageService messageService;

    public DataInitializer(UserService userService, ChannelService channelService, MessageService messageService) {
        this.userService = userService;
        this.channelService = channelService;
        this.messageService = messageService;
    }

    @Override
    public void run(String... args) throws Exception {
//        initializeChannels();
//        initializeMessages();
    }

    private void initializeChannels() {
        Channel channel1 = new Channel();
        channel1.setName("General");

        Channel channel2 = new Channel();
        channel2.setName("Full Stack");

        Channel channel3 = new Channel();
        channel3.setName("Frontend");

        Channel channel4 = new Channel();
        channel4.setName("Backend");

        List<Channel> channels = Arrays.asList(channel1, channel2, channel3, channel4);
        channels.forEach(channelService::save);
    }

    private void initializeMessages() {
        User user1 = new User();
        user1.setName("Alice");

        User user2 = new User();
        user2.setName("Bob");

        User user3 = new User();
        user3.setName("Charli");

        User user4 = new User();
        user4.setName("Dave");

        User user5 = new User();
        user5.setName("Eve");

        User user6 = new User();
        user6.setName("Frank");

        User user7 = new User();
        user7.setName("Grace");

        User user8 = new User();
        user8.setName("Heidi");

        User user9 = new User();
        user9.setName("Ivan");

        List<User> users = Arrays.asList(
            user1,  user2,  user3, user4,  user5,  user6, user7,  user8,  user9
        );

        List<User> savedUsers = users.stream().map(userService::save).toList();

        Message msg0 = new Message();
        msg0.setChannelId(1L);
        msg0.setUser(savedUsers.get(0));
        msg0.setText("Hey, does anyone know a good resource for learning full-stack development?");
//        msg0.setTimestamp(getTime(LocalDateTime.now().minusMinutes(10)));

        Message msg1 = new Message();
        msg1.setChannelId(1L);
        msg1.setUser(savedUsers.get(1));
        msg1.setText("Sure, freeCodeCamp is a great place to start.");
//        msg1.setTimestamp(getTime(LocalDateTime.now().minusMinutes(8)));

        Message msg2 = new Message();
        msg2.setChannelId(1L);
        msg2.setUser(savedUsers.get(0));
        msg2.setText("Thanks, Bob! I'll check it out.");
//        msg2.setTimestamp(getTime(LocalDateTime.now().minusMinutes(7)));

        Message msg3 = new Message();
        msg3.setChannelId(1L);
        msg3.setUser(savedUsers.get(2));
        msg3.setText("Don't forget about MDN Web Docs for reference.");
//        msg3.setTimestamp(getTime(LocalDateTime.now().minusMinutes(5)));

        Message msg4 = new Message();
        msg4.setChannelId(2L);
        msg4.setUser(savedUsers.get(3));
        msg4.setText("Can someone explain the differences between JDK, JRE, and JVM?");
//        msg4.setTimestamp(getTime(LocalDateTime.now().minusMinutes(15)));

        Message msg5 = new Message();
        msg5.setChannelId(2L);
        msg5.setUser(savedUsers.get(4));
        msg5.setText("JDK is the development kit, JRE is the runtime environment, and JVM is the virtual machine that runs Java bytecode.");
//        msg5.setTimestamp(getTime(LocalDateTime.now().minusMinutes(12)));

        Message msg6 = new Message();
        msg6.setChannelId(2L);
        msg6.setUser(savedUsers.get(3));
        msg6.setText("Got it, thanks Eve!");
//        msg6.setTimestamp(getTime(LocalDateTime.now().minusMinutes(10)));

        Message msg7 = new Message();
        msg7.setChannelId(2L);
        msg7.setUser(savedUsers.get(5));
        msg7.setText("For detailed info, check out the official Oracle documentation.");
//        msg7.setTimestamp(getTime(LocalDateTime.now().minusMinutes(5)));

        Message msg8 = new Message();
        msg8.setChannelId(3L);
        msg8.setUser(savedUsers.get(6));
        msg8.setText("What's the best way to manage state in a large React application?");
//        msg8.setTimestamp(getTime(LocalDateTime.now().minusMinutes(20)));

        Message msg9 = new Message();
        msg9.setChannelId(3L);
        msg9.setUser(savedUsers.get(7));
        msg9.setText("I recommend using Redux for state management.");
//        msg9.setTimestamp(getTime(LocalDateTime.now().minusMinutes(18)));

        Message msg10 = new Message();
        msg10.setChannelId(3L);
        msg10.setUser(savedUsers.get(6));
        msg10.setText("Thanks, Heidi! I'll look into Redux.");
//        msg10.setTimestamp(getTime(LocalDateTime.now().minusMinutes(16)));

        Message msg11 = new Message();
        msg11.setChannelId(3L);
        msg11.setUser(savedUsers.get(8));
        msg11.setText("You could also consider Context API for simpler use cases.");
//        msg11.setTimestamp(getTime(LocalDateTime.now().minusMinutes(14)));

        List<Message> messages = Arrays.asList(
            msg0, msg1, msg2, msg3, msg4, msg5, msg6, msg7, msg8, msg9, msg10, msg11
        );
        messages.forEach(messageService::save);
    }

    private static String getTime(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern("HH:mm a"));
    }
}