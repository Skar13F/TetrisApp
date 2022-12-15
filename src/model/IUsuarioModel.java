/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 06 de diciembre de 2022
 * Descripción: interfaz para el model de la clase usuario.
 */
package model;

import entity.Usuario;
import java.util.List;

public interface IUsuarioModel {

    /**
     * Declaración de métodos abstractos
     */
    public void insertarRegistro(Usuario usuario);

    public List<Usuario> obtenerRegistro();

    public void eliminarRegistro(int id);

    public Usuario buscarRegistro(int id);

    public Usuario buscarRegistro(Usuario user);

    public Usuario buscarRegistro(String nombre);

    public void actualizarRegistro(Usuario usuario);
}
