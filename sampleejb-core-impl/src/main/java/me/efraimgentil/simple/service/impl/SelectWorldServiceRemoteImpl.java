package me.efraimgentil.simple.service.impl;

import javax.ejb.Stateless;

import me.efraimgentil.simple.service.SelectWorldServiceRemote;


@Stateless
public class SelectWorldServiceRemoteImpl implements SelectWorldServiceRemote {

	public String selectWorld() {
		return "Hello World Remote Haduken";
	}

}
