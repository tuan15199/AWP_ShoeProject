package com.project.springSecurity;

public class JwtProperties {
	public static final String SECRET = "hihiThisIsSecretKey";
	public static final int EXPIRATION_TIME = 7200000; // 2 hours
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
}
