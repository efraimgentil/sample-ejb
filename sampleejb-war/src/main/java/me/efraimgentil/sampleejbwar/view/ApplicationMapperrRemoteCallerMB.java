package me.efraimgentil.sampleejbwar.view;

import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import me.efraimgentil.sampleejb.core.KnownEJBS;
import me.efraimgentil.sampleejb.core.model.User;
import me.efraimgentil.sampleejb.core.service.ApplicationMapperServiceRemote;

@Named
@RequestScoped
public class ApplicationMapperrRemoteCallerMB {
	
	
	@EJB(lookup = KnownEJBS.ApplicationMapperServiceRemote)
	ApplicationMapperServiceRemote service;
	
	private String key;
	private String value;
	
	public User getUser(){
		return service.getValue("someKey", User.class);
	}
	
	public void putInCache(){
		service.putValue(key, value);
		key = null;
		value = null;
		String msg = "Valor adicionado com sucesso";
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage( FacesMessage.SEVERITY_INFO, msg  , msg ) );
	}
	
	public ApplicationMapperServiceRemote getService(){
		return service;
	}
	
	public List<String> getKeys(){
		return service.getKeys();
	}
	
	public Object getValue(String key){
		return service.getValue(key);
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
