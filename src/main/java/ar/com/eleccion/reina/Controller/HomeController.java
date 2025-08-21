package ar.com.eleccion.reina.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.eleccion.reina.Entity.Jurado;
import ar.com.eleccion.reina.Service.IJuradoService;

@Controller
public class HomeController {
	
	@Autowired
	IJuradoService juradoRepo;
	
	  @GetMapping("/login")
	    public String login(@RequestParam(value = "error", required = false) String error,
                @RequestParam(value = "logout", required = false) String logout,
                Model model) {
		  if (error != null) {
		        model.addAttribute("errorMsg", "Usuario o contraseña incorrectos. Verifique sus datos.");
		    }

		    if (logout != null) {
		        model.addAttribute("msg", "Ha cerrado sesión exitosamente.");
		    }
		  
		  return "login/login";	      
	    }
	  @GetMapping("/")
	    public String home(@AuthenticationPrincipal UserDetails user, Model model) {	  
		 
		  
		return "Layaut/index"; 
	      
	    }
	 

}
