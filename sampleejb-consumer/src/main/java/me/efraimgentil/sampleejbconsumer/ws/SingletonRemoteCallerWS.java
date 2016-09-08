package me.efraimgentil.sampleejbconsumer.ws;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import me.efraimgentil.sampleejb.core.KnownEJBS;
import me.efraimgentil.sampleejb.core.model.User;
import me.efraimgentil.sampleejb.core.service.ApplicationMapperServiceRemote;

@Singleton
@Path("/singleton-remote-caller")
public class SingletonRemoteCallerWS {
	
	
	@EJB(lookup = KnownEJBS.ApplicationMapperServiceRemote ) ApplicationMapperServiceRemote appMapper;
	
	@GET
	@Path("/get")
	@Produces( MediaType.APPLICATION_JSON )
	public Response getCachedObject(){
		Object value = appMapper.getValue("someKey");
		if(value == null )
			return Response.status(Status.NOT_FOUND).entity("Not found").build();
		return Response.status(Status.OK).entity( value ).build();
	}
	
	/**
	 * Using get just to simplify the testing
	 */
	@GET
	@Path("/put")
	@Produces( MediaType.APPLICATION_JSON )
	public Response putObjectIntoCache(){
		User userToCache = new User();
		userToCache.setId( Integer.MAX_VALUE );
		userToCache.setUsername("CachedUser");
		userToCache.setEmail("cachedemail@email.com");
		appMapper.putValue("someKey", userToCache );
		return Response.status(Status.OK).entity( userToCache ).build();
	}
	
	@GET
	@Path("/keys")
	@Produces( MediaType.APPLICATION_JSON )
	public Response getAllKeys(){
		return Response.status(Status.OK).entity( appMapper.getKeys() ).build();
	}

}
