/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 16 de enero 2023
 * Descripción: interfaz para la clase Usuario controller.
 */
package service;

import entity.Usuario;
import service.base.IRegistroServiceBase;

public interface IUsuarioService extends IRegistroServiceBase<Usuario> {

    public Usuario buscarRegistro(Usuario usuario);
}
