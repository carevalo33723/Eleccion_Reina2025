package ar.com.eleccion.reina.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.eleccion.reina.Entity.Admin;
import ar.com.eleccion.reina.Service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService servAdmin;
	
	@PostMapping("/crear")
	public String crearAdmin(@RequestBody Admin admin) {
		
		servAdmin.crearAdmin(admin);
		
		return "Admin creado correctamente";
	}
	
	@DeleteMapping("/eliminar/{id_admin}")
	public String eliminarAdmin(@PathVariable("id_admin") Long id_admin) {
		
		servAdmin.eliminarAdmin(id_admin);
		
		return "Admin eliminado correctamente";
	}
	
	@PutMapping("/editar/{id_admin}")
	public Admin editarAdmin(@PathVariable ("id_admin") Long id_admin,
			                         @RequestBody Admin admin) {
		
		servAdmin.editarAdmin(id_admin, admin);
		
		return servAdmin.buscarAdmin(id_admin);
	}

	@GetMapping("/buscar/{id_admin}")
	public Admin buscarAdmin(@PathVariable ("id_admin") Long id_admin) {
		
		return servAdmin.buscarAdmin(id_admin);
	}
	
	
	@GetMapping("/listar")
	public List <Admin> listarAdminds(){
		return servAdmin.listarAdminds();	
	}
	
}
