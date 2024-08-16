package com.sarthak.secure.config.provider;

import com.sarthak.secure.config.authentication.ApiKeyAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@AllArgsConstructor
public class ApiAuthenticationProvider implements AuthenticationProvider {

    private final String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApiKeyAuthentication  apiKeyAuthentication = (ApiKeyAuthentication) authentication;

        if (key.equals(apiKeyAuthentication.key())) {
            apiKeyAuthentication.setAuthenticated(true);
            return authentication;
        }

        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthentication.class.equals(authentication);
    }
}
