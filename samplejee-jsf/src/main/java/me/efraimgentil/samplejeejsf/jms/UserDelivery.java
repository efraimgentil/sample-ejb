package me.efraimgentil.samplejeejsf.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import me.efraimgentil.samplejee.core.model.User;

@Stateless
public class UserDelivery {
	
	@Inject
	@JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
	private JMSContext jmsContext;
	
	@Resource(name="java:/jms/queue/ExpiryQueue")
	private Destination destination;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void sentUserToQueue(User user ) throws JMSException{
		ObjectMessage om = jmsContext.createObjectMessage();
		om.setObject( user );
		jmsContext.createProducer().send(destination, om );
	}
	
	
}
