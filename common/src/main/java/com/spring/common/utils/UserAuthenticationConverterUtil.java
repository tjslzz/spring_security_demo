package com.spring.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

import java.util.LinkedHashMap;
import java.util.Map;


public class UserAuthenticationConverterUtil extends DefaultUserAuthenticationConverter {

    private static final String USER_NAME = "user_name";
    private static final String AUTHORITIES = "authorities";
    private static final String DETAILS = "details";

    public UserAuthenticationConverterUtil() {
        super();
    }

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put(USER_NAME, authentication.getName());
        if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
            response.put(AUTHORITIES, CommonUtil.convertAuthoritiesToString(authentication.getAuthorities()));
        }
        if (authentication.getDetails() != null) {
            response.put(DETAILS, authentication.getDetails());
        }

        return response;
    }
}
