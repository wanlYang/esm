package com.wanl.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring security 自定义密码加密
 * @author Yang
 *
 */
public class MD5PasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		return Base64Util.decoder(MD5Util.MD5Encode((String) rawPassword));
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.equals(Base64Util.decoder(MD5Util.MD5Encode((String) rawPassword)));
	}
	
}
