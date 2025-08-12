package ar.com.eleccion.reina.Service;

import java.util.List;

import ar.com.eleccion.reina.Entity.Admin;

public interface IAdminService {

    public void crearAdmin(Admin admin);
	
	public void eliminarAdmin(Long id_admin);
	
	public void editarAdmin(Long id_admin, Admin admin);
	
	public Admin buscarAdmin(Long id_admin);
	
	public List<Admin> listarAdminds();
	
}
