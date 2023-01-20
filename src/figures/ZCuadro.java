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

public class ZCuadro extends Figura {

    public ZCuadro() {
        super(Color.RED, EnumFigure.Z_SQUARE);

        this.setUbicacionCuadro(Constantes.COLUMNAS / 3, 0);
    }

    public ZCuadro(Color color, int baseX, int baseY, int squareSizeX,
            int squareSizeY) {
        super(color, baseX, baseY, squareSizeX, squareSizeY,
                EnumFigure.Z_SQUARE);

        this.setUbicacionCuadro(0, 0);
    }

    @Override
    public LinkedList<Cuadro> rotarElemento(Cuadro[][] board) {
        LinkedList<Cuadro> listaCuadros = new LinkedList<>();
        Cuadro cuadroActual;

        switch (this.getPosicion()) {
            case ARRIBA:
            case DERECHA:
                cuadroActual = this.getCuadros().get(0);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(
                                cuadroActual.getIndiceI() + 2,
                                cuadroActual.getIndiceJ() - 1,
                                Constantes.TABLERO_X,
                                Constantes.TABLERO_Y)
                );
                cuadroActual = this.getCuadros().get(1);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(
                                cuadroActual.getIndiceI() + 1,
                                cuadroActual.getIndiceJ(),
                                Constantes.TABLERO_X,
                                Constantes.TABLERO_Y)
                );

                cuadroActual = this.getCuadros().get(2);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(
                                cuadroActual.getIndiceI(),
                                cuadroActual.getIndiceJ() - 1,
                                Constantes.TABLERO_X,
                                Constantes.TABLERO_Y)
                );

                cuadroActual = this.getCuadros().get(3);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(
                                cuadroActual.getIndiceI() - 1,
                                cuadroActual.getIndiceJ(),
                                Constantes.TABLERO_X,
                                Constantes.TABLERO_Y)
                );
                break;
            case ABAJO:
            case IZQUIERDA:
                cuadroActual = this.getCuadros().get(0);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(
                                cuadroActual.getIndiceI() - 2,
                                cuadroActual.getIndiceJ() + 1,
                                Constantes.TABLERO_X,
                                Constantes.TABLERO_Y)
                );
                cuadroActual = this.getCuadros().get(1);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(
                                cuadroActual.getIndiceI() - 1,
                                cuadroActual.getIndiceJ(),
                                Constantes.TABLERO_X,
                                Constantes.TABLERO_Y)
                );

                cuadroActual = this.getCuadros().get(2);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(
                                cuadroActual.getIndiceI(),
                                cuadroActual.getIndiceJ() + 1,
                                Constantes.TABLERO_X,
                                Constantes.TABLERO_Y)
                );

                cuadroActual = this.getCuadros().get(3);
                listaCuadros.add(
                        cuadroActual.clonar().setUbicacion(
                                cuadroActual.getIndiceI() + 1,
                                cuadroActual.getIndiceJ(),
                                Constantes.TABLERO_X,
                                Constantes.TABLERO_Y)
                );
                break;
        }
        return listaCuadros;
    }

    @Override
    public void setUbicacionCuadro(int indexI, int indexJ) {
        this.addCuadro(indexI, indexJ);
        this.addCuadro(indexI + 1, indexJ);
        this.addCuadro(indexI + 1, indexJ + 1);
        this.addCuadro(indexI + 2, indexJ + 1);
    }

    @Override
    public void setNextPosicion() {

        if (this.getPosicion() == Posicion.ARRIBA) {
            this.setPosicion(Posicion.ABAJO);
        } else {
            this.setPosicion(Posicion.ARRIBA);
        }
    }
}
