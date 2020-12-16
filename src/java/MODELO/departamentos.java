/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author cealmeba
 */
@Entity
@Table(name ="departamentos")
public class departamentos {
    @Id
    @Column(name="clave")
    private int clave;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;

    public departamentos(int clave, String nombre, String descripcion) {
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public departamentos(Integer clave) {
    }

    public departamentos() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
