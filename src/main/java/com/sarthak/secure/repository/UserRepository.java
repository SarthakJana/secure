package com.sarthak.secure.repository;

import com.sarthak.secure.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepository {

    private static final String NAME = "Sarthak";

    public Optional<User> findByUserName(String name) {
        return Optional.of(name)
                .filter(n -> n.equals(NAME))
                .map(n -> new User(n, "1234"));
    }
}
