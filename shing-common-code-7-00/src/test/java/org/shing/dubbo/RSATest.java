package org.shing.dubbo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.shing.common.code.utils.MD5WithRSAUtil;

/**
 * @ClassName: RSATest
 * @Description: RSATest
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-30 22:30:10
 */
public class RSATest {

	/**
	 * @Title: getRSA
	 * @Description: getRSA
	 * @author: Shing
	 * @date: 2020-7-30 22:35:13
	 * @return: void
	 */
	@Test
	public void getRSA() {

		Map<String, Object> keyMap = null;
		try {
			// OR 2048
			keyMap = MD5WithRSAUtil.initKey(1024);
			String publicKey = MD5WithRSAUtil.getPublicKey(keyMap);
			String privateKey = MD5WithRSAUtil.getPrivateKey(keyMap);
			Map<String, String> rsaMap = new HashMap<String, String>();
			rsaMap.put("publicKey", publicKey);
			System.out.println(rsaMap.get("publicKey"));
			rsaMap.put("privateKey", privateKey);
			System.out.println(rsaMap.get("privateKey"));
		} catch (Exception e) {
			System.err.println("failed e={}" + e);
		}
	}
}
