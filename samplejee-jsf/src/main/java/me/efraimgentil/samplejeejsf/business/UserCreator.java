package me.efraimgentil.samplejeejsf.business;

import java.util.Random;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.transaction.TransactionScoped;

import me.efraimgentil.samplejee.core.model.User;
import me.efraimgentil.samplejeejsf.jms.UserDelivery;

@LocalBean
@Stateless
public class UserCreator {
	
	
	@EJB UserDelivery userDelivery;
	
	@Asynchronous
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
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
