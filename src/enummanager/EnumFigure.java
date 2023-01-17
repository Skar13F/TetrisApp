/**
 * Autor: Oscar Fuentes Alvarado y Nancy Obed Martínez Miguel
 * Fecha de creación: 25 de noviembre de 2022
 * Fecha de actualización:17 de enero del 2023
 * Descripcion :La implementación de una clase de tipo enumerado para
 *              limitar la creación de objetos a los especificos explicitamente
 *              en la implementación de la clase.
 */
package enummanager;

import java.util.Random;

/* 
 *clase enumerada para que solo se creen las figuras especificadas en la clase
 */
public enum EnumFigure {
    O_CUADRO,
    I_SQUARE,
    L_SQUARE,
    J_SQUARE,
    T_SQUARE,
    Z_SQUARE,
    S_SQUARE;

    private static final Random PRNG = new Random();

    public static EnumFigure getRandomFigure() {
        EnumFigure[] directions = values();
        return directions[PRNG.nextInt(directions.length)];
    }
}
