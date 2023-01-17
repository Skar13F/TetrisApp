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

/**
 * Enum para indicar la orientación de las figuras, por default siempre
 * iniciará arriba
 */
public enum Posicion {
	DERECHA,
	IZQUIERDA,
	ARRIBA,
	ABAJO;

    private static final Random PRNG = new Random();

    /**
     * 
     */
    public static Posicion randomDirection()  {
    	Posicion[] directions = values();
        return directions[PRNG.nextInt(directions.length)];
    }
}
