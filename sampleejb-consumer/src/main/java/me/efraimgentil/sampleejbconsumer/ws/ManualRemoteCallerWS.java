package me.efraimgentil.sampleejbconsumer.ws;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import me.efraimgentil.sampleejb.core.service.SelectWorldServiceRemote;
import me.efraimgentil.sampleejbconsumer.KnownEJBS;



@Stateless
@Path("/manual-remote-caller")
public class ManualRemoteCallerWS {
	
	@GET
	@Path("/")
	public Response printMessageLocal() throws NamingException {
		InitialContext ic = new InitialContext();
		Object lookup = ic.lookup( KnownEJBS.SelectWorldServiceRemote );
		SelectWorldServiceRemote service = (SelectWorldServiceRemote) lookup;
		String result = "Restful example : " + service;
		return Response.status(200).entity(result).build();
	}
	
}
