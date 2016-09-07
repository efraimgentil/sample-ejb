package me.efraimgentil.sampleejbconsumer.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import me.efraimgentil.sampleejb.core.service.SelectWorldServiceRemote;
import me.efraimgentil.sampleejbconsumer.KnownEJBS;

@Stateless
@Path(value="/remote-caller")
public class RemoteCallerWS {
	
	@EJB(lookup= KnownEJBS.SelectWorldServiceRemote) SelectWorldServiceRemote remote;
	
	@GET
	@Path("/")
	public Response printMessageRemote() {
		String result = "Restful example : " + remote.selectWorld() ;
		return Response.status(200).entity(result).build();
	}
	
	
}
