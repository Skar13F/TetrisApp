/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 25 de noviembre de 2022
 * Fecha de actualización: 05 de diciembre de 2022
 * Descripción: clase que modela al objeto rol, el cual contiene un id de tipo
 *              entero y un String que guardará el rol que le corresponde.
 */
package entity;

import entity.base.IRegistroEntityBase;

/**
 * implementará la interfaz IRegistroEntityBase para gestionar los id
 */
public class Rol implements IRegistroEntityBase {

    /**
     * Declaración de variables
     */
    private int idRol;
    private String rol;

    /**
     * Constructor vacío y con parémetros para inicializar el objeto
     */
    public Rol() {
    }

    public Rol(int idRol, String rol) {
        this.idRol = idRol;
        this.rol = rol;
    }

    /**
     * Métodos get y set de los atributos
     */
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Métodos de la interfaz implementada
     */
    @Override
    public int getId() {
        return getIdRol();
    }

    @Override
    public void setId(int id) {
        setIdRol(id);
    }

}
