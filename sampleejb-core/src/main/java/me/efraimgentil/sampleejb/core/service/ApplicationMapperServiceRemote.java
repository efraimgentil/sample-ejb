package me.efraimgentil.sampleejb.core.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ApplicationMapperServiceRemote extends Serializable {
	
	List<String> getKeys();
	
	Object getValue(String key);
	
	<T> T getValue(String key , Class<T> clazz);
	
	void putValue(String key , Object object );
	
}
