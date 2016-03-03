import java.io.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.*;

@Path("/TimeChecker")
public class TimeChecker{
       
    @POST
    @Path("/tests")
    public Response post(@FormParam("tDate") String tDate, @FormParam("result") String result){

    	String output = "The entered bloodlog is for date: "+ tDate 
    			+ " and with a result of " + result ;
    	return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/Log")
    @Produces("application/json")
    public Response get() throws JSONException{
    JSONObject jObj = new JSONObject();
    
    try{
    jObj.put("11/12/15", "120/80");
    jObj.put("11/13/15", "110/80");
    jObj.put("11/14/15", "100/80");
    jObj.put("11/15/15", "120/90");
    }catch(JSONException e){}
	
    String output = "@Produces(\"application/json)\" Gives the output: \n\n" +jObj;
    return Response.status(200).entity(output).build();
    }
   
  /*****  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getParameter("cat"));	
		
		try{
			jObj.put("tDate1", "11/12/15");
			jObj.put("tDate2", "11/13/15");
		}catch(JSONException e){}
		
		response.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = response.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		out.print(jObj);
		out.flush();
		
		
		
	}

	*/
}
