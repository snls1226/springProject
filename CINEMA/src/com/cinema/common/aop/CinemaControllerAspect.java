package com.cinema.common.aop;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.servlet.ModelAndView;

public class CinemaControllerAspect {
	
	public void doBefore(JoinPoint jp) throws Exception {
		
		// JointPoint : PointCut에 대한 정보가 들어온다.
		System.out.println( jp.getSignature() ); // ex) ModelAndView com.cinema.notice.controller.NoticeController.test()
		
		// PointCut 발생할 객체
		System.out.println( jp.getTarget() ); // com.cinema.notice.controller.NoticeController@41ef12c4
		
		System.out.println("doBefore");
		
	}
	
	public void doAfterReturning(ModelAndView modelAndView) throws Exception {
		
		// returning 속성으로 매개변수를 주면 메소드 실행 시 리턴 값이 인자로 들어 옴
		if(modelAndView != null) {
			HashMap<String, Object> map = (HashMap) modelAndView.getModel();
			System.out.println(map.get("parameter1"));
		}
		System.out.println("doAfterReturning");
	}
	
	public void doAfterThrowing(Throwable th) throws Exception {
		System.out.println("- message : " + th.getMessage());
		System.out.println("doAfterThrowing");
	}
	
	public void doAfter() throws Exception {
		System.out.println("doAfter");
	}
	
	public ModelAndView doAround(ProceedingJoinPoint pjp) throws Exception {
		
		// ProceedingJoinPoint : 발생한 PointCut에 대한 정보 + 제어권을 갖는다.
		
		ModelAndView mav = null;
		
		JoinPoint jp = (JoinPoint) pjp;
		doBefore(jp);
		try {
			Object obj = pjp.proceed(); // PointCut이 발생한 메소드 실행
			if(obj instanceof ModelAndView) {
				mav = (ModelAndView) obj;
			}
			
			doAfterReturning(mav);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			doAfterThrowing(e);
		} finally {
			doAfter();
		}
		
		return mav;
	}
	
}