package me.efraimgentil.simpleejb.core.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;

import me.efraimgentil.sampleejb.core.service.ApplicationMapperServiceRemote;

@Singleton
public class ApplicationMapperServiceRemoteImpl implements ApplicationMapperServiceRemote {

	private static final long serialVersionUID = -8287057271121374552L;
	
	private Map<String, Object> cacheMap = new HashMap<>();
	
	@Override
	public Object getValue(String key) {
		return cacheMap.get(key);
	}

	@Override
	public <T> T getValue(String key, Class<T> clazz) {
		return (T) cacheMap.get(key);
	}

	@Override
	public void putValue(String key, Object object) {
		cacheMap.put(key, object);
	}

}
