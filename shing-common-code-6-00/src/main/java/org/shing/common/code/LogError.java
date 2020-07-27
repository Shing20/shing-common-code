package org.shing.common.code;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

/**
 * @ClassName: LogError
 * @Description: 异常抛出增强,目标方法抛出异常时执行
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-28 1:36:55
 */
public class LogError implements ThrowsAdvice {

	private static final Logger logger = LoggerFactory.getLogger(Class.class);

	/**
	 * @Title: afterThrowing
	 * @Description: afterThrowing
	 * @author: Shing
	 * @param e 为必选,其它要么都提供，要么一个也不提供,方法名，参数是固定的
	 * @date: 2020-7-28 1:42:25
	 * @return: void
	 */
	public void afterThrowing(Method method, Object[] args, Object target, RuntimeException e) throws Throwable {

		logger.error("failed method name={},ex={}", method.getName(), e);
	}
}
