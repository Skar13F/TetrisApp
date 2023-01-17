/**
 * Autor: Oscar Fuentes Alvarado y Nancy Obed Martínez Miguel
 * Fecha de creación: 10 de enero del 2023
 * Fecha de actualización:17 de enero del 2023
 * Descripcion :
 */
package figures;

import java.awt.Color;
import java.util.LinkedList;

import enummanager.EnumFigure;
import utils.Constantes;

public class OCuadro extends Figura {

    /**
     * Constructor para una figura regular que se pondrá en juego
     * se pone la posición en la cual aparecer
     */
    public OCuadro() {
        super(Constantes.O_CUADRO, EnumFigure.O_CUADRO);
        this.setUbicacionCuadro(Constantes.COLUMNAS / 3, 0);
    }

    /**
     * Constructor de cada cuadro de la figura, dentro del tablero
     * 
     */
    public OCuadro(Color color, int baseX, int baseY, int tamanioCuadroX, int tamanioCuadroY) {
        super(color, baseX, baseY, tamanioCuadroX, tamanioCuadroY, EnumFigure.O_CUADRO);
        this.setUbicacionCuadro(0, 0);
    }

    /**
     * En este caso como es un cudrrado formado de cuatro pequeños, no tiene
     * caso rotarlo porque siempre se mirará igual, por ello el método retorna
     * null, no se realiza ninguna acción
     */
    @Override
    public LinkedList<Cuadro> rotarElemento(Cuadro[][] board) {
        return null;
    }

    /**
     * Método para dibujar la figura
     */
    @Override
    public void setUbicacionCuadro(int indexI, int indexJ) {
        this.addCuadro(indexI, indexJ);
        this.addCuadro(indexI + 1, indexJ);
        this.addCuadro(indexI, indexJ + 1);
        this.addCuadro(indexI + 1, indexJ + 1);

    }

    /**
     * La posición de la figura no cambia ya que su forma siempre es la misma
     */
    @Override
    public void setNextPosicion() {

    }

}
