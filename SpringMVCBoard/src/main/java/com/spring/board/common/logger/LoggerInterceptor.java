package com.spring.board.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);
	
	//client -> controller 로 요청할 때(전처리기): preHandler()은 컨트롤러가 호출되기 전에 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		if (log.isDebugEnabled()) {
			log.debug("======================          START        ======================");
			log.debug(" Request URI \t:  " + request.getRequestURI());
		}
		return super.preHandle(request, response, handler);
	}
	
	//controller -> client 로 응답할 때, 그 요청을 처리할 메서드(후처리기): postHandle()은 컨트롤러가 실행되고 난 후에 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler, ModelAndView modelAndView) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("======================          END          ======================");
		}
		
	}
}
