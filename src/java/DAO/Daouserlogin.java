/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.HibernateUtil;
import MODELO.usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import DAO.Daouserlogin;

/**
 *
 * @author cealmeba
 */
public class Daouserlogin implements IDAO.IdaoLogin<usuario>{

    private Session session;

    @Override
    public usuario ChecarDatos(usuario Usuario) {
        usuario usuariochecado = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String sql = "FROM usuario WHERE nombre = '" + Usuario.getNombre()
                    + "' AND clave = '" + Usuario.getClave() + "'";
            Query query = session.createQuery(sql);

            if (!query.list().isEmpty()) {
                usuariochecado = (usuario) query.list().get(0);
            }
        } catch (Exception e) {
        } finally {

            return usuariochecado;

        }
    }

    @Override
    public void registroNuevo(usuario regis) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(regis);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
