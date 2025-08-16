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
import ar.com.eleccion.reina.Entity.Item;
import ar.com.eleccion.reina.Service.IItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private IItemService servItem;
	
	@PostMapping("/crear")
	public String crearItem(@RequestBody Item item) {
		
		servItem.crearItem(item);
		
		return "Item creado correctamente";
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
