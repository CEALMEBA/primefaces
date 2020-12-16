/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import IDAO.IDAOGENERAL;
import MODELO.departamentos;

/**
 *
 * @author alsorc
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IDAOGENERAL dao = new DaoDepartamentos();
        //dao.insert(new departamentos(2, "test", "descripcion"));
        dao.delete(12);
        
        
        
    }
    
}
