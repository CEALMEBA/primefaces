/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import java.util.List;

/**
 *
 * @author cealmeba
 */
public interface IDAOGENERAL<T,V> {
     
    public void insert(T t);
    public void delete( V clave);
    public void update(T t);
    List<T> readall();
    public T readone(V clave);
  
    
}
