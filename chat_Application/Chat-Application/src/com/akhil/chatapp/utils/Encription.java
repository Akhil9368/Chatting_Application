package com.akhil.chatapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encription {
	public  static String  passswordEncrypt(String plainPassword) throws NoSuchAlgorithmException{
		String encryptedpassword= null;
		// for hidding the password mens only user can know the password;
		//MD5 is a hasing 
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(plainPassword.getBytes());
		byte [] encrypt = messageDigest.digest();
		StringBuffer sb = new StringBuffer();
		for(byte b : encrypt) {
			sb.append(b);
		}
		encryptedpassword = new String(encrypt);
		
		return encryptedpassword;
		
	}
	

}
