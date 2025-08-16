package ar.com.eleccion.reina.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	  @GetMapping("/login")
	    public String login() {    	
		  return "login/login";	      
	    }
	  @GetMapping("/")
	    public String home() {	    	 	
		return "Layaut/index"; 
	      
	    }
	 

}
