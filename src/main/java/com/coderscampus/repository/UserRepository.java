package com.coderscampus.repository;

import com.coderscampus.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private Long count = 1L;

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(count++);
        }
        users.put(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        Optional<User> optUser = users.values().stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
        return optUser.orElse(null);
    }
}
