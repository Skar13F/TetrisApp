/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización:16 de enero del 2023
 * Descripción: clase Rol para gestionar las transacciones a la base de
 *              datos, específicamente en la tabla rol..
 */

package service;

import entity.Rol;
import java.util.List;
import model.IRolModel;
import model.RolModelImpl;

public class RolServiceImpl implements IRolService {

    //hacemos una instancia a la capa model
    IRolModel model = new RolModelImpl();

    @Override
    public void insertarRegistro(Rol registro) {
        model.insertarRegistro(registro);
    }

    @Override
    public List<Rol> obtenerRegistro() {
        return model.obtenerRegistro();
    }

    @Override
    public void eliminarRegistro(int id) {
        model.eliminarRegistro(id);
    }

    @Override
    public Rol buscarRegistro(String rol) {
        return model.buscarRegistro(rol);
    }

    @Override
    public void actualizarRegistro(Rol registro) {
        model.actualizarRegistro(registro);
    }

    @Override
    public Rol buscarRegistro(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
