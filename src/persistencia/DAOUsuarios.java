/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import hibernate.Usuario;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ERIDE21
 */
public class DAOUsuarios {
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

    public long guardaUsuarios(Usuario usuario) {
        long id = 0;

        try {
            iniciaOperacion();
            id = (long) sesion.save(usuario);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return id;
    }
    
    //Obtiene un usuario dependiento del id
    public Usuario obtenUsuario(long idUsuario) throws HibernateException {
        Usuario usuario = null;

        try {
            iniciaOperacion();
            usuario = (Usuario) sesion.get(Usuario.class, idUsuario);
        } finally {
            sesion.close();
        }
        return usuario;
    }
    
    public void actualizaContacto(Usuario usuario) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(usuario);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }
    
    public List<Usuario> obtenListaUsuarios() throws HibernateException {
        List<Usuario> listaUsuarios = null;

        try {
            iniciaOperacion();
            listaUsuarios = sesion.createQuery("from Usuario").list();
        } finally {
            sesion.close();
        }

        return listaUsuarios;
    }
    
}
