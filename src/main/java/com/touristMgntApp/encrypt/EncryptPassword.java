package com.touristMgntApp.encrypt;

import java.security.InvalidKeyException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptPassword {

	static Cipher cipher;

	public static String encrypt(String plainText, SecretKey secretKey) {
		byte[] plainTextByte = plainText.getBytes();
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		} catch (InvalidKeyException e) {
             e.getMessage();
		}
		byte[] encryptedByte = null;
		try {
			encryptedByte = cipher.doFinal(plainTextByte);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.getMessage();
		}
		Base64.Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(encryptedByte);
	}

	public static String decrypt() throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128); // block size is 128bits
		SecretKey secretKey = keyGenerator.generateKey();
		cipher = Cipher.getInstance("AES");

		String encryptString = encrypt("oracle", secretKey);
		byte[] encryptedTextByte = decoder.decode(encryptString);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		return new String(decryptedByte);
	}

	public static void main(String[] args) {
		try {
			System.out.println(decrypt());
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
