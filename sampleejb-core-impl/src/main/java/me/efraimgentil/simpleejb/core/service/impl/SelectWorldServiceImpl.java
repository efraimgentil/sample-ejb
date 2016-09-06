package me.efraimgentil.simpleejb.core.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;

import me.efraimgentil.sampleejb.core.service.SelectWorldService;

@Local( SelectWorldService.class )
@Stateless
public class SelectWorldServiceImpl implements SelectWorldService {

	public String selectWorld() {
		return "Hello world local";
	}

}
