/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 06 de diciembre de 2022
 * Descripción: interfaz para las clases que están en la capa controller.
 */
package service.base;

import java.util.List;

public interface IRegistroServiceBase<T> {

    /**
     * Declaración de los métodos absatractos
     */
    public void insertarRegistro(T registro);

    public List<T> obtenerRegistro();

    public void eliminarRegistro(int id);

    public T buscarRegistro(int id);

    public T buscarRegistro(String nombre);

    public void actualizarRegistro(T registro);
}
