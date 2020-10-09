package rest.service;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.Map;

@Path("/var")
public class SystemVariable implements Serializable {

    @EJB
    VariableBean variableBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,String> getSystemVariable(){
        return variableBean.getSystemVariable();
    }

    @GET
    @Path("/{name}")
    public String getOneVariable(@PathParam("name") String name){
        return variableBean.getSystemVariable().get(name);
    }
}
