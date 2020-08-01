package org.shing.common.code.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: ServletTest
 * @Description: ServletTest
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-24 0:57:19
 */
public class ServletTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("hi," + name);
		// 初始化数据
		System.out.println(getInitParameter("init param"));
		printWriter.close();
	}

	/**
	 * @Title: init
	 * @Description: 初始化方法
	 * @author: Shing
	 * @date: 2020-7-24 1:35:42
	 */
	public void init() {

		System.out.println("-----------init ------------");
	}
}
