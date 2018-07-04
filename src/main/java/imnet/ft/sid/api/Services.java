package imnet.ft.sid.api;

import java.io.File;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import imnet.sid.commun.tika.ExtractMetaData;

@Path("/indexation")
public class Services {
	
	ExtractMetaData extract;

	@POST
	@Path("/inbox")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getFile(String url) {
		try {
			this.extract=new ExtractMetaData(url);
			Map<File, Map> map= extract.getMetadata();
			return Response.status(201).entity(map).build();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String test() {
		System.out.println("addo");
		return "c'est un test";
		
	}

}
