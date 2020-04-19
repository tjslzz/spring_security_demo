package com.spring.security.client_server.config;


import com.spring.common.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

@Configuration
public class OAuth2LoginConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.githubClientRegistration());
    }

    private ClientRegistration githubClientRegistration() {
        return ClientRegistration.withRegistrationId(Constants.REGISTRATION_ID)
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .clientId(Constants.CLIENT_ID)
                .clientSecret(Constants.SECRET)
                .scope(Constants.SCOPES)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUriTemplate(Constants.REDIRECT_URL)
                .authorizationUri(Constants.AUTHORIZATION_URL)
                .tokenUri(Constants.TOKEN_URL)
                .userInfoUri(Constants.USER_URL)
                .userNameAttributeName(Constants.USER_NAME_ATTRIBUTE)
                .build();
    }
}
