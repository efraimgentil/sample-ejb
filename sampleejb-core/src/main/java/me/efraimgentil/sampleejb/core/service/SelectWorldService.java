package me.efraimgentil.sampleejb.core.service;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
public interface SelectWorldService {

	
	String selectWorld();
	
}