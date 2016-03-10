import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.json.*;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;


@Path("/TimeChecker")
public class TimeChecker{
       
	//Create
    @POST
    @Path("/create")
    public Response post(@FormParam("tDate") String tDate, @FormParam("result") String result){
		
		MongoClientURI uri = new MongoClientURI("mongodb://BChrysler:chivalry13@ds019628.mlab.com:19628/ase_lab_7");
		MongoClient client = new MongoClient(uri);

		DB db = client.getDB(uri.getDatabase());
		DBCollection logs = db.getCollection("logs");
		BasicDBObject log1 = new BasicDBObject();
		log1.put("Date", tDate);
		log1.put("Result", result);
		
		WriteResult rez = logs.insert(log1);
		
    	String output = "The entered bloodlog is for " + (rez.toString());
    	client.close();
    	return Response.status(200).entity(output).build();
    }
    
    //Read
    @GET
    @Path("/read")
    public Response get(@FormParam("tDate") String tDate) throws JSONException{
    	MongoClientURI uri = new MongoClientURI("mongodb://BChrysler:chivalry13@ds019628.mlab.com:19628/ase_lab_7");
		MongoClient client = new MongoClient(uri);

		DB db = client.getDB(uri.getDatabase());
		DBCollection logs = db.getCollection("logs");
		BasicDBObject query = new BasicDBObject();
		
		query.put("Date", tDate);
    	DBCursor docs = logs.find(query);
	
    	String output = "The result(s) found at " + tDate + " are " + docs.toArray().toString();
    	client.close();
    	return Response.status(200).entity(output).build();
    }
   
    //Update
    @PUT
    @Path("/update")
    public Response put(@FormParam("tDateUp") String tDate, @FormParam("resultUp") String result){
		
		MongoClientURI uri = new MongoClientURI("mongodb://BChrysler:chivalry13@ds019628.mlab.com:19628/ase_lab_7");
		MongoClient client = new MongoClient(uri);

		DB db = client.getDB(uri.getDatabase());
		DBCollection logs = db.getCollection("logs");
		BasicDBObject log1 = new BasicDBObject();
		BasicDBObject query = new BasicDBObject();
		
		query.put("Date", tDate);
		log1.put("Result", result);
	
		WriteResult rez = logs.update(query, log1);
		
    	String output = "The entered bloodlog is for " + (rez.toString());
    	client.close();
    	return Response.status(200).entity(output).build();
    }    
    
    //Delete
    @DELETE
    @Path("/delete")
    public Response delete(@FormParam("tDateDel") String tDate){
		
		MongoClientURI uri = new MongoClientURI("mongodb://BChrysler:chivalry13@ds019628.mlab.com:19628/ase_lab_7");
		MongoClient client = new MongoClient(uri);

		DB db = client.getDB(uri.getDatabase());
		DBCollection logs = db.getCollection("logs");
		BasicDBObject log1 = new BasicDBObject();
		log1.put("Date", tDate);
		
		logs.remove(log1);
	
		String output = "The bloodlog is for " + tDate + " has been deleted.";
    	client.close();
    	return Response.status(200).entity(output).build();
    }    
    
    
}
