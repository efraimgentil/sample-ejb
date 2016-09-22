package me.efraimgentil.samplejee.core.service;

import java.util.List;

import javax.ejb.Remote;

import me.efraimgentil.samplejee.core.model.User;

@Remote
public interface UserServiceRemote {
	
	List<User> findUsers();
	
	User getUser(Integer id);
	
	User save(User user);
	
	User delete(User user);
	
}
