package ar.com.eleccion.reina.Service.Imple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.com.eleccion.reina.Entity.Admin;
import ar.com.eleccion.reina.Entity.Juez;
import ar.com.eleccion.reina.Entity.Jurado;
import ar.com.eleccion.reina.Entity.Rol;
import ar.com.eleccion.reina.Repository.IAdminRepository;
import ar.com.eleccion.reina.Repository.IJuezRepository;
import ar.com.eleccion.reina.Repository.IJuradoRepository;

@Service
public class UsuarioMultiple implements UserDetailsService{
	
	@Autowired
	IAdminRepository adminrepo;
	
	@Autowired
	IJuezRepository juezrepo;
	
	@Autowired
	IJuradoRepository juradoRepo;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	    Jurado jurado = juradoRepo.findByEmail(username);
	    if (jurado != null) {
	        return new User(jurado.getEmail(), jurado.getPassword(), mapearAutoridadesRoles(jurado.getRol()));
	    }

	    Juez juez = juezrepo.findByEmail(username);
	    if (juez != null) {
	        return new User(juez.getEmail(), juez.getPassword(), mapearAutoridadesRoles(juez.getRol()));
	    }

	     Admin admin = adminrepo.findByEmail(username);
	    if (admin != null) {
	        return new User(admin.getEmail(), admin.getPassword(), mapearAutoridadesRoles(admin.getRol()));
	    }

	    
	    throw new UsernameNotFoundException("Usuario no encontrado con el email: " + username);
	}
	
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Rol rol) {

		if (rol == null) {
			return Collections.emptyList();
		}

		List<GrantedAuthority> autoridades = new ArrayList<>();

		String nombreRol = rol.getNombre();
		System.out.println(nombreRol);
		if (nombreRol != null && !nombreRol.trim().isEmpty()) {

			autoridades.add(new SimpleGrantedAuthority(nombreRol));
		}

		return autoridades;
	}

	
	

}
