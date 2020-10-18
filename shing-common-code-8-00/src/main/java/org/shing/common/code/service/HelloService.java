package org.shing.common.code.service;

import org.shing.common.code.api.IHelloService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: HelloService
 * @Description: HelloService
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-8-1 18:40:10
 */
@Service
public class HelloService implements IHelloService {

	/**
	 * @Title: getHello
	 * @Description: getHello
	 * @author: Shing
	 * @date: 2020-8-1 18:41:15
	 */
	@Override
	public String getHello(String name) {

		return "Hello,"+name;
	}
}
