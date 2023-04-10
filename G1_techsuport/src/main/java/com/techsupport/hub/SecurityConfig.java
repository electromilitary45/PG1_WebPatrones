
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

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService users(){
        UserDetails admin1 = User.builder()
                .username("sebas")
                .password("{noop}2207")
                .roles("CLIENTE", "EMPLEADO", "ADMINISTRADOR")
                .build();
        
        UserDetails admin2 = User.builder()
                .username("derek")
                .password("{noop}2145")
                .roles("CLIENTE", "EMPLEADO", "ADMINISTRADOR")
                .build();
        
        UserDetails cliente = User.builder()
                .username("alejandro")
                .password("{noop}1234")
                .roles("CLIENTE")
                .build();
        
        return new InMemoryUserDetailsManager(cliente, admin1, admin2);
    }
    /*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        //Permisos index para todos (sin iniciar sesion)
                        .requestMatchers("/", 
                                "/index",
                                "/servicio/listadoC",
                                "/errores/**",
                                "/webjars/**").permitAll()
                        
                        //Permisos solo para los administradores
                        .requestMatchers(
                                "/usuario/listado", 
                                "/usuario/nuevo",
                                "/servicio/listado",
                                "/servicio/nuevo",
                                "/cita/listado",
                                "/cita/nuevo")
                        .hasRole("ADMINISTRADOR")
                );
        
        return http.build();
    }*/
}

