package org.shing.common.code;

/**
 * @ClassName: Singleton
 * @Description: 单例
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-15 15:19:40
 */
public class Singleton {
	private volatile static Singleton instance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			// 双重检查锁
			synchronized (Singleton.class) {
				if (instance == null) {

					instance = new Singleton();
				}
			}
		}
		return instance;
	}

}
