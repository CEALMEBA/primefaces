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
@Table(name ="usuario")
public class usuario implements Serializable{
    
    @Id
     @Column(name="clave")
    private int clave;
     @Column(name="nombre")
    private String nombre;

    public usuario(int clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }
 
    
    public usuario() {
       
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
    
    
    
}
