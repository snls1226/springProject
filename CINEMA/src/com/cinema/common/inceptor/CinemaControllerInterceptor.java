package com.cinema.common.inceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.servlet.ModelAndView;

public class CinemaControllerInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		
		Object obj = null;
		ModelAndView mav = null;
		
		System.out.println("doBefore");
		
		try {
			
			obj = invocation.proceed();
			
			System.out.println("doAfterReturning");
			
			if(obj instanceof ModelAndView) {
				
				
				mav = (ModelAndView) obj;
			}
			
			return mav;
			
		} catch (Exception e) {
			System.out.println("doAfterThrowing");
			e.printStackTrace();
		} finally {
			System.out.println("doAfter");
		}
		
		return null;
	}

}
