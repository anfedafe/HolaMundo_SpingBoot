
package com.coltis.HolaMundoSpringBoot.Servicio;

import com.coltis.HolaMundoSpringBoot.Dao.PersonaDao;
import com.coltis.HolaMundoSpringBoot.domain.Persona;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//aqui se implementan los metodos de PersonaService,y por teoria si heredo de una interfaz
// obligatoriamente se deben implementar todos los metodos 

@Service //NOTACION DE SERVICIOS, se declara, que esta es la clase de servicios, capa que las peticiones
public class PersonaServiceImpl implements PersonaService {
    @Autowired //ANOTACION => permite inyectar los datos, como en linea 20, lo que hace es, permite esta
                // clase me traiga todo los datos de la clase PersonaDao
    
    private PersonaDao PersDao; // esto es inyeccion de datos( DE PersonaDao A ESTA CLASE Y SE USA ANOTACION @Autowired ), SE DECLARA como si fuese un objeto o dato PersDao de TIPO PersonaDao

    
    // EN TODO LOS METODOS USAR @Transactional ==>
    @Override
    @Transactional(readOnly = true) //con esto, hace que el metodo listarRegistro sea de solo listar registros o de solo lectura, que no se pueda eliminar no editar
    public List<Persona> listarRegistro() {    
        //se retorna el proceso para listar y atraves de la inyeccion en linea 20 me trae el metodo finAll()
       return (List<Persona>)PersDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona psona) {
        PersDao.save(psona);
    }

    @Override
    @Transactional
    public void eliminar(Persona psona) {
        PersDao.deleteById(psona.getIdpersona());
       
    }

    @Override
    
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona psona) { // ENCONTRAR POR ID
        return PersDao.findById(psona.getIdpersona()).orElse(null); // psona.getIdpersona() ==> se obtiene el id de la persona
        //orElse(null) ==> si no hay un id devuelve null
    }

//    @Override
//    @Transactional()
//    public void modificarPersona(Persona psona) {
//        PersDao.save(psona);
//    }
    
}
