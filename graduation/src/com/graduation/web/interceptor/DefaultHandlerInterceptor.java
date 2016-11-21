package com.graduation.web.interceptor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @ClassName DefaultHandlerInterceptor
 * @Description 默认拦截器
 * @date 2016年11月21日
 */
public class DefaultHandlerInterceptor extends HandlerInterceptorAdapter {
	private static Logger log = LoggerFactory.getLogger(DefaultHandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("进入拦截器");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

	/**
	 * 
	 * @Method: getReturnUrl
	 * @Description: �ض���ҳ�洦��
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getReturnUrl(HttpServletRequest request) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(request.getRequestURI());
			String contextPath = request.getContextPath();
			appendRequestParameters(sb, request);
			String requestURI = sb.toString();
			requestURI = requestURI.replaceAll(contextPath, "");
			return URLEncoder.encode(requestURI, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * 
	 * @Method: appendRequestParameters
	 * @Description: �ض���ҳ�������
	 * @param sb
	 * @param request
	 */
	protected void appendRequestParameters(StringBuffer sb, HttpServletRequest request) {
		Enumeration<?> en = request.getParameterNames();
		if (!en.hasMoreElements()) {
			return;
		}
		sb.append('?');
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			String[] values = request.getParameterValues(name);
			if (values == null || values.length == 0) {
				continue;
			}
			for (String v : values) {
				try {
					v = URLEncoder.encode(v, request.getCharacterEncoding());
				} catch (UnsupportedEncodingException ignore) {
				}
				sb.append(name).append('=').append(v).append('&');
			}
		}
		sb.deleteCharAt(sb.length() - 1);
	}

}
