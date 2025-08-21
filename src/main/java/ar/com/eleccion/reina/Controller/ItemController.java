package ar.com.eleccion.reina.Controller;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.com.eleccion.reina.Entity.Actividad;
import ar.com.eleccion.reina.Entity.Eleccion;
import ar.com.eleccion.reina.Entity.Item;
import ar.com.eleccion.reina.Service.IActaService;
import ar.com.eleccion.reina.Service.IActividadService;
import ar.com.eleccion.reina.Service.IItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	 IItemService servItem;
	
	@Autowired
	 IActividadService acti;
	
	
	
	
	
	@GetMapping("/alta")
	public String crear(Model model) {		
		Item item= new Item();	
		
		
		List<Actividad> ele = acti.listarActividades();
		
		
		model.addAttribute("ele", ele);
		model.addAttribute("can", item);			
		return "item/item";
	}
	
	@PostMapping("/crear")
	public String crearItem(Item item,@RequestParam("actividadId") Long actividad, RedirectAttributes redirectAttrs) {
		
		item.setActividad(acti.buscarActividad(actividad));
		servItem.crearItem(item);
		// Guardamos un flag para el modal
        redirectAttrs.addFlashAttribute("mostrarModal", true);
		return "redirect:/item/alta";
	}
	
	@DeleteMapping("/eliminar/{id_item}")
	public String eliminarItem(@PathVariable("id_item") Long id_item) {
		
		servItem.eliminarItem(id_item);
		
		
		return "Item eliminado correctamente";
	}
	
	

	
	
	
	@GetMapping("/listar")
	public List <Item> listarItems(){
		return servItem.listarItems();	
	}
	
}
