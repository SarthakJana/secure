package com.sarthak.secure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greetings")
public class GreetingsController {

    public static final Logger LOGGER = LoggerFactory.getLogger(GreetingsController.class);

    @GetMapping()
    public ResponseEntity<String> sayHello() {

        String authorities = SecurityContextHolder.getContext().getAuthentication()
                .getAuthorities().stream().findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElse("None");

        LOGGER.info("User authorities: {}", authorities);

        return ResponseEntity.ok("Hello from secure");
    }

    @GetMapping("/say-good-bye")
    public ResponseEntity<String> sayGoodBye() {
        return ResponseEntity.ok("Good bye and see you later");
    }
}
