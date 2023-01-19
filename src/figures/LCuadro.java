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

public class LCuadro extends Figura {

    public LCuadro() {
        super(Constantes.L_CUADRO, EnumFigure.L_SQUARE);

        this.setUbicacionCuadro(Constantes.COLUMNAS / 3, 0);
    }

    public LCuadro(Color color, int baseX, int baseY, int squareSizeX, int squareSizeY) {
        super(color, baseX, baseY, squareSizeX, squareSizeY, EnumFigure.L_SQUARE);

        this.setUbicacionCuadro(0, 0);
    }

    /**
     * Método para rotar la figura, esta figura como su forma es destinta en
     * cada rotación se debe contemplar todos los casos que ocurre al rotarla,
     * para ello, se valida todas las opciones y se cambia la posición en
     * sentido de las manecillas del reloj
     */
    @Override
    public LinkedList<Cuadro> rotarElemento(Cuadro[][] board) {
        LinkedList<Cuadro> listaCuadros = new LinkedList<>();
        Cuadro cuadroActual;

        switch (this.getPosicion()) {
            case ARRIBA:
                cuadroActual = this.getCuadros().get(0);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() - 1, cuadroActual.getIndiceJ(), Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );
                cuadroActual = this.getCuadros().get(1);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() + 1, cuadroActual.getIndiceJ(), Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );

                cuadroActual = this.getCuadros().get(2);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI(), cuadroActual.getIndiceJ() + 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );
                cuadroActual = this.getCuadros().get(3);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI(), cuadroActual.getIndiceJ() + 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );
                break;
            case DERECHA:
                cuadroActual = this.getCuadros().get(0);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() - 1, cuadroActual.getIndiceJ() + 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );
                listaCuadros.add(
                        this.getCuadros().get(1).clonar()
                );

                cuadroActual = this.getCuadros().get(2);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() + 1, cuadroActual.getIndiceJ() - 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );

                cuadroActual = this.getCuadros().get(3);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() - 2, cuadroActual.getIndiceJ(), Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );
                break;
            case ABAJO:
                cuadroActual = this.getCuadros().get(0);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI(), cuadroActual.getIndiceJ() - 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );

                cuadroActual = this.getCuadros().get(1);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI(), cuadroActual.getIndiceJ() - 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );
                cuadroActual = this.getCuadros().get(2);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() - 1, cuadroActual.getIndiceJ(), Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );
                cuadroActual = this.getCuadros().get(3);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() + 1, cuadroActual.getIndiceJ(), Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );
                break;
            case IZQUIERDA:
                cuadroActual = this.getCuadros().get(0);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() + 2, cuadroActual.getIndiceJ(), Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );

                cuadroActual = this.getCuadros().get(1);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() - 1, cuadroActual.getIndiceJ() + 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );
                listaCuadros.add(
                        this.getCuadros().get(2).clonar()
                );
                cuadroActual = this.getCuadros().get(3);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() + 1, cuadroActual.getIndiceJ() - 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
                );
                break;
        }
        return listaCuadros;
    }

    /**
     * Método para crear la figura j pero rotada a la derecha, para eso con el
     * this.addCuadro agregamos un cuadro que asemejará la patita y
     * posteriormente con el ciclo agregamos otros tres cuadros en forma
     * horizontal pero en la fila posterior al cuadro agregado
     *
     * Aún no se colorean, simplemente se agrega los cuadros que formarán la
     * figura en la posición adecuada
     *
     */
    @Override
    public void setUbicacionCuadro(int indexI, int indexJ) {
        this.addCuadro(indexI + 2, indexJ);

        for (int i = 0; i < 3; i++) {
            this.addCuadro(indexI++, indexJ + 1);
        }
    }

    /**
     * Método para generar la nueva posición de una figura respecto a la actual,
     * los cambios se harán en sentido de las manecillas del reloj, empezando a
     * validar por arriba, siguiente derecha, abajo y finalmente izquierda
     */
    @Override
    public void setNextPosicion() {
        if (this.getPosicion() == Posicion.ARRIBA) {
            this.setPosicion(Posicion.DERECHA);
        } else if (this.getPosicion() == Posicion.DERECHA) {
            this.setPosicion(Posicion.ABAJO);
        } else if (this.getPosicion() == Posicion.ABAJO) {
            this.setPosicion(Posicion.IZQUIERDA);
        } else if (this.getPosicion() == Posicion.IZQUIERDA) {
            this.setPosicion(Posicion.ARRIBA);
        }
    }
}
