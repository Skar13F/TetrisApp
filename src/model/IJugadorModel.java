/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 06 de diciembre de 2022
 * Descripción: interfaz para el model de la clase jugador.
 */
package model;

import entity.Jugador;
import java.util.List;

public interface IJugadorModel {

    /**
     * Declaración de métodos abstractos
     */
    public void insertarRegistro(Jugador jugador);

    public List<Jugador> obtenerRegistro();

    public void eliminarRegistro(int id);

    public Jugador buscarRegistro(String telefono);

    public void actualizarRegistro(Jugador jugador);
    
    public void actualizarPuntos(Jugador jugador);
}
