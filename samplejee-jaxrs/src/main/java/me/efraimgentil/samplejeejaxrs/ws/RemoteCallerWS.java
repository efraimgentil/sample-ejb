package me.efraimgentil.samplejeejaxrs.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import me.efraimgentil.samplejee.core.KnownEJBS;
import me.efraimgentil.samplejee.core.service.SelectWorldServiceRemote;

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
