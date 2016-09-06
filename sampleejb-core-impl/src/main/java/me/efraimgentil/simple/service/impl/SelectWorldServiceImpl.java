package me.efraimgentil.simple.service.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;

import me.efraimgentil.simple.service.SelectWorldService;

@Local( SelectWorldService.class )
@Stateless
public class SelectWorldServiceImpl implements SelectWorldService {

	public String selectWorld() {
		return "Hello world local";
	}

}
