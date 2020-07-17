package org.shing.common.code;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;

/**
 * @ClassName: JsonTobeanUtilTest
 * @Description: TODO
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-17 11:29:46
 */
public class JsonTobeanUtilTest {
	private static final Logger logger = LoggerFactory.getLogger(Class.class);
	// 测试数据结构体
	private static final String jsons = "{\r\n" + "	\"Data\": [{\r\n"
			+ "		\"groupId\": \"1214441484246323200\",\r\n" + "		\"groupName\": \"测试群1\",\r\n"
			+ "		\"groupIntro\": \"嗯嗯哦\",\r\n"
			+ "		\"groupPhoto\": \"https://imgsa.baidu.com/forum/w%3D580/sign=ecdc9fd5b88f8c54e3d3c5270a282dee/bfc5acefce1b9d16be77c35affdeb48f8c546458.jpg\",\r\n"
			+ "		\"groupCreateId\": \"1578376781051\",\r\n" + "		\"maxCount\": 500,\r\n"
			+ "		\"joinGroupVerify\": 0,\r\n" + "		\"groupType\": 0\r\n" + "	}, {\r\n"
			+ "		\"groupId\": \"1214441484246323200\",\r\n" + "		\"groupName\": \"测试群1\",\r\n"
			+ "		\"groupIntro\": \"嗯嗯哦\",\r\n"
			+ "		\"groupPhoto\": \"https://imgsa.baidu.com/forum/w%3D580/sign=ecdc9fd5b88f8c54e3d3c5270a282dee/bfc5acefce1b9d16be77c35affdeb48f8c546458.jpg\",\r\n"
			+ "		\"groupCreateId\": \"1578376781051\",\r\n" + "		\"maxCount\": 50,\r\n"
			+ "		\"joinGroupVerify\": 0,\r\n" + "		\"groupType\": 0\r\n" + "	}],\r\n"
			+ "	\"Str\": \"请求成功\",\r\n" + "	\"Code\": 0\r\n" + "}";

	@Test
	public void jsonToConvertBeanTest() {
		try {
			List<Object> str = JsonTobeanUtil.jsonToConvertBean(jsons);
			List<Group> list = JSONArray.parseArray(str.toString(), Group.class);
			for (Group group : list) {
				logger.info("group lsit={} ",group);
			}

		} catch (Exception e) {
			logger.error("failed e={}", e);
		}

	}

}
