package org.shing.common.code;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @ClassName: LogBefore
 * @Description: 前置增强，目标方法之前执行
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-28 1:25:27
 */
public class LogBefore implements MethodBeforeAdvice {

	private static final Logger logger = LoggerFactory.getLogger(Class.class);

	/**
	 * @Title: before
	 * @Description: before
	 * @author: Shing
	 * @param :target被代理的目标对象
	 * @param : method被代理的目标方法
	 * @param :args传递给目标方法的参数列表
	 * @date: 2020-7-28 1:26:39
	 */
	public void before(Method method, Object[] args, Object target) throws Throwable {

		logger.info("method={},args={},target={}", method.getName(), args, target);
	}
}
