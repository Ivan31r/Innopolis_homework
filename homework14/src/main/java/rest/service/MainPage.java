package rest.service;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/restService")
@ApplicationPath("/app")
public class MainPage extends Application {

    @EJB
    SystemVariables systemVariables;

    @GET
    @Path("/variables")
    @Produces({MediaType.APPLICATION_JSON})
    public Map<String, String> getAllVariables() {
        return systemVariables.getEnvironments();
    }


    @GET
    @Path("/variables/{oneVar}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOne(@PathParam("oneVar") String name) {
        return systemVariables.getEnvironments().get(name);
    }
}