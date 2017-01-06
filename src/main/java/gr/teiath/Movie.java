package gr.teiath;


public class Movie {

	String imdbid;
	String title;
	String year;
	String trailer;
	String tagline;

	public Movie() {
		this.imdbid = "";
		this.title = "";
		this.year ="";
		this.trailer="";
		this.tagline="";
	}
	
	public Movie(String imdbid, String title, String year, String[] subject) {
		this.title = new String(title);
		this.year = new String(year);
	}
	
	public String getImdbid() {
		return imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	
	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	
	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	
}