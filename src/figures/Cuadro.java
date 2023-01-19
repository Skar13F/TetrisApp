/**
 * Autor: Oscar Fuentes Alvarado y Nancy Obed Martínez Miguel
 * Fecha de creación: 10 de enero del 2023
 * Fecha de actualización:17 de enero del 2023
 * Descripcion :
 */
package figures;

import java.awt.Color;

public class Cuadro {

    /**
     * posición de cada cuadro
     */
    private int x, y;

    /**
     * posiciones que ocupa cada cuadro en la matriz
     */
    private int indiceI, indiceJ;
    private Color color;
    /**
     * Ancho y alto de cada cuadro que forma la figura
     */
    int ancho;
    int alto;

    public Cuadro() {

    }

    /**
     * Método para darle un color, un ancho y alto a cada cuadro que
     * posteriormente se integra para crear la figura indicada
     */
    public Cuadro(Color color, int ancho, int alto) {
        this.color = color;
        this.ancho = ancho;
        this.alto = alto;
    }

    /**
     * Métodos set y get
     */

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getIndiceI() {
        return indiceI;
    }

    public void setIndiceI(int indiceI) {
        this.indiceI = indiceI;
    }

    public int getIndiceJ() {
        return indiceJ;
    }

    public void setIndiceJ(int indiceJ) {
        this.indiceJ = indiceJ;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * Método para ubicar cada cuadro en la matriz del tetris
     */
    public Cuadro setUbicacion(int baseX, int baseY) {
        this.x = baseX + this.indiceI * ancho;
        this.y = baseY + this.indiceJ * alto;

        return this;
    }

    /**
     * Método para obtener la sección donde se ubica cada casilla de la figura,
     * para posteriormente colorear el área
     */
    public Cuadro setUbicacion(int i, int j, int baseX, int baseY) {
        this.indiceI = i;
        this.indiceJ = j;

        this.x = baseX + this.indiceI * ancho;
        this.y = baseY + this.indiceJ * alto;

        return this;
    }

    /**
     * Método para clonar un cuadro previamente creado para después manipularlo
     * sin alterar el original se hace una copia seteando los mismos valores
     */
    public Cuadro clonar() {
        Cuadro square = new Cuadro();

        square.setColor(this.color);
        square.setIndiceI(this.indiceI);
        square.setIndiceJ(this.indiceJ);
        square.setAncho(this.ancho);
        square.setAlto(this.alto);
        square.setX(this.x);
        square.setY(this.y);

        return square;
    }
}
