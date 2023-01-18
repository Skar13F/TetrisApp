/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización:16 de enero del 2023
 * Descripción: clase Usuario para gestionar las transacciones a la base de
 *              datos, específicamente en la tabla usuario.
 */
package service;

import entity.Usuario;
import java.util.List;
import model.IUsuarioModel;
import model.UsuarioModelImpl;

public class UsuarioServiceImpl implements IUsuarioService {

    //hacemos una instancia a la capa model
    IUsuarioModel model = new UsuarioModelImpl();

    @Override
    public void insertarRegistro(Usuario registro) {
        model.insertarRegistro(registro);
    }

    @Override
    public List<Usuario> obtenerRegistro() {
        return model.obtenerRegistro();
    }

    @Override
    public void eliminarRegistro(int id) {
        model.eliminarRegistro(id);
    }

    @Override
    public Usuario buscarRegistro(int id) {
        return model.buscarRegistro(id);
    }

    @Override
    public void actualizarRegistro(Usuario registro) {
        model.actualizarRegistro(registro);
    }

    @Override
    public Usuario buscarRegistro(Usuario registro) {
        return model.buscarRegistro(registro);
    }

    @Override
    public Usuario buscarRegistro(String nombre) {
        return model.buscarRegistro(nombre);
    }

}
