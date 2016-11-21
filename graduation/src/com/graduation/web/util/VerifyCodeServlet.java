package com.graduation.web.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class VerifyCodeServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(VerifyCodeServlet.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("请求获取验证码()");
		/*
		 * 1. 创建验证码类
		 */
		VerifyCode vc = new VerifyCode();
		/*
		 * 2. 得到验证码图片
		 */
		BufferedImage image = vc.getImage();
		/*
		 * 3. 把图片上的文本保存到session中
		 */
		request.getSession().setAttribute("session_vcode", vc.getText());
		/*
		 * 4. 把图片响应给客户端
		 */
		VerifyCode.output(image, response.getOutputStream());
		log.debug("请求验证码结束():{}",vc.getText());
	}
}
