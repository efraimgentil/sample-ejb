package me.efraimgentil.simple.service;

import javax.ejb.Remote;

@Remote
public interface SelectWorldServiceRemote {
	
	public String selectWorld();

}
