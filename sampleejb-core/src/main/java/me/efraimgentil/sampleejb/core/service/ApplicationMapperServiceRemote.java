package me.efraimgentil.sampleejb.core.service;

import java.io.Serializable;

import javax.ejb.Remote;

@Remote
public interface ApplicationMapperServiceRemote extends Serializable {
	
	Object getValue(String key);
	
	<T> T getValue(String key , Class<T> clazz);
	
	void putValue(String key , Object object );
	
}
