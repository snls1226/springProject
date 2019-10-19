package com.cinema.common.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component // ºó µî·Ï
@Aspect // ÇØ´ç ºóÀ» Aspect °´Ã¼·Î »ç¿ë
public class CinemaControllerAspectAnnotation {

	@Before(value = "execution(public * com.cinema.*.controller.*Controller.*(..))")
	public void doBefore() throws Exception {
		
	}
	
	@AfterReturning(value = "execution(public * com.cinema.*.controller.*Controller.*(..))")
	public void doAfterReturning() throws Exception {
		
	}
	
	@AfterThrowing(value = "execution(public * com.cinema.*.controller.*Controller.*(..))")
	public void doAfterThrowing() throws Exception {
		
	}
	
	@After(value = "execution(public * com.cinema.*.controller.*Controller.*(..))")
	public void doAfter() throws Exception {
		
	}
	
}
