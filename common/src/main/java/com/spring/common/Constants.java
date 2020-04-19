package com.spring.common;

public class Constants {

    /*
    !import
    please update your hosts file in C:/windows/System32\drivers\etc
    127.0.0.1 auth.server.com
    127.0.0.1 client.server.com
    127.0.0.1 resource.server.com
    127.0.0.1 third.party.com
     */
    private static final String AUTH_PORT = "8001";
    private static final String RESOURCE_PORT = "8002";
    private static final String CLIENT_PORT = "8003";

    public static final String STR_LINE = "_";
    public static final String ASSERT_MESSAGE = "非验证类型";
    public static final String INVALID_USER = "用户名/密码无效";

    public static final String USER_NAME_ATTRIBUTE = "name";
    public static final String CLIENT_ID = "CLIENT_ID";
    public static final String RESOURCE_ID = "RESOURCE_ID";
    public static final String REGISTRATION_ID = "REGISTRATION_ID";
    public static final String SECRET = "SECRET";
    public static final String SCOPES = "SCOPES";
    public static final String PERMIT_TOKEN = "permitAll()";
    public static final String AUTHENTICATED_TOKEN = "isAuthenticated()";
    public static final String REDIRECT_URL = "http://client.server.com:" + CLIENT_PORT + "/login/oauth2/code/" +REGISTRATION_ID;
    public static final String AUTHORIZATION_URL = "http://auth.server.com:"+AUTH_PORT+"/oauth/authorize";
    public static final String TOKEN_URL = "http://auth.server.com:"+AUTH_PORT+"/oauth/token";
    public static final String CHECK_TOKEN_URL = "http://auth.server.com:"+AUTH_PORT+"/oauth/check_token";
    public static final String USER_URL = "http://resource.server.com:"+RESOURCE_PORT+"/oauth/user";

    private Constants() {
    }
}
