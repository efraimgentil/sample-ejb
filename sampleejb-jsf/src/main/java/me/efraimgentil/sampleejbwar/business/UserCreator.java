package me.efraimgentil.sampleejbwar.business;

import java.util.Random;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.JMSException;

import me.efraimgentil.sampleejb.core.model.User;
import me.efraimgentil.sampleejbwar.jms.UserDelivery;

@LocalBean
@Stateless
public class UserCreator {
	
	
	@EJB UserDelivery userDelivery;
	
	@Asynchronous
	public void createRandomUserAndDeliver(Long numberOfUsers) throws JMSException{
		for( long i = 1 ; i <= numberOfUsers ; i++ ){
			User user = new User();
			user.setEmail(  new Random().nextLong()  + "@gmail.com" );
			user.setUsername(  new Random().nextLong() + ""  );
			userDelivery.sentUserToQueue(user);
			System.out.println( "Sendingo " + i + " of a total " + numberOfUsers );
		}
	}
	
}
