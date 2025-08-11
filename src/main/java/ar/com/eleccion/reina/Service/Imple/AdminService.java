package ar.com.eleccion.reina.Service.Imple;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.eleccion.reina.Entity.Admin;
import ar.com.eleccion.reina.Repository.IAdminRepository;
import ar.com.eleccion.reina.Service.IAdminService;

@Service
public class AdminService implements IAdminService{

	@Autowired
	private IAdminRepository repoAdmin;

	@Override
	public void crearAdmin(Admin admin) {
		
		repoAdmin.save(admin);
		
	}

	@Override
	public void eliminarAdmin(Long id_admin) {
		
		repoAdmin.deleteById(id_admin);
	}

	@Override
	public void editarAdmin(Long id_admin, Admin admin) {
		
		Admin adminB = this.buscarAdmin(id_admin);
		
		adminB.setDni(admin.getDni());
		adminB.setNombre(admin.getNombre());
		adminB.setApellido(admin.getApellido());
		
		this.crearAdmin(adminB);
	}

	@Override
	public Admin buscarAdmin(Long id_admin) {
	
		return repoAdmin.findById(id_admin).orElse(null);
	}

	@Override
	public List<Admin> listarAdminds() {
		
		return repoAdmin.findAll();
	}

}
