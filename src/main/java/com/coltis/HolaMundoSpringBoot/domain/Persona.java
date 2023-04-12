
package com.coltis.HolaMundoSpringBoot.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


 // AQUI USAMOS Data de LOMBOK Y DESDE EL CONTROLADOR VAMOS A TENER TODO EL FLUJO DE INFORMACION DE LOS QUE SE DESEA HA
@Data // Con este permite permite que no tengamos la necesidad de crear constructores o metodos accesores, con Data se genera automaticamente asi no se vea
@Entity //dependencia =>ES como si dijeramos que esto es una entidad o tabla de la bases de datos, los atrubtos de aqui deben ser iguales a los de la bd
@Table(name = "persona") //dependencia=> nos trae todo lo de la tabla de la bd y  name = "persona" es el nombre de la tabla en la bd
public class Persona implements Serializable{
    
    private static final long serialVersionUID=1L; // como usamos => serialVersionUID, se debe implementar -> Serializable
    

    //ATRIBUTOS
    
    @Id //indicamos llave primaria key, encima del atributo que va hacer la llave primary, esto porque usamos el  @Table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indicamos que las claves primarias las genera la bd, o decir que la primary key se genera autmoaticamente
    private long idpersona; // long tipo de dato, esta va hacer llave primaria
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
 
}
