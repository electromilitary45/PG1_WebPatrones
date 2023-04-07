package com.techsupport.hub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author sebas
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService users(){
        UserDetails admin = User.builder()
                .username("sebas")
                .password("{noop}2207")
                .roles("USER", "VENDEDOR", "ADMIN")
                .build();
        
        UserDetails vendedor = User.builder()
                .username("derek")
                .password("{noop}4567")
                .roles("USER", "VENDEDOR", "ADMIN")
                .build();
        
        UserDetails cliente = User.builder()
                .username("alejandro")
                .password("{noop}1234")
                .roles("USER")
                .build();
        
        return new InMemoryUserDetailsManager(cliente, vendedor, admin);
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        //Permisos index para todos (sin iniciar sesion)
                        .requestMatchers("/", 
                                "index",
                                "/errores/**",
                                "/webjars/**").permitAll()
                        
                        //Permisos solo para los administradores
                        .requestMatchers("/usuario/listado", "/usuario/nuevo",
                                "/servicio/listado", "/servicio/nuevo",
                                "/cita/listado", "/cita/nuevo").hasRole("ADMIN")
                );
        
        return http.build();
    }
}
