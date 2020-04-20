package com.spring.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class UserPrincipal implements Principal {


    private List<String> aud = new ArrayList<>();
    private String userName;
    private List<String> scope = new ArrayList<>();

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
}
