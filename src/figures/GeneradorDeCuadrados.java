/**
 * Autor: Oscar Fuentes Alvarado y Nancy Obed Martínez Miguel
 * Fecha de creación: 10 de enero del 2023
 * Fecha de actualización:17 de enero del 2023
 * Descripcion :
 */
package figures;

import java.util.Random;

import enummanager.EnumFigure;
import utils.Constantes;

public class GeneradorDeCuadrados {

	public static int generateRandom(int min, int max) {
		return new Random().nextInt(max - min + 1) + min;
	}
	
	public static Figura getRegularFigure() {
		EnumFigure figure = EnumFigure.getRandomFigure();
		
		switch (figure) {
		case O_CUADRO:
			return new OCuadro();
		case I_SQUARE:
			return new ICuadro();
		case L_SQUARE:
			return new LCuadro();
		case J_SQUARE:
			return new JCuadro();
		case T_SQUARE:
			return new TCuadro();
		case Z_SQUARE:
			return new ZCuadro();
		case S_SQUARE:
			return new SCuadro();
		default:
			return null;
		}
	}
	


        /**
         * Método para retornar la figura de la vista, ya sea la figura actual
         * o la figura siguiente a salir, estas figuras se colocan a la vista
         * del usuario, en la parte superior del tablero
         */
	public static Figura getFiguraVista(EnumFigure figure, int baseX, int baseY, int width, int height) {
		switch (figure) {
		case O_CUADRO:
			return new OCuadro(Constantes.O_CUADRO, baseX, baseY, width, height);
		case I_SQUARE:
			return new ICuadro(Constantes.I_CUADRO, baseX, baseY, width, height);
		case L_SQUARE:
			return new LCuadro(Constantes.L_CUADRO, baseX, baseY, width, height);
		case J_SQUARE:
			return new JCuadro(Constantes.J_CUADRO, baseX, baseY, width, height);
		case T_SQUARE:
			return new TCuadro(Constantes.T_CUADRO, baseX, baseY, width, height);
		case Z_SQUARE:
			return new ZCuadro(Constantes.Z_CUADRO, baseX, baseY, width, height);
		case S_SQUARE:
			return new SCuadro(Constantes.S_CUADRO, baseX, baseY, width, height);
		}
		
		return null;
	}
}
