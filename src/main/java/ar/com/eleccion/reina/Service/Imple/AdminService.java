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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ar.com.eleccion.reina.Entity.Admin;
import ar.com.eleccion.reina.Entity.Rol;
import ar.com.eleccion.reina.Repository.IAdminRepository;
import ar.com.eleccion.reina.Service.IAdminService;

@Service
public class AdminService implements IAdminService {

	@Autowired
	IAdminRepository adminrepo;

	@Autowired
	BCryptPasswordEncoder codificador;

	@Override
	public Admin guardar(Admin admin) {
		admin.setPassword(codificador.encode(admin.getPassword()));

		return adminrepo.save(admin);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminrepo.findByEmail(username);
		if (admin == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(admin.getEmail(), admin.getPassword(), mapearAutoridadesRoles(admin.getRol()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Rol rol) {

		if (rol == null) {
			return Collections.emptyList();
		}

		List<GrantedAuthority> autoridades = new ArrayList<>();

		String nombreRol = rol.getNombre();

		if (nombreRol != null && !nombreRol.trim().isEmpty()) {

			autoridades.add(new SimpleGrantedAuthority(nombreRol));
		}

		return autoridades;
	}
}
