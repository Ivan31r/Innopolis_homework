package rest.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.Map;

@Stateless
@Named
public class VariableBean {

    public Map<String,String> getSystemVariable(){
        return System.getenv();
    }
}
