package gr.teiath;


public class Movie_info {

	String director;
	String writer;
	String actors;
	String certification;
	Long runtime;

	public Movie_info() {
	}
	
	public Movie_info(String director, String writer, String actors, String certification, long runtime) {
		this.director = new String(director);
		this.writer = new String(writer);
		this.actors = new String(actors);
		this.certification = new String(certification);
		this.runtime = new Long(runtime);
	}
	
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}
	
	public long getRuntime() {
		return runtime;
	}

	public void setRuntime(long runtime) {
		this.runtime = runtime;
	}

}