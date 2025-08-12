package ar.com.eleccion.reina.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ar.com.eleccion.reina.Entity.Admin;



public interface IAdminService extends UserDetailsService{
	
	
	Admin guardar(Admin admin);

}