package com.coderscampus.repository;

import com.coderscampus.domain.Message;
import com.coderscampus.domain.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MessageRepository {
    private final List<Message> messages = new ArrayList<>();
    private final UserRepository userRepo;
    private Long count = 1L;

    public MessageRepository(UserRepository userRepo) {
        this.userRepo = userRepo;
        initializeMessages();
    }

    public Message save(Message message) {
        if (message.getId() == null) {
            message.setId(count++);
        }
        messages.add(message);
        return message;
    }

    public List<Message> findAll() {
        return messages;
    }

    public List<Message> findById(Long id) {
        return messages.stream()
                .filter(message -> message.getChannelId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Message> findByChannelId(Long id) {
        return messages.stream()
                .filter(message -> message.getChannelId().equals(id))
                .collect(Collectors.toList());
    }

    public void initializeMessages() {
        if (findAll().isEmpty()) {
            List<User> users = Arrays.asList(
                new User("Alice"),  new User("Bob"),  new User("Charli"),
                new User("Dave"),  new User("Eve"),  new User("Frank"),
                new User("Grace"),  new User("Heidi"),  new User("Ivan")
            );

            List<User> savedUsers = users.stream().map(userRepo::save).toList();

            Message msg0 = new Message(1L, savedUsers.get(0), "Hey, does anyone know a good resource for learning full-stack development?");
            msg0.setTimestamp(LocalDateTime.now().minusMinutes(10));

            Message msg1 = new Message(1L, savedUsers.get(1), "Sure, freeCodeCamp is a great place to start.");
            msg1.setTimestamp(LocalDateTime.now().minusMinutes(8));

            Message msg2 = new Message(1L, savedUsers.get(0), "Thanks, Bob! I'll check it out.");
            msg2.setTimestamp(LocalDateTime.now().minusMinutes(7));

            Message msg3 = new Message(1L, savedUsers.get(2), "Don't forget about MDN Web Docs for reference.");
            msg3.setTimestamp(LocalDateTime.now().minusMinutes(5));

            Message msg4 = new Message(2L, savedUsers.get(3), "Can someone explain the differences between JDK, JRE, and JVM?");
            msg4.setTimestamp(LocalDateTime.now().minusMinutes(15));

            Message msg5 = new Message(2L, savedUsers.get(4), "JDK is the development kit, JRE is the runtime environment, and JVM is the virtual machine that runs Java bytecode.");
            msg5.setTimestamp(LocalDateTime.now().minusMinutes(12));

            Message msg6 = new Message(2L, savedUsers.get(3), "Got it, thanks Eve!");
            msg6.setTimestamp(LocalDateTime.now().minusMinutes(10));

            Message msg7 = new Message(2L, savedUsers.get(5), "For detailed info, check out the official Oracle documentation.");
            msg7.setTimestamp(LocalDateTime.now().minusMinutes(5));

            Message msg8 = new Message(3L, savedUsers.get(6), "What's the best way to manage state in a large React application?");
            msg8.setTimestamp(LocalDateTime.now().minusMinutes(20));

            Message msg9 = new Message(3L, savedUsers.get(7), "I recommend using Redux for state management.");
            msg9.setTimestamp(LocalDateTime.now().minusMinutes(18));

            Message msg10 = new Message(3L, savedUsers.get(6), "Thanks, Heidi! I'll look into Redux.");
            msg10.setTimestamp(LocalDateTime.now().minusMinutes(16));

            Message msg11 = new Message(3L, savedUsers.get(8), "You could also consider Context API for simpler use cases.");
            msg11.setTimestamp(LocalDateTime.now().minusMinutes(14));

            List<Message> messages = Arrays.asList(
                    msg0, msg1, msg2, msg3, msg4, msg5, msg6, msg7, msg8, msg9, msg10, msg11
            );
            messages.forEach(this::save);
        }
    }
}
