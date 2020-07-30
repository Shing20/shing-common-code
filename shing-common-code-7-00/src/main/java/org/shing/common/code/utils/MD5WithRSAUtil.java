package org.shing.common.code.utils;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

/** 
 * @ClassName: MD5WithRSAUtil 
 * @Description: MD5WithRSAUtil(项目中的工具)
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-30 22:28:27  
 */
public class MD5WithRSAUtil {

	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
	private static final String PUBLIC_KEY = "RSAPublicKey";
	private static final String PRIVATE_KEY = "RSAPrivateKey";
	public static final String CHARSET = "UTF-8";

	// 公钥验签
	public static boolean validateSignByPublicKey(Map<String, String> params, String rsaPublicKey) throws Exception {

		if (null == params || params.isEmpty() || StringUtils.isEmpty(rsaPublicKey)) {
			return false;
		}
		String returnSign = params.remove("sign");
		if (StringUtils.isEmpty(returnSign)) {
			returnSign = params.remove("sign_info");
		}
		String signStr = generateSignStr(params);
		return validateSignByPublicKey(signStr, rsaPublicKey, returnSign);
	}

	// 私钥签名
	public static String signByPrivateKey(Map<String, String> params, String rsaPrivateKey) throws Exception {

		if (null == params || params.isEmpty() || StringUtils.isEmpty(rsaPrivateKey)) {
			return null;
		}
		String signStr = generateSignStr(params);
		return signByPrivateKey(signStr, rsaPrivateKey);
	}

	public static String generateSignStr(Map<String, String> params) throws Exception {

		params.remove("sign_type");
		Map<String, String> resultMap = null;
		if (params instanceof TreeMap) {
			resultMap = params;
		} else {
			resultMap = new TreeMap<String, String>(params);
		}
		StringBuilder signStr = new StringBuilder();
		for (Map.Entry<String, String> paramsEntry : resultMap.entrySet()) {
			String value = paramsEntry.getValue();
			if (StringUtils.isNotEmpty(value)) {
				signStr.append(paramsEntry.getKey()).append("=").append(value).append("&");
			}
		}
		return signStr.substring(0, signStr.length() - 1);
	}

	public static String signByPrivateKey(String data, String privateKey) throws Exception {

		byte[] keyBytes = Base64.getDecoder().decode(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privateK);
		signature.update(data.getBytes(CHARSET));
		return new String(Base64.getEncoder().encode(signature.sign())).replaceAll("\n", "").replaceAll("\r\n", "");
	}

	public static boolean validateSignByPublicKey(String paramStr, String publicKey, String signedData)
			throws Exception {

		byte[] keyBytes = Base64.getDecoder().decode(publicKey);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey publicK = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(publicK);
		signature.update(paramStr.getBytes(CHARSET));
		return signature.verify(Base64.getDecoder().decode(signedData));
	}

	public static String getPublicKey(Map<String, Object> keyMap) throws Exception {

		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return encryptBASE64(key.getEncoded());
	}

	public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {

		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return encryptBASE64(key.getEncoded());
	}

	public static byte[] decryptBASE64(String key) throws Exception {

		return Base64.getDecoder().decode(key);
	}

	public static String encryptBASE64(byte[] key) throws Exception {

		return Base64.getEncoder().encodeToString(key);
	}

	public static Map<String, Object> initKey(Integer keySize) throws Exception {

		if (null == keySize) {
			keySize = 1024;
		}
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(keySize);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}
}
