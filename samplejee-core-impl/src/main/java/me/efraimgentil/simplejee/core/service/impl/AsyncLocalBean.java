package me.efraimgentil.simplejee.core.service.impl;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class AsyncLocalBean {

	@Asynchronous
	public Future<String> asyncHello() throws InterruptedException{
		Thread.sleep(10000L);
		System.out.println("OK ?");
		return new AsyncResult<>("Hello");
	}
	
}
