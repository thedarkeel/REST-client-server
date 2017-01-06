package gr.teiath;

public class Rate {

	String status;
	String message;
	String type;
	Long rating;

	public Rate() {
		
	}
	
	public Rate(String status, String message, String type, String rating) {
		this.status = new String(status);
		this.message = new String(message);
		this.type = new String(type);
		this.rating = new Long(rating);
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

}