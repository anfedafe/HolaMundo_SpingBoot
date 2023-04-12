package com.coltis.HolaMundoSpringBoot;

import com.coltis.HolaMundoSpringBoot.Servicio.PersonaService;
import com.coltis.HolaMundoSpringBoot.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;

//@RestController //-AGREGAR PRIMERA ANOTACION --> restController, sirve para marcar una clase como un controlador
@Controller // comunicacion con otra clase en este caso con clase Persona y con el puerto 9090, y se indica que esta clase es el controlador
@Slf4j // ANOTACION DE LOMBOK, QUE PERMITE GENERAR AUTOMATICAMENTE CAMPOS DE REGISTROS DE UNA CLASE DE JAVA, tambien permite usar el OBJETO log, dejar mensajes en consola

public class Controlador {

    @Autowired // se usa para hacer inyecciones linea 21
    private PersonaService pService;// inyeccion de PersonaService
    //private Persona ash;
    //metodo de inicio
    @GetMapping("/") //getMappin anotacion de springFramework se usa para mapear solicitudes HTTP, obtener datos atraves del protocolo HTTP
    // Con ==> @GetMapping("/") => le damos ruta al metodo 
    public String inicio(Model model) {//Establecemos un model de Model, Sirve para pregarcar o rellenar info de la bd en html

        // Un objeto____
        var registros = pService.listarRegistro();
        model.addAttribute("rgts", registros); // rgts alias o iterador de => objeto registros

        //log.info("Ejecutando controlador rest" + registros); //para este se usa anotacion @Slf4j
        
        return "index"; // para que se vea la info de los objetos en una tabla de html, se retorna al index
    }
    
    //---------------------------------GUARDAR NUEVO
    // metodo que llama a modificarVista para agregar nuevo registro a la bd____________
    @GetMapping("/llamoVista")
    public String agregar(Persona psna){
        return "modificarVista";
    }
    // este metodo ya guarda registro nuevo
    @PostMapping("/guardar") //getMappin anotacion de springFramework se usa para mapear solicitudes HTTP, obtener datos atraves del protocolo HTTP
    // Con ==> @GetMapping("/guardar") => le damos ruta al metodo 
    public String nuevoRegistro(Persona psna) {//Establecemos un model de Model, Sirve para pregarcar o rellenar info de la bd en html

        // Un objeto____
        pService.guardar(psna);
        //model.addAttribute("nuevaPersona", nuevoRegistros); // rgts alias o iterador de => objeto registros

        return "redirect:/"; // para que se vea la info de los objetos en una tabla de html
    }
    
    // METODO MODIFICAR________________
    
    // Con ==> @GetMapping("/editar") => le damos ruta al metodo 
    @GetMapping("/editar/{idpersona}") //getMappin anotacion de springFramework se usa para mapear solicitudes HTTP, obtener datos atraves del protocolo HTTP
    
    public String editarRegistro(Persona ediRegistro, Model model) {//Establecemos un model de Model, Sirve para pregarcar o rellenar info de la bd en html

        ediRegistro = pService.encontrarPersona(ediRegistro);
        log.info("==>.."+ ediRegistro);
        model.addAttribute("persona", ediRegistro); // 

        return "modificarVista"; // muestra la pagina modificarVista
    }
    
    //METODO ELIMINAR
    @GetMapping("/eliminar") //getMappin anotacion de springFramework se usa para mapear solicitudes HTTP, obtener datos atraves del protocolo HTTP
    // Con ==> @GetMapping("/agregar") => le damos ruta al metodo 
    public String eliminarRegistro(Persona borrarRegistro) {//Establecemos un borrarRegistro como alias de Personas de Model.

        pService.eliminar(borrarRegistro);
        return "redirect:/"; 
        //return"redirect:/"  //==> me redirija al inicio
        
    }

}
