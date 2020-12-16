/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import IDAO.IDAOGENERAL;
import MODELO.usuarios;
import Beans.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author cealmeba
 */
public class DaoUsuario implements IDAOGENERAL<usuarios, Integer>{
   private SessionFactory factory;
   private Session session;
   private usuarios userone;
   private List<usuarios>userfill;
   
   public DaoUsuario(){
       factory =HibernateUtil.getSessionFactory();
   }
    @Override
    public void insert(usuarios modelo) {
         session= factory.openSession();
         session.beginTransaction();
         session.save(modelo);
         session.getTransaction().commit();
         session.close();
       
        
    }

    @Override
    public void delete(Integer clave) {
        session=factory.openSession();
        session.beginTransaction();
        session.delete(new usuarios(clave));
        session.getTransaction().commit();
        session.close();
    }   
    @Override
    public void update(usuarios  usuario) {
       session= factory.openSession();
       session.beginTransaction();
       session.update(usuario);
       session.getTransaction();
       session.close();
    }

    @Override
    public List<usuarios> readall() {
     session= factory.openSession();
     Query query = session.createQuery("from usuarios");
     List list=query.list();
     session.close();
     return list;
    }

    @Override
    public usuarios readone(Integer clave) {
     session= factory.openSession();
     session.beginTransaction();
     usuarios user = (usuarios) session.get(usuarios.class, clave);
     session.getTransaction();
     session.close();
     return user;
     
    }
    
}
