package com.wanl.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Encoder;

/**
 * Base64加密
 * @author Yang
 *
 */
public class Base64Util {

	//private final static Decoder decoder = Base64.getDecoder();
	private final static Encoder encoder = Base64.getEncoder(); 
	
	public static String decoder(String data){
	    byte[] dataBytes = null;
        try {
            dataBytes = data.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
		String encode = encoder.encodeToString(dataBytes);
		return encode;
	}
}
