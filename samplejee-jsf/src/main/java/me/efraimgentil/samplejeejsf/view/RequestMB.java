package me.efraimgentil.samplejeejsf.view;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import me.efraimgentil.simplejee.core.service.impl.AsyncLocalBean;
import me.efraimgentil.simplejee.core.service.impl.LocalHelloBean;

@Named
@RequestScoped
public class RequestMB {
	
	@EJB LocalHelloBean localBean;
	@EJB AsyncLocalBean asyncBean;
	
	public void hello() throws InterruptedException{
		System.out.println( localBean.hello() );
		 Future<String> asyncHello = asyncBean.asyncHello();
	}
	
	
	public void throwNumberFormat(){
		throw new NumberFormatException("This was intentional");
	}
	
	public void throwException() throws Exception{
		throw new Exception("Something real big went wrong");
	}
	
}
