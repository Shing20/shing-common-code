package org.shing.common.code;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: LogAround
 * @Description: 环绕增强，目标方法的前后都可以执行，功能最大！ 可以获取，修改目标方法的参数，返回值，异常处理，是否执行
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-28 1:45:48
 */
public class LogAround implements MethodInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(Class.class);

	/**
	 * @Title: invoke
	 * @Description: invoke
	 * @author: Shing
	 * @date: 2020-7-28 1:53:18
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {

		// 代理对象
		Object target = invocation.getThis();
		Method method = invocation.getMethod();
		Object[] args = invocation.getArguments();
		logger.info("method={},args={},target={}", method.getName(), args, target);
		try {
			// 目标方法
			Object retultObject = invocation.proceed();
			logger.info("method={},args={},target={},retultObject={}", method.getName(), args, target, retultObject);
			return retultObject;
		} catch (Exception e) {
			logger.error("method={},e={}", method.getName(), e);
			throw e;
		}
	}
}
