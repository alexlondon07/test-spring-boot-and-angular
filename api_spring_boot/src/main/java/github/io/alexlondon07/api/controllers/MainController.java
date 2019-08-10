package github.io.alexlondon07.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@GetMapping("/")
	@ResponseBody
	public String index(){
		String response = "Welcome to our REST API with Spring";
		return response;
	}

}
