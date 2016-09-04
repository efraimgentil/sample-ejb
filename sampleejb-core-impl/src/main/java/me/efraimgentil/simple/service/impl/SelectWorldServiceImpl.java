package me.efraimgentil.simple.service.impl;

import javax.ejb.Stateless;

import me.efraimgentil.simple.service.SelectWorldService;

@Stateless
public class SelectWorldServiceImpl implements SelectWorldService {

	public String selectWorld() {
		return "Hello world local";
	}

}
