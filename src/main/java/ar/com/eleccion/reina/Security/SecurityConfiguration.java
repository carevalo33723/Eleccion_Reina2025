package ar.com.eleccion.reina.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ar.com.eleccion.reina.Service.IAdminService;
import ar.com.eleccion.reina.Service.Imple.UsuarioMultiple;

@Configuration

public class SecurityConfiguration {
	
	 // Servicio que devuelve UserDetails 
    @Autowired
	IAdminService adminService;
    @Autowired
    UsuarioMultiple usuMulti;
    
    
    
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
	
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /*
     * 
     * 
     * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
     * throws Exception { http .userDetailsService(adminService) // ya no se
     * necesita authenticationProvider() .authorizeHttpRequests()
     * .requestMatchers("/registro**", "/js/**", "/css/**", "/img/**").permitAll()
     * .anyRequest().authenticated() .and() .formLogin() .loginPage("/login")
     * .permitAll() .and() .logout() .invalidateHttpSession(true)
     * .clearAuthentication(true) .logoutRequestMatcher(new
     * AntPathRequestMatcher("/logout")) .logoutSuccessUrl("/login?logout")
     * .permitAll();
     * 
     * return http.build(); }
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .userDetailsService(usuMulti) 

            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/registro**", "/dist/js/**", "/dist/css/**","/reporte"
                		, "/dist/img/**",
                		"/plugins/**").permitAll()					
						  .requestMatchers("/juez").hasAuthority("ROL_JUEZ")					  
						  .requestMatchers("/jurado").hasAuthority("ROL_JURADO")
						  .requestMatchers("/eleccion/alta").hasAuthority("ROL_ADM")						 
                .anyRequest().authenticated()
                
            )
            .formLogin(form -> form
                .loginPage("/login")
                .usernameParameter("email")   
                .passwordParameter("password")
                
                .permitAll()
            )
            .logout(logout -> logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );
        return http.build();
    }


}
