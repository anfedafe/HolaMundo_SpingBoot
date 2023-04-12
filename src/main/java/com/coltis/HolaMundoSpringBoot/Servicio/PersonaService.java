
package com.coltis.HolaMundoSpringBoot.Servicio;


import com.coltis.HolaMundoSpringBoot.domain.Persona;
import java.util.List;

// COMO ESTA ES UNA interface => en la teoria en las interfaces solo se definen los metodos
// aqui solo se definen ya se implementan en la clase que los use

public interface PersonaService {
    
    
    //LISTAR REGISTRO, al llamar metodo => listarRegistro retorna una lista de Tipo Persona
    // mejor usar List cuando se necesita mostrar registro
    public List<Persona>listarRegistro();
    
    //GUARDAR REGISTRO, COMO PARAMETRO Persona psona POR QUE VOY A GUARDAR UNA PERSONA(aqui PERSONA clase en paquete Domain)
    // Variable psona de tipo Persona 
    // Como son acciones no se retorna nada por ello void
    public void guardar(Persona psona);
    
    // Borrar
    // Como son acciones no se retorna nada por ello void
    public void eliminar(Persona psona);
    
    //Encontrar persona
    // al encontrar Persona nos devuelva la persona encontrada
    public Persona encontrarPersona(Persona psona);
     
    //Actualizar
    // Como son acciones no se retorna nada por ello void
//    public void modificarPersona(Persona psona);
    
    
    
    //
}
