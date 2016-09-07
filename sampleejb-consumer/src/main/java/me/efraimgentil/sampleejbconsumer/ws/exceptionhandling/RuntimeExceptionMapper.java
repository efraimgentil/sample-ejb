package me.efraimgentil.sampleejbconsumer.ws.exceptionhandling;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Produces({ MediaType.APPLICATION_JSON })
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {
	
	
	public class ErrorMessage{
		
		private Integer code;
		private String message;
		
		public ErrorMessage() {
		}
		
		public ErrorMessage(Integer code, String message) {
			super();
			this.code = code;
			this.message = message;
		}

		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	}
	
	@Override
	public Response toResponse(RuntimeException re) {
		Status status = Status.BAD_REQUEST;
		ErrorMessage errorMessage = new ErrorMessage( status.getStatusCode() , re.getMessage() );
		return Response.status(status).entity( errorMessage ).build();
	}

}
