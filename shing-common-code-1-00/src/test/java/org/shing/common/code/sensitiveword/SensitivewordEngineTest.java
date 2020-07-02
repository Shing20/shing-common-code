package org.shing.common.code.sensitiveword;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: SensitivewordEngineTest
 * @Description: SensitivewordEngineTest
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-2 16:16:35
 */
public class SensitivewordEngineTest {
	private static final Logger logger = LoggerFactory.getLogger(SensitivewordEngineTest.class);

	/**
	 * @Title: sensitiveWord
	 * @Description: sensitiveWord
	 * @author: Shing
	 * @date: 2020-7-2 16:18:08
	 * @return: void
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void sensitiveWord() {
		// 原文:https://www.cnblogs.com/AlanLee/p/5329555.html
		// 初始化敏感词库对象
		SensitiveWordInit sensitiveWordInit = new SensitiveWordInit();
		// 从数据库中获取敏感词对象集合（调用的方法来自Dao层，此方法是service层的实现类）
		List<String> sensitiveWords = new ArrayList<String>();

		String words = "Shing";
		// 测试用，实际运用中删除
		for (int i = 0; i < 9999; i++) {
			sensitiveWords.add(String.valueOf(words.charAt((int) (Math.random() * words.length())))
					+ String.valueOf(words.charAt((int) (Math.random() * words.length())))
					+ String.valueOf(words.charAt((int) (Math.random() * words.length()))));
		}

		sensitiveWords.add("Shing");
		// 构建敏感词库
		Map sensitiveWordMap = sensitiveWordInit.initKeyWord(new HashSet<String>(sensitiveWords));

		logger.info("敏感关键词数量：" + sensitiveWords.size());
		// 得到敏感词有哪些，传入2表示获取所有敏感词
		Set<String> set = SensitivewordEngine.getSensitiveWord("Shing", 2, sensitiveWordMap);
		logger.info(CollectionUtils.isEmpty(set) ? "未匹配到敏感词" : "匹配的关键词为" + set.toString());

		Set<String> set1 = SensitivewordEngine.getSensitiveWord("Shing20", 1, sensitiveWordMap);
		logger.info(CollectionUtils.isEmpty(set1) ? "未匹配到敏感词" : "匹配的关键词为" + set1.toString());
	}

}
