package com.usuario.dao;

import com.usuario.modelo.Usuario;
import java.util.List;

public interface UsuarioDAOInterface {
    void insertar(Usuario usuario) throws Exception;
    List<Usuario> listar() throws Exception;
    void actualizar(Usuario usuario) throws Exception;
    void eliminar(int id) throws Exception;
}