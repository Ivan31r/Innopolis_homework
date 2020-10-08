package rest.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.Map;

@Stateless
public class SystemVariables {

    public Map<String,String> getEnvironments(){
        return System.getenv();
    }
}
