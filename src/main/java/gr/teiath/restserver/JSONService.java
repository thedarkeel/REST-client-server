package gr.teiath.restserver;


import gr.teiath.Movie;
import gr.teiath.Movie_info;
import gr.teiath.Movie_ratings;
import gr.teiath.Rate;
import gr.teiath.utils.RestUtilities;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("/json")
public class JSONService {

	static String endPointUrl = "http://www.omdbapi.com/?i="; //omdb
	static String endPointUrl2 = "http://api.trakt.tv/movie/summary.json/91aaa184f92b0115cf0ff7ce57ce2b50/"; //Trakt
	static String endPointUrlPost1 = "http://api.trakt.tv/rate/movie/91aaa184f92b0115cf0ff7ce57ce2b50";//Trakt_POST
	
	@GET
	@Path("/movie/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getMovieInJSON(@PathParam("param") String param) {
	
		String getUrl = endPointUrl + param; //omdb
		String getUrl2 = endPointUrl2 + param; //trakt
		String movieString = RestUtilities.getRequest(getUrl, "application/json"); //omdb
		String movieString2 = RestUtilities.getRequest(getUrl2, "application/json"); //Trakt
		
		Movie movie = new Movie();

        JSONParser parser = new JSONParser();
		try {                                          //omdb
	        Object obj = parser.parse(movieString);
	        JSONObject jsonObject = (JSONObject) obj;
	        movie.setImdbid((String) jsonObject.get("imdbID"));
	        movie.setTitle((String) jsonObject.get("Title"));
	        movie.setYear((String) jsonObject.get("Year"));
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		try {                                           //Trakt
	        Object obj = parser.parse(movieString2);
	        JSONObject jsonObject = (JSONObject) obj;
	        movie.setTrailer((String) jsonObject.get("trailer"));
	        movie.setTagline((String) jsonObject.get("tagline"));
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		return movie;
	}
	
	
	
	
	@GET
	@Path("/movie_ratings/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie_ratings getMovie_ratingsInJSON(@PathParam("param") String param) {
	
		String getUrl = endPointUrl + param; //omdb
		String getUrl2 = endPointUrl2 + param; //trakt
		String movieString = RestUtilities.getRequest(getUrl, "application/json"); //omdb
		String movieString2 = RestUtilities.getRequest(getUrl2, "application/json"); //Trakt
		
		Movie_ratings movie_ratings = new Movie_ratings();

        JSONParser parser = new JSONParser();
		try {                                          //omdb
	        Object obj = parser.parse(movieString);
	        JSONObject jsonObject = (JSONObject) obj;
	        movie_ratings.setMetascore((String) jsonObject.get("Metascore"));
	        movie_ratings.setImdbrating((String) jsonObject.get("imdbRating"));
	        movie_ratings.setImdbvotes((String) jsonObject.get("imdbVotes"));
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		try {                                           //Trakt
	        Object obj = parser.parse(movieString2);
	        JSONObject jsonObject = (JSONObject) obj;
	        movie_ratings.setRatings_trakt((JSONObject) jsonObject.get("ratings"));
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		return movie_ratings;
	}
	
	@GET
	@Path("/movie_info/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie_info getMovie_infoInJSON(@PathParam("param") String param) {
	
		String getUrl = endPointUrl + param; //omdb
		String getUrl2 = endPointUrl2 + param; //trakt
		String movieString = RestUtilities.getRequest(getUrl, "application/json"); //omdb
		String movieString2 = RestUtilities.getRequest(getUrl2, "application/json"); //Trakt
		
		Movie_info movie_info = new Movie_info();

        JSONParser parser = new JSONParser();
		try {                                          //omdb
	        Object obj = parser.parse(movieString);
	        JSONObject jsonObject = (JSONObject) obj;
	        movie_info.setDirector((String) jsonObject.get("Director"));
	        movie_info.setWriter((String) jsonObject.get("Writer"));
	        movie_info.setActors((String) jsonObject.get("Actors"));
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		try {                                           //Trakt
	        Object obj = parser.parse(movieString2);
	        JSONObject jsonObject = (JSONObject) obj;
	        movie_info.setCertification((String) jsonObject.get("certification"));
	        movie_info.setRuntime((Long) jsonObject.get("runtime"));
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		return movie_info;
	}	

	
	@POST
	@Path("/post/rate/tt0069293")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Rate postInJSON() {				
		
		String jsonBody = "{\"username\":\"the_dark_eel\",\"password\":\"3a2214435ee277bb532a313346e81d3f413a8626\",\"imdb_id\":\"tt0069293\",\"title\":\"Solaris\",\"rating\":8}";
		String postUrl1 = endPointUrlPost1;
		
		String rateString = RestUtilities.postRequest(postUrl1, "application/json", jsonBody);
		
		Rate rate = new Rate();

        JSONParser parser = new JSONParser();
		try {
	        Object obj = parser.parse(rateString);
	        JSONObject jsonObject = (JSONObject) obj;
	        
	        rate.setStatus((String) jsonObject.get("status"));
	        rate.setMessage((String) jsonObject.get("message"));
	        rate.setType((String) jsonObject.get("type"));
	        rate.setRating((Long) jsonObject.get("rating"));
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		
		
		return rate;
	}
	
	@POST
	@Path("/post/rate/tt0093191")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Rate postInJSON2() {				
		
		String jsonBody = "{\"username\":\"the_dark_eel\",\"password\":\"3a2214435ee277bb532a313346e81d3f413a8626\",\"imdb_id\":\"tt0093191\",\"title\":\"Wings of Desire\",\"rating\":9}";
		String postUrl1 = endPointUrlPost1;
		
		String rateString = RestUtilities.postRequest(postUrl1, "application/json", jsonBody);
		
		Rate rate = new Rate();

        JSONParser parser = new JSONParser();
		try {
	        Object obj = parser.parse(rateString);
	        JSONObject jsonObject = (JSONObject) obj;
	        
	        rate.setStatus((String) jsonObject.get("status"));
	        rate.setMessage((String) jsonObject.get("message"));
	        rate.setType((String) jsonObject.get("type"));
	        rate.setRating((Long) jsonObject.get("rating"));
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		
		
		return rate;
	}
	
	@POST
	@Path("/post/rate/tt0082979")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Rate postInJSON3() {				
		
		String jsonBody = "{\"username\":\"the_dark_eel\",\"password\":\"3a2214435ee277bb532a313346e81d3f413a8626\",\"imdb_id\":\"tt0082979\",\"title\":\"Reds\",\"rating\":8}";
		String postUrl1 = endPointUrlPost1;
		
		String rateString = RestUtilities.postRequest(postUrl1, "application/json", jsonBody);
		
		Rate rate = new Rate();

        JSONParser parser = new JSONParser();
		try {
	        Object obj = parser.parse(rateString);
	        JSONObject jsonObject = (JSONObject) obj;
	        
	        rate.setStatus((String) jsonObject.get("status"));
	        rate.setMessage((String) jsonObject.get("message"));
	        rate.setType((String) jsonObject.get("type"));
	        rate.setRating((Long) jsonObject.get("rating"));
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		
		
		return rate;
	}
}