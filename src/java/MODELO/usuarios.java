/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author cealmeba
 */
@Entity
@Table(name ="usuarios")
public class usuarios implements Serializable {
 
    @Id
    @Column(name="clave")
    private int clave;
    @Column(name="nombre")
    private String nombre;
    @Column(name="direccion")
    private String domicilio;
    @Column(name="telefono")
    private String telefono;

    public usuarios(int clave, String nombre, String domicilio, String telefono) {
        this.clave = clave;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public usuarios() {
       
    }

    public usuarios(int clave) {
        this.clave = clave;
    }

    
    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
   
    
}
