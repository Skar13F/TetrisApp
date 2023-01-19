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
import enummanager.Posicion;
import static enummanager.Posicion.ABAJO;
import static enummanager.Posicion.ARRIBA;
import static enummanager.Posicion.DERECHA;
import static enummanager.Posicion.IZQUIERDA;
import utils.Constantes;

public class ICuadro extends Figura {

    /**
     * Método para definir el color y tipo de figura que se mostrará,
     * además de la ubicación de aparición en el tablero
     */
    public ICuadro() {
        super(Constantes.I_CUADRO, EnumFigure.I_SQUARE);

        this.setUbicacionCuadro(Constantes.COLUMNAS / 3, 0);
    }

    /**
     * Método para construir la figura dentro del tablero, con un tamaño
     * y ubicación específicos
     */
    public ICuadro(Color color, int baseX, int baseY, int squareSizeX, int squareSizeY) {
        super(color, baseX, baseY, squareSizeX, squareSizeY, EnumFigure.I_SQUARE);

        this.setUbicacionCuadro(0, 0);
    }

    /**
     * Método para rotar la figura
     */
    @Override
    public LinkedList<Cuadro> rotarElemento(Cuadro[][] board) {
        LinkedList<Cuadro> listaCuadros = new LinkedList<>();
        Cuadro cuadroActual;

        /**
         * Mediante este switch, si la figura está en posición arriba, la 
         * rotamos a la derecha, y si está en la posición abajo, la rotamos a 
         * la izquierda
         */
        switch (this.getPosicion()) {
            case ARRIBA:
            case DERECHA:
                cuadroActual = this.getCuadros().get(0);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() + 1, cuadroActual.getIndiceJ() - 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );

                listaCuadros.add(this.getCuadros().get(1).clonar());

                cuadroActual = this.getCuadros().get(2).clonar();
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() - 1, cuadroActual.getIndiceJ() + 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );

                cuadroActual = this.getCuadros().get(3).clonar();
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() - 2, cuadroActual.getIndiceJ() + 2, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );
                break;
            case ABAJO:
            case IZQUIERDA:
                cuadroActual = this.getCuadros().get(0).clonar();
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() - 1, cuadroActual.getIndiceJ() + 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );

                listaCuadros.add(this.getCuadros().get(1).clonar());

                cuadroActual = this.getCuadros().get(2).clonar();
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() + 1, cuadroActual.getIndiceJ() - 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );

                cuadroActual = this.getCuadros().get(3).clonar();
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() + 2, cuadroActual.getIndiceJ() - 2, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );
                break;
        }

        return listaCuadros;
    }

    /**
     * Método para pintar los cuadros en la matríz, para este caso se crea la
     * figura I o l, coloreando cuatro casillas de manera horizontal
     */
    @Override
    public void setUbicacionCuadro(int indexI, int indexJ) {
        int i = 0;
        while (i < 4) {
            this.addCuadro(indexI++, indexJ);
            i++;
        }
    }

    /**
     * Método para colocar la nueva posición de la figura al momento de 
     * rotarla, si está arriba la cambia en posición abajo y viceversa
     */
    @Override
    public void setNextPosicion() {

        if (this.getPosicion() == Posicion.ARRIBA) {
            this.setPosicion(Posicion.ABAJO);
        } else {
            this.setPosicion(Posicion.ARRIBA);
        }
    }
}
