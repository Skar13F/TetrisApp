/**
 * Autor: Oscar Fuentes Alvarado y Nancy Obed Martínez Miguel
 * Fecha de creación: 04 de enero del 2023
 * Fecha de actualización:20 de enero del 2023
 * Descripcion :Se implementa una clase de tipo enumerada para que solo se 
 *              se utilizen esas posiciones en la clase
 */
package enummanager;

import static enummanager.Posicion.values;
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
