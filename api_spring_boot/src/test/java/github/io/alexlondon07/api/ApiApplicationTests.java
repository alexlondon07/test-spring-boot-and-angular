package github.io.alexlondon07.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import github.io.alexlondon07.api.models.Client;
import util.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

	String baseUrl = Constants.API_ROUTE_FIREBASE;
	
	/**
	 * Test for add a new Client to Api rest
	 */
	@Test
	public void testAddClients(){
		
	    RestTemplate restTemplate = new RestTemplate();

	    Client client = new Client("Emiliana", "Londoño", "1234567890", "24-08-2015");
	
	    ResponseEntity<String> result = restTemplate.postForEntity(baseUrl, client, String.class);		
		
	    //Verify request succeed
	    Assert.assertEquals(201, result.getStatusCodeValue());
	}
}
