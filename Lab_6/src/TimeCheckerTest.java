import static org.junit.Assert.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class TimeCheckerTest {
	 
	public void jObjCheck(){
	    JSONObject jObj = new JSONObject();    
	    try{
	    jObj.put("11/12/15", "120/80");
	    jObj.put("11/13/15", "110/80");
	    jObj.put("11/14/15", "100/80");
	    jObj.put("11/15/15", "120/90");
	    }catch(JSONException e){}
		
	    assertNotNull("Failed",jObj);
	    }
}
