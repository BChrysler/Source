import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class TimeCheckerTestTest {

	@Test
	public void test() {

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
