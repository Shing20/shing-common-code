package org.shing.common.code.matchkeywords;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: MatchKeywords
 * @Description: 关键字匹配
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-2 12:10:37
 */

public class MatchKeywords {

	/**
	 * @Title: matchKeywords
	 * @Description: matchKeywords
	 * @author: Shing
	 * @date: 2020-7-2 13:29:26
	 * @param words    输入的字
	 * @param keywords 固定的关键字
	 * @return boolean true 匹配到了：false 未匹配到
	 */
	public static boolean matchKeywords(String words, String keywords) {

		Pattern pattern = Pattern.compile(keywords);
		Matcher matcher = pattern.matcher(words);
		if (matcher.find()) {
			return true;
		}
		return false;

	}

}
