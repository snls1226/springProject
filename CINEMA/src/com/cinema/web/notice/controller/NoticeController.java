package com.cinema.web.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cinema.common.exception.CinemaException;
import com.cinema.web.notice.service.NoticeService;

@Controller
public class NoticeController {
	
	@RequestMapping(value="test.do")
	public ModelAndView test() {
		System.out.println("- 컨트롤러");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("parameter1", "succ");
		mav.setViewName("test");
		return mav;
		
	}
	
	public void contextTest() {
		System.out.println("contextTest");
	}
	
}
