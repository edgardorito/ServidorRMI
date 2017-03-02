/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import hibernate.HibernateUtil;
import hibernate.Preguntas;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ERIDE21
 */
public class DAOPreguntas {
     private Session sesion;
    private Transaction tx;
    
    private void iniciaOperacion() throws HibernateException{
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }
    
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
    
    public List<Preguntas> obtenListaPreguntas() throws HibernateException {
        List<Preguntas> listaPreguntas = null;

        try {
            iniciaOperacion();
            listaPreguntas = sesion.createQuery("from Preguntas").list();
        } finally {
            sesion.close();
        }

        return listaPreguntas;
    }
}
