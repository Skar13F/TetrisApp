/**
 * Autor: Oscar Fuentes Alvarado y Nancy Obed Martínez Miguel
 * Fecha de creación: 25 de noviembre de 2022
 * Fecha de actualización:17 de enero del 2023
 * Descripcion : En esta clase se implementa el código para el tablero del
 *               tetris.
 */
package components;

import java.awt.Graphics;

import figures.Figura;
import figures.Cuadro;
import segregation.Drawable;
import utils.Constantes;

public class VerFigura implements Drawable {

    /**
     * Declaracion de las variables.
     */
    private int posicionX;
    private int posicionY;
    private Figura figura;

    /**
     * Constructor vacio de la clase VerFigura.
     */
    public VerFigura() {
        /**
         * Constructor con parámetros de la clase VerFigura.
         */
    }

    public VerFigura(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    @Override
    public void paintElement(Graphics g) {
        if (this.figura != null && !this.figura.getCuadros().isEmpty()) {
            for (Cuadro square : this.figura.getCuadros()) {
                g.setColor(square.getColor());
                g.fill3DRect(square.getX(), square.getY(), Constantes.ANCHO_DE_CUADRO_DE_VISTA, Constantes.ALTO_DE_CUADRO_DE_VISTA, true);
            }
        }
    }

    /**
     * Implementación de los métodos get y set.
     */
    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

}
