/**
 * Autor: Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 06 de diciembre de 2022
 * Descripción: esta clase modela a un jugador que hereda de una clase persona
 *              y además tiene dos atributos más.
 */
package entity;

import entity.base.IRegistroEntityBase;

/**
 * implementará la interfaz IRegistroEntityBase para gestionar los id.
 */
public class Jugador extends Persona implements IRegistroEntityBase {

    /**
     * Declaración de variables.
     */
    private int puntos;
    private int id_jugador;

    /**
     * Implementación de los métodos get y set.
     */
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    /**
     * Métodos de la interfaz implementada.
     */
    @Override
    public int getId() {
        return getId_jugador();
    }

    @Override
    public void setId(int id) {
        setId_jugador(id_jugador);
    }

}
