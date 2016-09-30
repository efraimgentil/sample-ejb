package me.efraimgentil.simplejee.core.service.impl;

import javax.ejb.Stateful;
import javax.ejb.Stateless;

@javax.ejb.LocalBean
@Stateless
public class LocalHelloBean {
	
	public String hello(){
		return "hello";
	}
	
}
