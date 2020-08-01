package org.shing.common.code.annotation;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	private static final Logger logger = LoggerFactory.getLogger(SysLog.class);

	/**
	 * @Title: before
	 * @Description: 前置(匹配此包及子包下所有类的所有方法)
	 * @author: Shing
	 * @date: 2020-7-31 0:54:02
	 * @return: void
	 */
	@Before("execution(* org.shing.common.code.service..*(..))")
	public void before(JoinPoint joinPoint) {

		logger.info("before---,method={},target={},args={}", joinPoint.getSignature().getName(), joinPoint.getTarget(),
				Arrays.toString(joinPoint.getArgs()));
	}

	/**
	 * @Title: afterReturning
	 * @Description: 返回值给returnValue
	 * @author: Shing
	 * @date: 2020-7-31 1:09:23
	 * @return: void
	 */
	@AfterReturning(pointcut = "execution(* org.shing.common.code.service..*(..))", returning = "returnValue")
	public void afterReturning(JoinPoint joinPoint, Object returnValue) {

		logger.info("afterReturning---,returnValue={},method={},args={},target={}", returnValue,
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()),
				joinPoint.getTarget().toString());
	}

	/**
	 * @Title: afterThrowing
	 * @Description: afterThrowing
	 * @author: Shing
	 * @date: 2020-8-1 22:58:25
	 * @return: void
	 */
	@AfterThrowing(pointcut = "execution(* org.shing.common.code.service..*(..))", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, RuntimeException e) {

		logger.error("afterThrowing---,name={},e={}", joinPoint.getSignature().getName(), e);
	}

	/**
	 * @Title: around
	 * @Description: around
	 * @author: Shing
	 * @date: 2020-8-1 23:08:03
	 * @return: Object
	 */
	@Around("execution(* org.shing.common.code.service..*(..))")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		logger.info("around----,method={},target={},args={}", proceedingJoinPoint.getSignature().getName(),
				proceedingJoinPoint.getTarget(), Arrays.toString(proceedingJoinPoint.getArgs()));
		try {
			Object object = proceedingJoinPoint.proceed();
			logger.info("around---,method={},target={},args={},return value={}", proceedingJoinPoint.getSignature().getName(),
					proceedingJoinPoint.getTarget(), Arrays.toString(proceedingJoinPoint.getArgs()), object);
			return object;
		} catch (Exception e) {
			logger.error("method={},e={}", proceedingJoinPoint.getSignature().getName(), e);
			throw e;
		}
	}

	/**
	 * @Title: after
	 * @Description: 最终增强
	 * @author: Shing
	 * @date: 2020-8-1 23:11:00
	 * @return: void
	 */
	@After("execution(* org.shing.common.code.service..*(..))")
	public void after(JoinPoint joinPoint) {

		logger.info("after----,method={},args={},target={}", joinPoint.getSignature().getName(),
				Arrays.toString(joinPoint.getArgs()), joinPoint.getTarget().toString());
	}
}
