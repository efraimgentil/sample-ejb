package me.efraimgentil.samplejee.core.service;

import javax.ejb.Remote;

@Remote
public interface SelectWorldServiceRemote {
	
	public String selectWorld();

}
