/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 06 de diciembre de 2022
 * Descripción: esta clase modela el controlador de los objetos rol, es el
 *              intermediario entre la vista y la capa servicio.
 */
package controller;

import controller.base.RegistroControllerBase;
import entity.Rol;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import service.IRolService;
import service.RolServiceImpl;

public class RolController extends RegistroControllerBase<Rol> {

    /**
     * Declaración de una variable service para utilizar en toda la clase
     */
    private IRolService service;

    /**
     * Instanciamos service y lo cargamos a la clase padre para que se
     * inicialice
     */
    public void init() {
        service = new RolServiceImpl();
        super.setService(service);
    }

    /**
     * Con este método se crea o actualiza un registro
     */
    public void crearActualizarRol(Rol rol) {
        super.setRegistro(rol);
        super.crearActualizarRegistro();
    }

    /**
     * Método para obtener todos los registros una tabla en la base de datos,
     * los cargamos en un objeto fila y finalmente lo imprimirlos en la tabla de
     * la vista
     */
    public void mostrarRegistros(DefaultTableModel modelo) {
        List<Rol> listaRol = service.obtenerRegistro();
        modelo.setRowCount(0);
        for (Rol rol : listaRol) {
            Object[] fila = new Object[2];
            fila[0] = String.valueOf(rol.getIdRol());
            fila[1] = rol.getRol();
            modelo.addRow(fila);
        }
    }

    /**
     * Metódo para buscar un registro en la base de datos mediante una varieble
     * de tipo String
     */
    public Rol buscarRegistro(String rol) {
        return service.buscarRegistro(rol);
    }

    /**
     * Método para eliminar un regitro de la base de datos a traés de su id
     */
    public void eliminarRegistro(int id) {
        service.eliminarRegistro(id);
    }

}
