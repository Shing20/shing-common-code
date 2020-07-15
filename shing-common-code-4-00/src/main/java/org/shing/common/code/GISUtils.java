package org.shing.common.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: GISUtils
 * @Description: 地理信息工具
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-15 15:53:25
 */

public class GISUtils {
	private static final Logger logger = LoggerFactory.getLogger(Class.class);
	// ak要换成自己
	private static final String BAIDU_API = "http://api.map.baidu.com/place/v2/search?ak=gCDZRCoQWP5SQGlbBd7Cz7lLp090T8f5&output=json&query=%s&region=全国";

	/**
	 * @Title: getAddressToLocation
	 * @Description: 地理反向编码，根据经纬度获取地址
	 * @author: Shing
	 * @date: 2020-7-15 16:20:19
	 * @return: Map<String,BigDecimal>
	 */
	public static Map<String, BigDecimal> getAddressToLocation(String addr) {

		StringBuffer stringBuffer = new StringBuffer();
		Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();

		try {

			post(stringBuffer, addr);

			JSONObject resultJson = JSON.parseObject(stringBuffer.toString());
			JSONArray jsonArray = (JSONArray) resultJson.get("results");
			if (null == jsonArray || jsonArray.size() == 0) {
				logger.error("jsonArray is null");
				return null;
			}

			logger.info("resultJson ={}", jsonArray);
			JSONObject results0Obj = (JSONObject) jsonArray.get(0);
			JSONObject locationObj = (JSONObject) results0Obj.get("location");

			if (locationObj == null) {

				logger.error("locationObj is null");
				return null;
			}

			map.put("lng", (BigDecimal) locationObj.get("lat"));
			map.put("lat", (BigDecimal) locationObj.get("lng"));

		} catch (Exception e) {
			logger.error("failed e={}", e);
		}
		return map;

	}

	/**
	 * @Title: post
	 * @Description: post
	 * @author: Shing
	 * @date: 2020-7-15 17:19:01
	 * @return: StringBuffer
	 */
	private static StringBuffer post(StringBuffer stringBuffer, String addr) {

		InputStreamReader insr = null;
		BufferedReader br = null;
		try {

			String address = java.net.URLEncoder.encode(addr, "UTF-8");
			String url = String.format(BAIDU_API, address);
			// 进行转码
			URL URLCode = new URL(url);
			URLConnection urlConnection = (URLConnection) URLCode.openConnection();
			if (null == urlConnection) {
				logger.error("httpsConn is null");
				return null;
			}
			insr = new InputStreamReader(urlConnection.getInputStream(), "UTF-8");
			br = new BufferedReader(insr);
			String data = null;
			while ((data = br.readLine()) != null) {
				stringBuffer.append(data);
			}

		} catch (Exception e) {
			logger.error("failed e={}", e);
		} finally {

			try {
				if (null != br) {
					br.close();
				}
			} catch (Exception e2) {
				logger.error("failed e2={}", e2);
			}

			try {
				if (null != insr) {
					insr.close();
				}
			} catch (Exception e2) {
				logger.error("failed e2={}", e2);
			}
		}
		return stringBuffer;
	}

}
