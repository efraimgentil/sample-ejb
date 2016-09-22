package me.efraimgentil.samplejeejsf.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.jms.JMSException;

import me.efraimgentil.samplejeejsf.business.UserCreator;

@Named
@ViewScoped
public class MessageCreatorMB implements Serializable {
	
	@EJB UserCreator userCreator;
	
	private Long numberOfMessages = 0L;
	
	@PostConstruct
	public void init(){
		numberOfMessages = 0L;
	}
	
	public void sendToMdb(){
		try {
			userCreator.createRandomUserAndDeliver( numberOfMessages );
			String msg = "The messages will be sent asynchonously";
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage( FacesMessage.SEVERITY_INFO, msg  , msg ) );
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public Long getNumberOfMessages() {
		return numberOfMessages;
	}

	public void setNumberOfMessages(Long numberOfMessages) {
		this.numberOfMessages = numberOfMessages;
	}
	
}
