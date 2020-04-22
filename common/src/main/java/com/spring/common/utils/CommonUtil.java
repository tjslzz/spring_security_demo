package com.spring.common.utils;

import com.spring.common.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CommonUtil {

    private CommonUtil() {
    }

    public static String convertAuthoritiesToString(Collection<? extends GrantedAuthority> authorities) {
        Object[] authorityList = authorities.stream().map(GrantedAuthority::getAuthority).toArray();
        return StringUtils.join(authorityList, Constants.SEPARATOR);
    }

}
