package me.efraimgentil.sampleejbconsumer.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import me.efraimgentil.sampleejb.core.model.User;
import me.efraimgentil.sampleejb.core.service.UserServiceRemote;
import me.efraimgentil.sampleejbconsumer.KnownEJBS;

@Stateless
@Path("/user")
public class UserWS {
	
	@EJB(lookup=KnownEJBS.UserServiceRemote)
	UserServiceRemote userService;
	
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUser(@PathParam(value ="id") Integer id){
		User user = userService.getUser(id);
		return Response.status(Status.OK).entity( user ).build();
	}
	
	/**
	 * Here will throws a RuntimeException because the findUsers is not implemented yet 
	 * , the exception will be handler by the RuntimeExceptionMapper.class
	 * see that when u implements the service in the sambleejc-core-impl and deploy the ear again
	 * it will start working gracefully =)
	 */
	@GET
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findUsers(){
		
		List<User> findUsers = userService.findUsers();
		return Response.status(Status.OK).entity( findUsers ).build();
	}
	
	
}
