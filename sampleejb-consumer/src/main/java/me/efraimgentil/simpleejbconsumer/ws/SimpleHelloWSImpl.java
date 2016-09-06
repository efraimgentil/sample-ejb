package me.efraimgentil.simpleejbconsumer.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import me.efraimgentil.simple.service.SelectWorldService;
import me.efraimgentil.simple.service.SelectWorldServiceRemote;


@Stateless
@Path("/simple-hello")
public class SimpleHelloWSImpl {
				 
	@EJB(lookup="java:global/sampleejb-ear/sampleejb-core-impl-1.0/SelectWorldServiceRemoteImpl") SelectWorldServiceRemote remote;
	@EJB(lookup="java:global/sampleejb-ear/sampleejb-core-impl-1.0/SelectWorldServiceImpl!me.efraimgentil.simple.service.SelectWorldService") SelectWorldService local;
	
	@GET
	@Path("/remote")
	public Response printMessageRemote() {
		String result = "Restful example : " + remote.selectWorld() ;
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/local")
	public Response printMessageLocal() {
		String result = "Restful example : " + remote.selectWorld() ;
		return Response.status(200).entity(result).build();
	}


	
}
