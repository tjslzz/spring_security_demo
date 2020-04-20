package com.spring.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

import java.util.LinkedHashMap;
import java.util.Map;


public class UserAuthenticationConverterUtil extends DefaultUserAuthenticationConverter {

    public UserAuthenticationConverterUtil() {
        super();
    }

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        Map<String, Object> response = new LinkedHashMap();
        response.put("user_name", authentication.getName());
        if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
            response.put("authorities", CommonUtil.convertAuthoritiesToString(authentication.getAuthorities()));
        }
        if (authentication.getDetails() != null) {
            response.put("details", authentication.getDetails());
        }

        return response;
    }
}
