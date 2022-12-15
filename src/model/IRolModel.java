/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 06 de diciembre de 2022
 * Descripción: interfaz para el model de la clase Rol.
 */
package model;

import entity.Rol;
import java.util.List;

public interface IRolModel {

    /**
     * Declaración de métodos abstractos
     */
    public void insertarRegistro(Rol rol);

    public List<Rol> obtenerRegistro();

    public void eliminarRegistro(int id);

    public Rol buscarRegistro(String rol);

    public void actualizarRegistro(Rol rol);
}
