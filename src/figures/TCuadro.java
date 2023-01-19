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

public class TCuadro extends Figura {

	public TCuadro() {
		super(Constantes.T_CUADRO, EnumFigure.T_SQUARE);

		this.setUbicacionCuadro(Constantes.COLUMNAS / 3, 0);
	}
	
	public TCuadro(Color color, int baseX, int baseY, int squareSizeX, int squareSizeY) {
		super(color, baseX, baseY,squareSizeX, squareSizeY, EnumFigure.T_SQUARE);

		this.setUbicacionCuadro(0, 0);
	}

	@Override
	public LinkedList<Cuadro> rotarElemento(Cuadro[][] board) {
		LinkedList<Cuadro> listaCuadros = new LinkedList<>();
		Cuadro cuadroActual;

		switch(this.getPosicion()) {
			case ARRIBA:
				listaCuadros.add(cuadroActual = this.getCuadros().get(0).clonar());

				cuadroActual = this.getCuadros().get(1);
				listaCuadros.add(
					cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() + 1, cuadroActual.getIndiceJ(), Constantes.TABLERO_X, Constantes.TABLERO_Y)
				);

				cuadroActual = this.getCuadros().get(2);
				listaCuadros.add(
						cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() + 1, cuadroActual.getIndiceJ(), Constantes.TABLERO_X, Constantes.TABLERO_Y)
				);
				cuadroActual = this.getCuadros().get(3);
				listaCuadros.add(
						cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() -1, cuadroActual.getIndiceJ() + 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
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
				listaCuadros.add(
						this.getCuadros().get(2).clonar()
				);
				listaCuadros.add(
						this.getCuadros().get(3).clonar()
				);
				break;
			case ABAJO:
				cuadroActual = this.getCuadros().get(0);
				listaCuadros.add(
						cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() + 1, cuadroActual.getIndiceJ() - 1, Constantes.TABLERO_X, Constantes.TABLERO_Y)
				);
				cuadroActual = this.getCuadros().get(1);
				listaCuadros.add(
						cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() - 1, cuadroActual.getIndiceJ(), Constantes.TABLERO_X, Constantes.TABLERO_Y)
				);
				cuadroActual = this.getCuadros().get(2);
				listaCuadros.add(
						cuadroActual.clonar().setUbicacion(cuadroActual.getIndiceI() - 1, cuadroActual.getIndiceJ(), Constantes.TABLERO_X, Constantes.TABLERO_Y)
				);
				listaCuadros.add(
						this.getCuadros().get(3).clonar()
				);
				break;
			case IZQUIERDA:
				listaCuadros.add(
						this.getCuadros().get(0).clonar()
				);
				cuadroActual = this.getCuadros().get(1);
				listaCuadros.add(
						this.getCuadros().get(1).clonar()
				);
				cuadroActual = this.getCuadros().get(2);
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

	@Override
	public void setUbicacionCuadro(int indexI, int indexJ) {
		this.addCuadro(indexI + 1, indexJ);

		for(int i = 0; i < 3; i++) {
			this.addCuadro(indexI++, indexJ + 1);
		}
	}

	@Override
	public void setNextPosicion() {
		if(this.getPosicion() == Posicion.ARRIBA) {
			this.setPosicion(Posicion.DERECHA);
		} else if(this.getPosicion() == Posicion.DERECHA){
			this.setPosicion(Posicion.ABAJO);
		} else if(this.getPosicion() == Posicion.ABAJO){
			this.setPosicion(Posicion.IZQUIERDA);
		} else if(this.getPosicion() == Posicion.IZQUIERDA){
			this.setPosicion(Posicion.ARRIBA);
		}
	}
}
