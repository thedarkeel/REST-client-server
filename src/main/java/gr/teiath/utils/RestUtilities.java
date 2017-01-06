package gr.teiath.utils;



import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class RestUtilities {

	public RestUtilities() {
	}
	
	public static String getRequest(String urlString, String mimeType) {
		
		String output = "";
		
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource(urlString);

			ClientResponse response = webResource.accept(mimeType)
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			output = response.getEntity(String.class);

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return output;
	
	}
public static String postRequest(String urlString, String mimeType, String inputBody) {
		
		String output = "";
		
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource(urlString);
						
			
			//String input = "{\"username\":\"the_dark_eel\",\"password\":\"3a2214435ee277bb532a313346e81d3f413a8626\",\"imdb_id\":\"tt0082971\",\"title\":\"Indiana Jones and the Raiders of the Lost Ark\",\"rating\":\"love\"}";
			ClientResponse response = webResource.accept(mimeType)
					.type(mimeType).post(ClientResponse.class, inputBody);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			output = response.getEntity(String.class);

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return output;
	}
	
}
