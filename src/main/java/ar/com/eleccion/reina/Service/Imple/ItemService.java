package ar.com.eleccion.reina.Service.Imple;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.eleccion.reina.Entity.Item;
import ar.com.eleccion.reina.Repository.IItemRepository;
import ar.com.eleccion.reina.Service.IItemService;

@Service
public class ItemService implements IItemService{

	@Autowired
	private IItemRepository repoItem;

	@Override
	public void crearItem(Item item) {
	
	repoItem.save(item);
		
	}

	@Override
	public void eliminarItem(Long id_item) {
	
		repoItem.deleteById(id_item);
		
	}

	@Override
	public void editarItem(Long id_item, Item item) {
		
		Item itemB = this.buscarItem(id_item);
		
		itemB.setNombre(item.getNombre());
		itemB.setActividad(item.getActividad());
		itemB.setEvaluaciones(item.getEvaluaciones());
		
		this.crearItem(itemB);
	}

	@Override
	public Item buscarItem(Long id_item) {
		
		return repoItem.findById(id_item).orElse(null);
	}

	@Override
	public List<Item> listarItems() {
	
		return repoItem.findAll();
	}
	
}
