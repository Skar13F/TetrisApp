package service;

import entity.Rol;
import java.util.List;
import model.IRolModel;
import model.RolModelImpl;

public class RolServiceImpl implements IRolService {

    //hacemos una instancia a la capa model
    IRolModel model = new RolModelImpl();

    @Override
    public void insertarRegistro(Rol registro) {
        model.insertarRegistro(registro);
    }

    @Override
    public List<Rol> obtenerRegistro() {
        return model.obtenerRegistro();
    }

    @Override
    public void eliminarRegistro(int id) {
        model.eliminarRegistro(id);
    }

    @Override
    public Rol buscarRegistro(String rol) {
        return model.buscarRegistro(rol);
    }

    @Override
    public void actualizarRegistro(Rol registro) {
        model.actualizarRegistro(registro);
    }

    @Override
    public Rol buscarRegistro(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
