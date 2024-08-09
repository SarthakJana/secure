package com.sarthak.secure.controller.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${app.secret}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication customAuthentication;

        if (authentication instanceof CustomAuthentication) {
            customAuthentication = (CustomAuthentication) authentication;

            if (customAuthentication.key().equals(key))
                return new CustomAuthentication(null, true);
        }


        throw new BadCredentialsException("Unauthorized");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
