package org.shing.common.code.controller;

import org.shing.common.code.api.IHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description: HelloController
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-8-1 20:40:04
 */
@RestController
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	@Autowired
	IHelloService iHelloService;

	@GetMapping("/getHello")
	public String hello() {

		String hello = iHelloService.getHello("Shing");
		logger.info("getHello,{}" , hello);
		return hello;
	}
}
