package me.efraimgentil.samplejeejsf.handler;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class NumberFormatExceptionHandler  extends ExceptionHandlerWrapper  {
	
	private ExceptionHandler wrapped;

	public NumberFormatExceptionHandler(ExceptionHandler exception) {
		this.wrapped = exception;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return wrapped;
	}
	

	@Override
	public void handle() throws FacesException {

		final Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();
		while (i.hasNext()) {
			ExceptionQueuedEvent event = i.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

			// get the exception from context
			Throwable t = context.getException();
			int maxVisitsInside = 5;
			int c = 0; // try to get the cause of the exception whitout the facesException wrapers
			while( t instanceof FacesException && c <  maxVisitsInside){
				t = t.getCause();
				c++;
			}
			
			if( t instanceof NumberFormatException ){
				final FacesContext fc = FacesContext.getCurrentInstance();
				try {
					fc.addMessage(null , new FacesMessage( FacesMessage.SEVERITY_INFO, t.getMessage()  , t.getMessage() ));
				} finally {
					i.remove();
				}
			}
		}
		// parent hanle
		super.handle();
	}
	
}
