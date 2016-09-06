package me.efraimgentil.simpleejb.core.service.impl;

import javax.ejb.Stateless;

import me.efraimgentil.sampleejb.core.service.SelectWorldServiceRemote;


@Stateless
public class SelectWorldServiceRemoteImpl implements SelectWorldServiceRemote {

	public String selectWorld() {
		return "Hello World Remote Haduken";
	}

}
