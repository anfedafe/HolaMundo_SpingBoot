
package com.coltis.HolaMundoSpringBoot.Dao;

import com.coltis.HolaMundoSpringBoot.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * ESTA CLASE LA VAMOS A USAR COMO INTERFAZ, PARA declarar metodos del CRUD
 */
// heredamos de CrudRepository => ya trae todas las funciones de un crud incluidas automaticamente
// CrudRepository<Clase que hacemos referencia, Tipo de dato clave primaria de la tabla>
public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
