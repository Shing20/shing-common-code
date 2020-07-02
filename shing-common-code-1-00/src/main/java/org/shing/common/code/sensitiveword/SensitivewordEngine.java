package org.shing.common.code.sensitiveword;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 敏感词过滤工具类
 * 
 * @author AlanLee
 *  原文：https://www.cnblogs.com/AlanLee/p/5329555.html
 */
public class SensitivewordEngine {

	/**
	 * 只过滤最小敏感词
	 */
	public static int minMatchTYpe = 1;

	/**
	 * 过滤所有敏感词
	 */
	public static int maxMatchType = 2;

	/**
	 * 敏感词库敏感词数量
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static int getWordSize(Map sensitiveWordMap) {
		if (sensitiveWordMap == null) {
			return 0;
		}
		return sensitiveWordMap.size();
	}

	/**
	 * 是否包含敏感词
	 * 
	 * @param txt
	 * @param matchType
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isContaintSensitiveWord(String txt, int matchType, Map sensitiveWordMap) {
		boolean flag = false;
		for (int i = 0; i < txt.length(); i++) {
			int matchFlag = checkSensitiveWord(txt, i, matchType, sensitiveWordMap);
			if (matchFlag > 0) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 获取敏感词内容
	 * 
	 * @param txt
	 * @param matchType
	 * @return 敏感词内容
	 */
	@SuppressWarnings("rawtypes")
	public static Set<String> getSensitiveWord(String txt, int matchType, Map sensitiveWordMap) {
		Set<String> sensitiveWordList = new HashSet<String>();

		for (int i = 0; i < txt.length(); i++) {
			int length = checkSensitiveWord(txt, i, matchType, sensitiveWordMap);
			if (length > 0) {
				// 将检测出的敏感词保存到集合中
				sensitiveWordList.add(txt.substring(i, i + length));
				i = i + length - 1;
			}
		}

		return sensitiveWordList;
	}

	/**
	 * 替换敏感词
	 * 
	 * @param txt
	 * @param matchType
	 * @param replaceChar
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String replaceSensitiveWord(String txt, int matchType, String replaceChar, Map sensitiveWordMap) {
		String resultTxt = txt;
		Set<String> set = getSensitiveWord(txt, matchType, sensitiveWordMap);
		Iterator<String> iterator = set.iterator();
		String word = null;
		String replaceString = null;
		while (iterator.hasNext()) {
			word = iterator.next();
			replaceString = getReplaceChars(replaceChar, word.length());
			resultTxt = resultTxt.replaceAll(word, replaceString);
		}

		return resultTxt;
	}

	/**
	 * 替换敏感词内容
	 * 
	 * @param replaceChar
	 * @param length
	 * @return
	 */
	private static String getReplaceChars(String replaceChar, int length) {
		String resultReplace = replaceChar;
		for (int i = 1; i < length; i++) {
			resultReplace += replaceChar;
		}

		return resultReplace;
	}

	/**
	 * 检查敏感词数量
	 * 
	 * @param txt
	 * @param beginIndex
	 * @param matchType
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static int checkSensitiveWord(String txt, int beginIndex, int matchType, Map sensitiveWordMap) {
		boolean flag = false;
		// 记录敏感词数量
		int matchFlag = 0;
		char word = 0;
		for (int i = beginIndex; i < txt.length(); i++) {
			word = txt.charAt(i);
			// 判断该字是否存在于敏感词库中
			sensitiveWordMap = (Map) sensitiveWordMap.get(word);
			if (sensitiveWordMap != null) {
				matchFlag++;
				// 判断是否是敏感词的结尾字，如果是结尾字则判断是否继续检测
				if ("1".equals(sensitiveWordMap.get("isEnd"))) {
					flag = true;
					// 判断过滤类型，如果是小过滤则跳出循环，否则继续循环
					if (SensitivewordEngine.minMatchTYpe == matchType) {
						break;
					}
				}
			} else {
				break;
			}
		}
		if (!flag) {
			matchFlag = 0;
		}
		return matchFlag;
	}

}