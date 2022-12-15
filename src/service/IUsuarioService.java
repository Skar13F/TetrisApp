package service;

import entity.Usuario;
import service.base.IRegistroServiceBase;

public interface IUsuarioService extends IRegistroServiceBase<Usuario> {

    public Usuario buscarRegistro(Usuario usuario);
}
