/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import hibernate.HibernateUtil;
import hibernate.Score;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ERIDE21
 */
public class DAOScore {
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

    public long guardaScore(Score score) {
        long id = 0;

        try {
            iniciaOperacion();
            id = (Long) sesion.save(score);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return id;
    }
    
    public void actualizaContacto(Score score) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(score);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Score obtenContacto(long idScore) throws HibernateException {
        Score contacto = null;
        try {
            iniciaOperacion();
            contacto = (Score) sesion.get(Score.class, idScore);
        } finally {
            sesion.close();
        }

        return contacto;
    }    
    
    public List<Score> obtenListaScore() throws HibernateException {
        List<Score> listaScore = null;

        try {
            iniciaOperacion();
            listaScore = sesion.createQuery("from Score").list();
        } finally {
            sesion.close();
        }

        return listaScore;
    }
}
