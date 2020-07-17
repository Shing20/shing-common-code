package org.shing.common.code;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * @author Shing ---java <dependency> <groupId>com.alibaba</groupId>
 *         <artifactId>fastjson</artifactId> <version>1.2.61</version>
 *         </dependency>
 * 
 *         ----android <dependency> <groupId>com.alibaba</groupId>
 *         <artifactId>fastjson</artifactId> <version>1.1.71.android</version>
 *         </dependency>
 */
public class GroupJsonDemo {
	/*
	 * public static void main(String[] args) { String groupJson = "{\r\n" +
	 * "	\"Data\": [{\r\n" + "		\"groupId\": \"1214441484246323200\",\r\n" +
	 * "		\"groupName\": \"测试群1\",\r\n" +
	 * "		\"groupIntro\": \"嗯嗯哦\",\r\n" +
	 * "		\"groupPhoto\": \"https://imgsa.baidu.com/forum/w%3D580/sign=ecdc9fd5b88f8c54e3d3c5270a282dee/bfc5acefce1b9d16be77c35affdeb48f8c546458.jpg\",\r\n"
	 * + "		\"groupCreateId\": \"1578376781051\",\r\n" +
	 * "		\"maxCount\": 500,\r\n" + "		\"joinGroupVerify\": 0,\r\n" +
	 * "		\"groupType\": 0\r\n" + "	}, {\r\n" +
	 * "		\"groupId\": \"1214441484246323200\",\r\n" +
	 * "		\"groupName\": \"测试群1\",\r\n" +
	 * "		\"groupIntro\": \"嗯嗯哦\",\r\n" +
	 * "		\"groupPhoto\": \"https://imgsa.baidu.com/forum/w%3D580/sign=ecdc9fd5b88f8c54e3d3c5270a282dee/bfc5acefce1b9d16be77c35affdeb48f8c546458.jpg\",\r\n"
	 * + "		\"groupCreateId\": \"1578376781051\",\r\n" +
	 * "		\"maxCount\": 50,\r\n" + "		\"joinGroupVerify\": 0,\r\n" +
	 * "		\"groupType\": 0\r\n" + "	}],\r\n" + "	\"Str\": \"请求成功\",\r\n"
	 * + "	\"Code\": 0\r\n" + "}";
	 * 
	 * try { JSONObject groupJsonObject = JSON.parseObject(groupJson); List<Group>
	 * groupList = JSON.parseObject(groupJsonObject.get("Data").toString(), new
	 * TypeReference<List<Group>>() { }); for (Group group : groupList) {
	 * System.out.println(" start -----------------------------------------");
	 * System.out.println(group.getGroupCreateId());
	 * System.out.println(group.getGroupId());
	 * System.out.println(group.getGroupIntro());
	 * System.out.println(group.getGroupName());
	 * System.out.println(group.getGroupPhoto());
	 * System.out.println(group.getGroupType());
	 * System.out.println(group.getJoinGroupVerify());
	 * System.out.println(group.getMaxCount());
	 * System.out.println(" end -----------------------------------------");
	 * 
	 * } } catch (Exception e) { System.err.println("e---"+e); }
	 * 
	 * }
	 */}
