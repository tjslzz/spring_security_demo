package com.spring.common.utils;

import com.spring.common.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

public class CommonUtil {


    public static String convertAuthoritiesToString(Collection<? extends GrantedAuthority> authorities) {
        Object[] authorityList = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()).toArray();
        return StringUtils.join(authorityList, Constants.SEPARATOR);
    }

}
