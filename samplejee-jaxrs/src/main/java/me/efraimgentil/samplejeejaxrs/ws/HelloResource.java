package me.efraimgentil.samplejeejaxrs.ws;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/hello")
public class HelloResource {
	
	private String message = "Hello darkness my old friend"; 
	
	@GET
	@Produces( MediaType.TEXT_PLAIN )
	public String helloWorld(){
		return message;
	}
	
	@GET
	@Produces( MediaType.APPLICATION_XML )
	public Message helloWorldXml(){
		return new Message( message );
	}
	
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Map<String, Object> helloWorldJson(){
		Map<String, Object> map = new HashMap<>();
		map.put("message", message );
		return map;
	}
	
	@XmlRootElement
	public static class Message{
		private String value;
		
		public Message(){}
		
		public Message(String value) {
			super();
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
	}
	
	
	
	
}
