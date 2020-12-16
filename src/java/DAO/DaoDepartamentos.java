/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.HibernateUtil;
import IDAO.IDAOGENERAL;
import MODELO.departamentos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author cealmeba
 */
public class DaoDepartamentos implements IDAOGENERAL<departamentos, Integer> {

    private SessionFactory factory;
    private Session session;
    private departamentos userone;
    private List<departamentos> userfill;

    public DaoDepartamentos() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void insert(departamentos modelo) {
        session = factory.openSession();
        session.beginTransaction();
        session.save(modelo);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Integer clave) {
        session = factory.openSession();
        session.beginTransaction();
        session.delete(new departamentos(clave));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(departamentos Departamentos) {
        session = factory.openSession();
        session.beginTransaction();
        session.update(Departamentos);
        session.getTransaction();
        session.close();
    }

    @Override
    public List<departamentos> readall() {
        session = factory.openSession();
        Query query = session.createQuery("from departamentos");
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public departamentos readone(Integer clave) {
        session = factory.openSession();
        session.beginTransaction();
        departamentos det = (departamentos) session.get(departamentos.class, clave);
        session.getTransaction();
        session.close();
        return det;

    }

}
