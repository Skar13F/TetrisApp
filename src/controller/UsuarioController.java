/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 06 de diciembre de 2022
 * Descripción: esta clase modela el controlador de los objetos usuario, es el
 *              intermediario entre la vista y la capa servicio.
 */
package controller;

import controller.base.RegistroControllerBase;
import entity.Usuario;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import service.IUsuarioService;
import service.UsuarioServiceImpl;

public class UsuarioController extends RegistroControllerBase<Usuario> {

    /**
     * Declaración de una variable service para utilizar en toda la clase
     */
    private IUsuarioService service;

    /**
     * Instanciamos service y lo cargamos a la clase padre para que se
     * inicialice
     */
    public void init() {
        service = new UsuarioServiceImpl();
        super.setService(service);
    }

    /**
     * Con este método se crea o actualiza un registro
     */
    public void crearActualizarUsuario(Usuario usuario) {
        super.setRegistro(usuario);
        super.crearActualizarRegistro();
    }

    /**
     * Método para obtener todos los registros una tabla en la base de datos,
     * los cargamos en un objeto fila y finalmente lo imprimirlos en la tabla de
     * la vista
     */
    public void mostrarRegistros(DefaultTableModel modelo) {
        List<Usuario> listaUsuario = service.obtenerRegistro();
        modelo.setRowCount(0);
        for (Usuario usuario : listaUsuario) {
            Object[] fila = new Object[3];
            fila[0] = String.valueOf(usuario.getId_usuario());
            fila[1] = usuario.getNombre();
            fila[2] = usuario.getPassword();
            modelo.addRow(fila);
        }
    }

    /**
     * Metódo para buscar un registro en la base de datos mediante un objeto de
     * tipo usuario
     */
    public Usuario buscarRegistoNC(Usuario usuario) {
        return service.buscarRegistro(usuario);
    }

    /**
     * Metódo para buscar un registro en la base de datos mediante una varieble
     * de tipo String
     */
    public Usuario buscarRegistoNombre(String nombre) {
        return service.buscarRegistro(nombre);
    }

    /**
     * Método para buscar un regitro de la base de datos a traés de su id
     */
    public Usuario buscarRegisto(int id) {
        return service.buscarRegistro(id);
    }

    /**
     * Método para eliminar un regitro de la base de datos a traés de su id
     */
    public void eliminarRegistro(int id) {
        service.eliminarRegistro(id);
    }

}
