package com.lwang.tools;


import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class SignatureUtil {

	private static final String IV_STRING = "16-Bytes--String";
	private static final String JIAMI = "aaabbbcccdddeee";

	public static String encryptAES(String content, String key) throws Exception {
		byte[] byteContent = content.getBytes("UTF-8");
		// 注意，为了能与 iOS 统一
		// 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
		byte[] enCodeFormat = key.getBytes();
		SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
		byte[] initParam = IV_STRING.getBytes();
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
		// 指定加密的算法、工作模式和填充方式
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		byte[] encryptedBytes = cipher.doFinal(byteContent);
		// 同样对加密后数据进行 base64 编码
		return Base64.encodeToString(encryptedBytes, Base64.DEFAULT);
	}


	public static String decryptAES(String content, String key) throws Exception {
		// base64 解码
		byte[] encryptedBytes = Base64.decode(content, Base64.DEFAULT);
		byte[] enCodeFormat = key.getBytes();
		SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
		byte[] initParam = IV_STRING.getBytes();
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		byte[] result = cipher.doFinal(encryptedBytes);
		return new String(result, "UTF-8");
	}


	/**
	 * 传过来一个原数据 我得到它的MD5值
	 *
	 * @param body
	 * @return
	 */
	public static String getMD5(String body) {

		String itbody = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");

			// 加密的过程我们不用关心 只需要拿到结果即可
			byte[] digest = md5.digest((body + JIAMI).getBytes());

			StringBuilder sb = new StringBuilder();
			// 将加密出来的内容遍历
			for (int i = 0; i < digest.length; i++) {
				byte b = digest[i];

				// 先转换成正数
				int single = b & 0xFF;
				// 将每个字节转换成16进制
				String hex = Integer.toHexString(single);
				if (hex.length() == 1) {
					hex = "0" + hex;
				}
				sb.append(hex);
			}

			// 获得最终加密的结果
			itbody = sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return itbody;
	}

	/**
	 * 对文件进行 MD5 加密
	 *
	 * @return
	 */
	public static String md5File(File file) {

		try {

			InputStream fin = new FileInputStream(file);

			MessageDigest md5 = MessageDigest.getInstance("md5");

			// 将输入流中的内容，读取至加密器
			int len = -1;
			byte[] buffer = new byte[512];

			while ((len = fin.read(buffer)) != -1) {
				// 将读到的内容，更新至加密器
				md5.update(buffer, 0, len);
			}

			// 加密的过程我们不用关心 只需要拿到结果即可
			byte[] digest = md5.digest();

			StringBuilder sb = new StringBuilder();
			// 将加密出来的内容遍历
			for (int i = 0; i < digest.length; i++) {
				byte b = digest[i];

				// 先转换成正数
				int single = b & 0xFF;
				// 将每个字节转换成16进制
				String hex = Integer.toHexString(single);
				if (hex.length() == 1) {
					hex = "0" + hex;
				}
				sb.append(hex);
			}

			// 获得最终加密的结果,并返回
			String encryptBody = sb.toString();

			return encryptBody;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



}
