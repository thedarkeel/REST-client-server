package gr.teiath;

import org.json.simple.JSONObject;

public class Movie_ratings {

	String metascore;
	String imdbrating;
	String imdbvotes;
	JSONObject ratings_trakt;
	

	public Movie_ratings() {
		
	}
	
	public Movie_ratings(String metascore, String imdbrating, String imdbvotes, JSONObject ratings_trakt) {
		this.metascore = new String(metascore);
		this.imdbrating = new String(imdbrating);
		this.imdbvotes = new String(imdbvotes);
		this.ratings_trakt = new JSONObject(ratings_trakt);
	}
	
	public String getMetascore() {
		return metascore;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

	public String getImdbrating() {
		return imdbrating;
	}

	public void setImdbrating(String imdbrating) {
		this.imdbrating = imdbrating;
	}

	public String getImdbvotes() {
		return imdbvotes;
	}

	public void setImdbvotes(String imdbvotes) {
		this.imdbvotes = imdbvotes;
	}

	public JSONObject getRatings_trakt() {
		return ratings_trakt;
	}

	public void setRatings_trakt(JSONObject ratings_trakt) {
		this.ratings_trakt = ratings_trakt;
	}
	
}