package org.shing.common.code.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: SysLog
 * @Description: 注解增强.SysLog为切面, 切入点execution(* org.shing.common.code.service..*(..)
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-31 0:42:50
 */
@Aspect
public class SysLog {

	private static final Logger logger = LoggerFactory.getLogger(Class.class);

	/**
	 * @Title: before
	 * @Description: 前置(匹配此包及子包下所有类的所有方法)
	 * @author: Shing
	 * @date: 2020-7-31 0:54:02
	 * @return: void
	 */
	@Before("execution(* org.shing.common.code.service..*(..)")
	public void before(JoinPoint joinPoint) {

		logger.info("method={},args={},target={}", joinPoint.getSignature().getName(), joinPoint.getArgs(),
				joinPoint.getTarget());
	}

	/** 
	 * @Title: afterReturning 
	 * @Description: 返回值给returnValue
	 * @author: Shing
	 *   
	 * @date: 2020-7-31 1:09:23 
	 * @return: void
	 */
	@AfterReturning(pointcut = "execution(* org.shing.common.code.service..*(..))",returning ="returnValue")
	public void afterReturning(JoinPoint joinPoint, Object returnValue) {

		logger.info("returnValue={},method={},args={},target={}", returnValue, joinPoint.getSignature().getName(), joinPoint.getArgs(),
				joinPoint.getTarget());
	}
}
