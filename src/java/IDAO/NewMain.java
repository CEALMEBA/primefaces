/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import DAO.DaoUsuario;
import MODELO.usuarios;
import java.util.List;

/**
 *
 * @author cealmeba
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IDAOGENERAL midao= new DaoUsuario();
        List <usuarios> users = midao.readall();
        
        
        for(usuarios user: users){
            System.out.println(user.toString());
        }
        
    }
    
}
