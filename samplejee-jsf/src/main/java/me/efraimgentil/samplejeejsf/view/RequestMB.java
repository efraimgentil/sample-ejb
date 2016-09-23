package me.efraimgentil.samplejeejsf.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RequestMB {
	
	
	public void throwNumberFormat(){
		throw new NumberFormatException("This was intentional");
	}
	
	public void throwException() throws Exception{
		throw new Exception("Something real big went wrong");
	}
	
}
