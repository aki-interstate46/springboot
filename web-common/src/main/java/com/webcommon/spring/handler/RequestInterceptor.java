package com.webcommon.spring.handler;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Controller制御用Handler
 * 
 * @author Y.AKI
 * @version 1.0.0
 */
public class RequestInterceptor implements HandlerInterceptor {
	
	private long startTime;
	
	/**
	 * preHandle処理除外パス
	 */
	private static final String[] PRE_HANDLE_PROCESS_IGNORE_PATH = new String[] {
	    "^CONTEXT_PATH/css/.*$",
	    "^CONTEXT_PATH/images/.*$",
	    "^CONTEXT_PATH/script/.*$",
	    "^CONTEXT_PATH/js/.*$",
	    "^CONTEXT_PATH/favicon.ico*$",
	};
	
	/**
	 * 初期処理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (this.sessionProcessExecCheck(request)) {
			this.startTime = System.currentTimeMillis();
			LoggerFactory.getLogger(RequestInterceptor.class).info("## preHandle, path={} method={}", request.getRequestURL(), request.getMethod());
		}
		return true;
	}
	
	/**
	 * レンダリング前に処理を実行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (this.sessionProcessExecCheck(request)) {
			LoggerFactory.getLogger(RequestInterceptor.class).debug("## postHandle");
		}
	}
	
	/**
	 * 終了処理
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		if (this.sessionProcessExecCheck(request)) {
			LoggerFactory.getLogger(this.getClass()).info("## afterCompletion, time={}, path={}, method={}", System.currentTimeMillis() - startTime, request.getRequestURL(), request.getMethod());
		}
	}
	
	/**
	 * Session関連処理の実行判定
	 * 
	 * @param requestURI
	 * @return
	 */
	private boolean sessionProcessExecCheck(HttpServletRequest request) {
		for (String path : PRE_HANDLE_PROCESS_IGNORE_PATH) {
			if (request.getRequestURI().matches(path.replaceFirst("CONTEXT_PATH", request.getContextPath()))) {
				return false;
			}
		}
		return true;
	}
}
