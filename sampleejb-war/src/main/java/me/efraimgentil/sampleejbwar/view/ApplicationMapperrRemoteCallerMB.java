package me.efraimgentil.sampleejbwar.view;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import me.efraimgentil.sampleejb.core.model.User;
import me.efraimgentil.sampleejb.core.service.ApplicationMapperServiceRemote;
import me.efraimgentil.sampleejbwar.KnownEJBS;

@Named
@RequestScoped
public class ApplicationMapperrRemoteCallerMB {
	
	
	@EJB(lookup = KnownEJBS.ApplicationMapperServiceRemote)
	ApplicationMapperServiceRemote service;
	
	public User getUser(){
		return service.getValue("someKey", User.class);
	}
	
}
