package me.efraimgentil.samplejeejsf.handler;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory parent;

	// this injection jsf handles
	public CustomExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		return new NumberFormatExceptionHandler(  new GlobalExceptionHandler(  parent.getExceptionHandler() ) );
	}

}
