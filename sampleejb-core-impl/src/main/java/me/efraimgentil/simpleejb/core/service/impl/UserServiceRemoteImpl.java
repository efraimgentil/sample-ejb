package me.efraimgentil.simpleejb.core.service.impl;

import java.util.List;

import javax.ejb.Stateless;

import me.efraimgentil.sampleejb.core.model.User;
import me.efraimgentil.sampleejb.core.service.UserServiceRemote;

@Stateless
public class UserServiceRemoteImpl implements UserServiceRemote {

	@Override
	public List<User> findUsers() {
		throw new RuntimeException( "Not supported yet");
	}

	@Override
	public User getUser(Integer id) {
		User dummyUser = new User();
		dummyUser.setId(id);
		dummyUser.setUsername("randomName" + id );
		dummyUser.setEmail("randomemail" + id  + "@gmail.com");
		return dummyUser;
	}

	@Override
	public User save(User user) {
		throw new RuntimeException( "Not supported yet");
	}

	@Override
	public User delete(User user) {
		throw new RuntimeException( "Not supported yet");
	}

}
