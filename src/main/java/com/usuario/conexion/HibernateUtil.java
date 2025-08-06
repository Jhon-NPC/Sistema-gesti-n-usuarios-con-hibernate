package com.usuario.conexion;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable e){
            throw new ExceptionInInitializerError("Fallo la creación de la SessionFactory: "+e);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}