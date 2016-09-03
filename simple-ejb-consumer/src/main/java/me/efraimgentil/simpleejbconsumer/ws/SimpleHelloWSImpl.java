package me.efraimgentil.simpleejbconsumer.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import me.efraimgentil.simple.service.SelectWorldServiceRemote;


@Stateless
@Path("/simple-hello")
public class SimpleHelloWSImpl {
	
	@EJB(lookup="java:global/simple-ear/simple-core-impl-1.0/SelectWorldServiceRemoteImpl") SelectWorldServiceRemote selectWorld;
	
	@GET
	@Path("/")
	public Response printMessage() {
		String result = "Restful example : " + selectWorld.selectWorld() ;
		return Response.status(200).entity(result).build();
	}

	
}
