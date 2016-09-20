package me.efraimgentil.sampleejbmdbs;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import me.efraimgentil.sampleejb.core.KnownEJBS;
import me.efraimgentil.sampleejb.core.model.User;
import me.efraimgentil.sampleejb.core.service.UserServiceRemote;

@MessageDriven(activationConfig= {
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="destinationLookup", propertyValue="java:/jms/queue/ExpiryQueue"),
		
})
public class UserMessageBean implements MessageListener{
	
	@EJB(lookup= KnownEJBS.UserServiceRemote)
	UserServiceRemote userService;
	
	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("# Going to process the message ");
			User body = message.getBody(User.class );
			System.out.println("## Message received: " +  body );
			userService.save( body );
			System.out.println("### Message processed" );
		} catch (JMSException e) {
			e.printStackTrace();
			throw new RuntimeException(e );
		}
	}

}
