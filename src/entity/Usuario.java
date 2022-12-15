/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 25 de noviembre de 2022
 * Fecha de actualización: 05 de diciembre de 2022
 * Descripción: clase que modela al objeto usuario, el cual contiene un
 *              id_usuario de tipo entero, un nombre de tipo String, un
 *              pasword de tipo string, id_jugador de tipo int y un id_rol
 *              de tipo int.
 */
package entity;

import entity.base.IRegistroEntityBase;

/**
 * implementará la interfaz IRegistroEntityBase para gestionar los id
 */
public class Usuario implements IRegistroEntityBase {

    /**
     * Declaración de variables
     */
    private int id_usuario;
    private String nombre;
    private String password;
    private int id_jugador;
    private int id_rol;

    /**
     * Constructor vacío y con parémetros para inicializar el objeto
     */
    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre, String password,
            int id_jugador) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.password = password;
        this.id_jugador = id_jugador;
    }

    /**
     * Métodos get y set de los atributos
     */
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    /**
     * Métodos de la interfaz implementada
     */
    @Override
    public int getId() {
        return getId_usuario();
    }

    @Override
    public void setId(int id) {
        setId_usuario(id);
    }

}
