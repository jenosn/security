package com.jenson.security.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimeInterceptor implements HandlerInterceptor{

	//����֮ǰ
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		request.setAttribute("startTime",new Date().getTime());
		System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
		System.out.println(((HandlerMethod)handler).getMethod().getName());
		return true; //ע�⣬�����ܲ��ܷ���postHandle ����
	}

	//controller����ʱ���ã��쳣������
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
		long start=new Date().getTime();
		System.out.println("time Interceptor ��ʱ��"+(new Date().getTime()-start));
		
	}

	//�ܻ����
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
		long start=new Date().getTime();
		System.out.println("time Interceptor ��ʱ��"+(new Date().getTime()-start));
		
		//����쳣Ϊ�գ��Ǿ�˵���Լ��Ѿ������@ControllerAdvice �������� ,����afterCompletion ǰִ��
		System.out.println("ex is:"+ex);
	}

}
