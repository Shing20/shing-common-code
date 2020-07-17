package org.shing.common.code;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * @ClassName: JsonTobean
 * @Description: JsonTobean json转换Java对象
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-17 10:44:06
 */
public class JsonTobeanUtil {
	private static final Logger logger = LoggerFactory.getLogger(Class.class);

	/**
	 * @Title: jsonToConvertBean
	 * @Description: jsonToConvertBean
	 * @param jsons
	 * @author: Shing
	 * @date: 2020-7-17 10:56:14
	 * @return: List<T>
	 */
	public static <T> List<T> jsonToConvertBean(String jsons) {
		List<T> list = null;
		try {
			JSONObject jsonObjects = JSON.parseObject(jsons);
			list = JSON.parseObject(String.valueOf(jsonObjects.get("Data")), new TypeReference<List<T>>() {
			});

		} catch (Exception e) {
			logger.error("failed e={}", e);
		}
		return list;

	}
}
