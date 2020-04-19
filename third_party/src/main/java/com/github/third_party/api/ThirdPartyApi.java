package com.github.third_party.api;

import com.alibaba.fastjson.JSONObject;
import com.github.third_party.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class ThirdPartyApi {

    @GetMapping
    public Object getUser() {
        OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        OAuth2User principal = authentication.getPrincipal();
        Map<String, Object> attributes = principal.getAttributes();
        return JSONObject.parseObject(JSONObject.toJSONString(attributes), User.class);
    }

}
