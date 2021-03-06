package org.shing.common.code;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: GISUtilsTest 
 * @Description: GISUtilsTest
 * @author: Shing 公众号 ：香蜜湖的蜜。  慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-15 17:41:15  
 */
public class GISUtilsTest {
	private static final Logger logger = LoggerFactory.getLogger(Class.class);

	@Test
	public void gISUtilsTest() {
		logger.info("getAddressToLocation={}",
				GISUtils.getAddressToLocation("广州地铁5号线小北站A出入口"));

	}

}
