package com.usuario.dao;

import java.util.List;
import com.usuario.conexion.HibernateUtil;
import com.usuario.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAOImplementado implements UsuarioDAOInterface{

    @Override
    public void insertar(Usuario usuario) throws Exception{
        Transaction tr = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tr = session.beginTransaction();
            session.persist(usuario);
            tr.commit();
        }catch(Exception e){
            if(tr != null){
                tr.rollback();
            }
            throw e;
        }
    }

    @Override
    public List<Usuario> listar() throws Exception{
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Usuario", Usuario.class).list();
        }
    }

    @Override
    public void actualizar(Usuario usuario) throws Exception{
        Transaction tr = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tr = session.beginTransaction();
            session.update(usuario);
            tr.commit();
        }catch (Exception e){
            if(tr != null){
                tr.rollback();
            }
            throw e;
        }
    }

    @Override
    public void eliminar(int id) throws Exception{
        Transaction tr = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            tr = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            if(usuario != null){
                session.remove(usuario);
            }
            tr.commit();
        } catch (Exception e) {
            if(tr != null){
                tr.rollback();
            }
            throw e;
        }
    }
    
}