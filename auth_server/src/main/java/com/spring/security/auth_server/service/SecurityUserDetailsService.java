package com.spring.security.auth_server.service;

import com.spring.common.Constants;
import com.spring.common.utils.CommonUtil;
import com.spring.security.auth_server.entity.UserDetail;
import com.spring.security.auth_server.entity.UserPermission;
import com.spring.security.auth_server.entity.UserRole;
import com.spring.security.auth_server.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserDetailRepository userDetailRepository;

    @Autowired
    public SecurityUserDetailsService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<UserDetail> userDetails = userDetailRepository.findAllByUserName(userName);
        if (CollectionUtils.isEmpty(userDetails)) {
            return null;
        }
        UserDetail userDetail = userDetails.get(0);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole userRole : userDetail.getUserRoles()) {
            for (UserPermission userPermission : userRole.getUserPermissions()) {
                authorities.add(new SimpleGrantedAuthority(userRole.getRoleName() + Constants.STR_LINE + userPermission.getPermissionName()));
            }
        }
        return new User(userDetail.getUserName(), userDetail.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(CommonUtil.convertAuthoritiesToString(authorities))));
    }
}
