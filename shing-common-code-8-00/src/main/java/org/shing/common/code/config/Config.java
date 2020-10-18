package org.shing.common.code.config;

import org.shing.common.code.annotation.SysLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName: AnnotationConfig
 * @Description: AnnotationConfig
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-8-1 19:02:35
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("org.shing.common.code.service")
public class Config {

	/**
	 * @Title: sysLog
	 * @Description: 切面类放入到容器中
	 * @author: Shing
	 * @date: 2020-8-1 19:04:29
	 * @return: SysLog
	 */
	@Bean
	public SysLog sysLog() {

		return new SysLog();
	}
}
