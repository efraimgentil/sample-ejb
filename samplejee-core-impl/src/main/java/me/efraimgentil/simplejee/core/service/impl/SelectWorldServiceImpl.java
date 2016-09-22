package me.efraimgentil.simplejee.core.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;

import me.efraimgentil.samplejee.core.service.SelectWorldService;

@Local( SelectWorldService.class )
@Stateless
public class SelectWorldServiceImpl implements SelectWorldService {

	public String selectWorld() {
		return "Hello world local";
	}

}
