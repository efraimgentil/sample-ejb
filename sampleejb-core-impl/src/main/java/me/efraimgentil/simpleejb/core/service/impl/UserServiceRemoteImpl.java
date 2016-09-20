package me.efraimgentil.simpleejb.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import me.efraimgentil.sampleejb.core.model.User;
import me.efraimgentil.sampleejb.core.service.UserServiceRemote;

@Stateless
public class UserServiceRemoteImpl implements UserServiceRemote {
	
	static List<User> users = new ArrayList<>();
	static int i = 0;
	
	@Override
	public List<User> findUsers() {
		return users;
	}

	@Override
	public User getUser(Integer id) {
		User user = null;
		for( User u : users ){
			if( id.equals( u.getId() ) ){
				user = u; break;
			}
		}
		return user;
	}

	@Override
	public User save(User user) {
		user.setId( ++i );
		users.add( user );
		return user;
	}

	@Override
	public User delete(User user) {
		int idx = -1;
		for( int i =0 ; i < users.size() ; i++ ){
			User u = users.get(i);
			if( u.getId().equals( user.getId() ) ){
				idx= i;
				user = u;
				break;
			}
		}
		if(idx >= 0){
			users.remove( idx );
			return user;
		}
		return null;
	}
	
	

}
