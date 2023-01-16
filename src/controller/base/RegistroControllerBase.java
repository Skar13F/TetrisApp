/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 06 de diciembre de 2022
 * Descripción: esta clase abstracat modela el controlador de los objetos
 *              extiende a la interfaz de la capa entity base.
 */
package controller.base;

import entity.base.IRegistroEntityBase;
import java.util.List;
import service.base.IRegistroServiceBase;

public abstract class RegistroControllerBase<T extends IRegistroEntityBase> {

    /**
     * Declaración de las variables
     */
    private T registro;
    private IRegistroServiceBase<T> service;

    /**
     * Método para crear o actualizar un registro en la base de datos, la
     * decisión la toma dependiendo del valor del id del registro
     */
    public void crearActualizarRegistro() {
        if (registro.getId() < 1) {
            service.insertarRegistro(registro);
        } else {
            service.actualizarRegistro(registro);
        }
    }

    /**
     * Método para obtener todos los registros una tabla en la base de datos
     */
    public List<T> obtenerRegistro() {
        return service.obtenerRegistro();
    }

    /**
     * Método para buscar un regitro de la base de datos a traés de su id
     */
    public void eliminarRegistro(int id) {
        service.eliminarRegistro(id);
    }

    /**
     * Metódo para buscar un registro en la base de datos mediante una varieble
     * de tipo String
     */
    public T buscarRegistro(String telefono) {
        return service.buscarRegistro(telefono);
    }

    //aquí se escribirán los demás métodos
    public void setService(IRegistroServiceBase<T> service) {
        this.service = service;
    }

    public T getRegistro() {
        return registro;
    }

    public void setRegistro(T registro) {
        this.registro = registro;
    }

}
