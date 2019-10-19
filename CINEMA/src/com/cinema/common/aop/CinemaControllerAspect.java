package com.cinema.common.aop;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.servlet.ModelAndView;

public class CinemaControllerAspect {
	
	public void doBefore(JoinPoint jp) throws Exception {
		
		// JointPoint : PointCut�� ���� ������ ���´�.
		System.out.println( jp.getSignature() ); // ex) ModelAndView com.cinema.notice.controller.NoticeController.test()
		
		// PointCut �߻��� ��ü
		System.out.println( jp.getTarget() ); // com.cinema.notice.controller.NoticeController@41ef12c4
		
		System.out.println("doBefore");
		
	}
	
	public void doAfterReturning(ModelAndView modelAndView) throws Exception {
		
		// returning �Ӽ����� �Ű������� �ָ� �޼ҵ� ���� �� ���� ���� ���ڷ� ��� ��
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
		
		// ProceedingJoinPoint : �߻��� PointCut�� ���� ���� + ������� ���´�.
		
		ModelAndView mav = null;
		
		JoinPoint jp = (JoinPoint) pjp;
		doBefore(jp);
		try {
			Object obj = pjp.proceed(); // PointCut�� �߻��� �޼ҵ� ����
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