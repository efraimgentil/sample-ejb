package me.efraimgentil.samplejeejaxrs.ws;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import me.efraimgentil.samplejee.core.KnownEJBS;
import me.efraimgentil.samplejee.core.service.SelectWorldService;


@Stateless
@Path(value="/local-caller")
public class LocalCallerWS {
	
	
	/**
	 * If u are not using the _jboss-deployment-structure.xml and marked the "sampleejb-core" dependencie
	 * in the pom.xml as provided it will throws a error when trying to access the webservice
	 * @see jboss-deployment-structure.xml to more info
	 */
	@Resource(lookup = KnownEJBS.SelectWorldService )
	SelectWorldService local;

	@GET
	@Path("/")
	public Response printMessageLocal() {
		String result = "Restful example : " + local.selectWorld() ;
		return Response.status(200).entity(result).build();
	}
	
}
