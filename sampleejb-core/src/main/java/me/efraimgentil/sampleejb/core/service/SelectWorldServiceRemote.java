package me.efraimgentil.sampleejb.core.service;

import javax.ejb.Remote;

@Remote
public interface SelectWorldServiceRemote {
	
	public String selectWorld();

}
