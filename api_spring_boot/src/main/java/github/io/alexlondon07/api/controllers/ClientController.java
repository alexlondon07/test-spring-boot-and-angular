package github.io.alexlondon07.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import github.io.alexlondon07.api.models.Client;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import util.Constants;

@RestController
@RequestMapping(Constants.API_VERSION)
public class ClientController {

	public static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	// ------------------- GET Client----------------------------------------------------------------------------------
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiOperation("Get clients")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OK", response = Client.class) })
	@GetMapping(value = "/clients", headers = Constants.JSON)
	public @ResponseBody ResponseEntity<List<Client>> getClients() {

		RestTemplate restTemplate = new RestTemplate();
		String clients = restTemplate.getForObject(Constants.API_ROUTE, String.class);
		if( clients.equals("") ) {
			return new ResponseEntity(clients, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(clients, HttpStatus.OK);
	}

	// ------------------- POST Client----------------------------------------------------------------------------------
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiOperation("Create client")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OK", response = Client.class) })
	@PostMapping(value = "/clients",headers = Constants.JSON)
	public ResponseEntity<Client> createClient(@Validated @RequestBody Client client, UriComponentsBuilder uriBuilder,
			BindingResult bindingResult) {

		logger.info("Creating Client : {}", client.getFirstname());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(Constants.API_ROUTE, client, String.class);
		
		if( response.equals("") || response == null ) {
			return new ResponseEntity(client, HttpStatus.CONFLICT);
		}
		return new ResponseEntity(client, HttpStatus.CREATED);
	}
}
