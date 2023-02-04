/**
 * Autor: Nancy Obed Martinez Miguel
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 16 de enero del 2023
 * Descripción: clase jugador para gestionar las transacciones a la base de
 *              datos, específicamente en la tabla jugador.
 */
package service;

import entity.Jugador;
import java.util.List;
import model.IJugadorModel;
import model.JugadorModelImpl;

public class JugadorServiceImpl implements IJugadorService {

    //hacemos una instancia a la capa model
    IJugadorModel model = new JugadorModelImpl();

    @Override
    public void insertarRegistro(Jugador registro) {
        model.insertarRegistro(registro);
    }

    @Override
    public List<Jugador> obtenerRegistro() {
        return model.obtenerRegistro();
    }

    @Override
    public void eliminarRegistro(int id) {
        model.eliminarRegistro(id);
    }

    @Override
    public Jugador buscarRegistro(String telefono) {
        return model.buscarRegistro(telefono);
    }

    @Override
    public void actualizarRegistro(Jugador registro) {
        model.actualizarRegistro(registro);
    }

    @Override
    public Jugador buscarRegistro(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizarPuntos(Jugador jugador) {
        model.actualizarPuntos(jugador);
    }

}
