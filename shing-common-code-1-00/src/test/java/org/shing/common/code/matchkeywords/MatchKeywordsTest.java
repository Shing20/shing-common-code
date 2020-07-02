package org.shing.common.code.matchkeywords;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: MatchKeywordsTest
 * @Description: MatchKeywordsTest
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-2 15:39:26
 */
public class MatchKeywordsTest {
	private static final Logger logger = LoggerFactory.getLogger(MatchKeywordsTest.class);

	/**
	 * @Title: matchKeywords
	 * @Description: Shing
	 * @author: Shing
	 * @date: 2020-7-2 16:12:40
	 * @return: void
	 */
	@Test
	public void matchKeywords() {
		logger.info("matchKeywords={}", MatchKeywords.matchKeywords("Shing", "Shing"));

	}

}
