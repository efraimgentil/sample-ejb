package me.efraimgentil.samplejeejaxrs.ws;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import me.efraimgentil.samplejee.core.KnownEJBS;
import me.efraimgentil.samplejee.core.model.User;
import me.efraimgentil.samplejee.core.service.UserServiceRemote;
/*import me.efraimgentil.samplejeejaxrs.jms.UserDelivery;*/

@Stateless
@Path("/user")
public class UserWS {
	
//	@EJB(lookup=KnownEJBS.UserServiceRemote)
//	UserServiceRemote userService;

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUser(@PathParam(value ="id") Integer id){
		User user = null; // userService.getUser(id);
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
		List<User> findUsers = Arrays.asList( new User( 1 , "lol" , "teste@gmail.com") , new User(2 , "lole" , "teste@gmail.com" ) );// null ;// userService.findUsers();
		return Response.status(Status.OK).entity( findUsers ).build();
	}
	
	
	/*@GET
	@Path("/jms")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response sendUserToQueue(){
		User u = new User();
		u.setEmail( String.valueOf(  new Date().getTime() ) + "@gmail.com" );
		u.setUsername( String.valueOf(  new Date().getTime() ) );
		try {
			delivery.sentUserToQueue( u );
			return Response.ok( u ).build();
		} catch (JMSException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}*/
	
	
	
}
