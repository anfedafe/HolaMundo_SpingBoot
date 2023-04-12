package com.coltis.HolaMundoSpringBoot.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * AQUI CONFIGURAMOS LOS ROLES DE ADMINISTRACION, SEA SUPERADMIN, CLIENTE,
 * USUARIO NORMAL, ETC...
 *
 */
@Configuration // anotacion indica que esta clase es una clase netamente de configuracion de Spring
@EnableWebSecurity // habilita la configuracion seguridad web en nuestra aplicacion

public class SecurityConfig extends WebSecurityConfigurerAdapter { //se debe heredar de ==>WebSecurityConfigurerAdapter, permite personalizar la configuracion de seguridad

    //ROLES A ACTORES O QUIENES VAN A USAR MI APLICACION____________________________________
    // ==> auth alias de AuthenticationManagerBuilder y se debe lanzar una excepcion con ==> throws Exception
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {//sobreescribimos metodo configure

        auth.inMemoryAuthentication()// inMemoryAuthentication osea que los usuarios se almacenan en memoria y no en base de datos
                .withUser("admin")//se define usuario =>admin
                .password("{noop}12345")//clave para ese usuario =>{noop} va antes de la clave hace que no le aplique ninguna codificacion a la contraseña
                .roles("ADMIN", "USER") // nuestro usuario admin va a tener rol de admin y usuario ya que por decir es un superAdmin

                .and()
                
                .withUser("user")//se define usuario otro usuario
                .password("{noop}123")//clave para ese usuario =>{noop} va antes de la clave
                .roles("USER"); //Este usuario solo rol de ==> user o usuario
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {//sobreescribimos metodo configure

        http.authorizeHttpRequests()//autorizacion de peticiones
                .antMatchers("/editar/**", "/llamoVista/**", "/eliminar")//el ultimo no lleva ni => slsh / ni doble asterisco
                .hasRole("ADMIN")
                .antMatchers("/")//
                .hasAnyRole("USER", "ADMIN")//ROL => ADMIN, DECIMOS LOS ROLES QUE USARA QUE CUMPLE CON LOS 2 ROLES QUE SE DEFINIERON

                .and()
                .formLogin()//esto detecta si nos logeamos 
                .loginPage("/login")//aqui carga el login html, O EL HTML PARA EL LOGIN

                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");//permite negar acceso cuando se intente ingresar con un usario que no este definido 

    }

}
