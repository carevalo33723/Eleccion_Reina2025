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
	public List<Item> listarItems() {
	
		return repoItem.findAll();
	}


	@Override
	public void eliminarItem(Long id_item) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void editarItem(Long id_item, Item item) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Item buscarItem(int id_item) {
		
		return repoItem.findById(id_item);
	}



	


	
}
