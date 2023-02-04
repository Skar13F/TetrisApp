/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 06 de diciembre de 2022
 * Descripción: esta clase modela el controlador de los objetos jugador, es el
 *              intermediario entre la vista y la capa servicio.
 */
package controller;

import controller.base.RegistroControllerBase;
import entity.Jugador;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import service.IJugadorService;
import service.JugadorServiceImpl;

public class JugadorController extends RegistroControllerBase<Jugador> {

    /**
     * Declaración de una variable service para utilizar en toda la clase
     */
    private IJugadorService service;

    /**
     * Instanciamos service y lo cargamos a la clase padre para que se
     * inicialice
     */
    public void init() {
        service = new JugadorServiceImpl();
        super.setService(service);
    }

    /**
     * Con este método se crea o actualiza un registro
     */
    public void crearRegistro(Jugador jugador) {
        super.setRegistro(jugador);
        super.crearActualizarRegistro();
    }

    /**
     * Método para obtener todos los registros una tabla en la base de datos,
     * los cargamos en un objeto fila y finalmente lo imprimirlos en la tabla de
     * la vista
     */
    public void mostrarRegistros(DefaultTableModel modelo) {
        List<Jugador> listaJugador = super.obtenerRegistro();
        modelo.setRowCount(0);
        for (Jugador jugador : listaJugador) {
            Object[] fila = new Object[2];
            fila[0] = String.valueOf(jugador.getId_jugador());
            fila[1] = jugador.getNombre();
            modelo.addRow(fila);
        }
    }

    /**
     * Metódo para buscar un registro en la base de datos mediante una varieble
     * de tipo String
     */
    public Jugador buscarRegistroTelefono(String telefono) {
        return service.buscarRegistro(telefono);
    }

    /**
     * Método para eliminar un regitro de la base de datos a traés de su id
     */
    public void eliminarRegistro(int id) {
        service.eliminarRegistro(id);
    }
    
     /**
     * Metódo para buscar un registro en la base de datos mediante una varieble
     * de tipo String
     */
    public void actualizarPuntos(Jugador jugador) {
        service.actualizarPuntos(jugador);
    }
}
