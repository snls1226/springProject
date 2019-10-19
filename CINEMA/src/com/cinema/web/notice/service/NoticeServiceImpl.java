package com.cinema.web.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticeServiceImpl {

	@Autowired
	private DataSourceTransactionManager txManager;
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean insertNotice() {
		
		return false;
	}
}
