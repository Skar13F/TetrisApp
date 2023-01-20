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
