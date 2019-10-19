package com.cinema.common.context;

import com.cinema.common.header.CinemaHeader;
import com.cinema.common.header.CinemaUserHeader;

public class CinemaContext {
	
	private static ThreadLocal<CinemaContext> local = new ThreadLocal<CinemaContext>();
	
	private CinemaHeader commonHeader;
	private CinemaUserHeader userHeader;
	
	public CinemaHeader getCommonHeader() {
		return commonHeader;
	}
	
	public void setCommonHeader(CinemaHeader commonHeader) {
		this.commonHeader = commonHeader;
	}
	
	public CinemaUserHeader getUserHeader() {
		return userHeader;
	}
	
	public void setUserHeader(CinemaUserHeader userHeader) {
		this.userHeader = userHeader;
	}
	
	public void setLocal(CinemaContext cinemaContext) {
		this.local.set(cinemaContext);
	}
	
	public ThreadLocal<CinemaContext> getLocal() {
		return this.local;
	}
	
	public void deleteLocal() {
		this.local.remove();
	}
	
}
