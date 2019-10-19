package com.cinema.common.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CinemaApplicationContext {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/spring/dispatcher-servlet.xml");
		CinemaTest hello = context.getBean("helloController", CinemaTest.class);
		hello.hello();
	}
}
