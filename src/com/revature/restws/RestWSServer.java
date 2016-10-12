package com.revature.restws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.business.ClientInfo;
import com.revature.business.Delegate;

@Component
@Path("/")
public class RestWSServer {
	
	@Autowired
	private Delegate delegate;
	
	@Autowired
	private ClientInfo cInfo;
	
	@GET
	@Path("/hello")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response hello(){
		ClientInfo clientInfo = new ClientInfo();
		clientInfo.setFirstname("Hello");
		clientInfo.setLastname("World");
		//return Response.status(200).entity(cInfo).build();
		return Response.ok(clientInfo).build();
	}

}
