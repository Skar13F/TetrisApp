/**
 * Autor: Oscar Fuentes Alvarado y Nancy Obed Martínez Miguel
 * Fecha de creación: 04 de enero del 2023
 * Fecha de actualización:20 de enero del 2023
 * Descripcion :Se implementa una clase de tipo enumerada para que se creen
 *              objetos ya especificados en la clase
 */
package enummanager;

import static enummanager.EnumFigure.values;
import java.util.Random;

public enum EnumFigure {
    O_CUADRO,
    I_SQUARE,
    L_SQUARE,
    J_SQUARE,
    T_SQUARE,
    Z_SQUARE,
    S_SQUARE;

    private static final Random PRNG = new Random();

    /*
     *Método que genera figuras aleatorias
     */
    public static EnumFigure getRandomFigure() {
        EnumFigure[] directions = values();
        return directions[PRNG.nextInt(directions.length)];
    }
}
