package ar.com.eleccion.reina.Service;

import java.util.List;

import ar.com.eleccion.reina.Entity.Item;

public interface IItemService {

	public void crearItem(Item item);
	
	public void eliminarItem(Long id_item);
	
	public void editarItem(Long id_item, Item item);
	
	public Item buscarItem(int id_item);
	
	public List<Item> listarItems();
}
