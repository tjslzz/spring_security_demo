package com.spring.security.client_server.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping
public class CustomerController {

    @GetMapping
    public Principal getCustomer(Principal principal) {
        return principal;
    }

}
