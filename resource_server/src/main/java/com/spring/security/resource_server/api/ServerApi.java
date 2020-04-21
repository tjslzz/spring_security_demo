package com.spring.security.resource_server.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("oauth")
@CrossOrigin(origins = "*", maxAge = 1000L)
public class ServerApi {

    @GetMapping("user")
    public Object user(Principal principal) {
        return principal;
    }

}
