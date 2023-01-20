package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Constantes {

    /**
     * Tamaño de la pantalla principal
     */
    public static final int ANCHO_DE_VISTA = 500;
    public static final int ALTO_DE_VISTA = 650;
    /**
     * Ubicación del tablero de juego en la ventana principal
     */
    public static final int TABLERO_X = 25;
    public static final int TABLERO_Y = 100;
    /**
     * Tamaño del tablero de juego
     */
    public static final int ANCHO_DE_PANTALLA = 400;
    public static final int ALTO_DE_PANTALLA = 400;
    /*
     * Cantidad de filas y columnas que  tendrá el tablero
     */
    public static final int COLUMNAS = 10;
    public static final int FILAS = 80;

    /**
     * Calculamos el alto y ancho de cada cuadrito que conformará una figura
     */
    public static final int ANCHO_DE_CADA_CUADRITO = ANCHO_DE_PANTALLA / COLUMNAS;
    public static final int ALTO_DE_CADA_CUADRITO = ALTO_DE_PANTALLA / FILAS;

    /**
     * Cálculo de ancho y alto de la vista donde aparecera la figura actual
     * y la siguiente en mostrarse
     */
    public static final int ANCHO_VISTA_FIGURA = (int) (Constantes.ANCHO_DE_PANTALLA * 0.3);
    public static final int ALTO_VISTA_FIGURA = (int) (Constantes.ANCHO_DE_PANTALLA * 0.1);
    
    public static final int ANCHO_DE_CUADRO_DE_VISTA = (int) (ANCHO_VISTA_FIGURA * 0.2);
    public static final int ALTO_DE_CUADRO_DE_VISTA = (int) (ALTO_VISTA_FIGURA * 0.5);

    public static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public static final int TAMANIO_DE_FUENTE = (int) (Constantes.ALTO_VISTA_FIGURA * 0.5);
    public static Font FUENTE = new Font("TimesRoman", Font.PLAIN, TAMANIO_DE_FUENTE);

    /**
     * Definimos el color que tendrá cada cuadro dependiendo de la figura que
     * que formará, ejemplo para la figura de la T los cuadros que la 
     * conformarán será de color magenta
     */
    public static Color I_CUADRO = Color.CYAN;
    public static Color S_CUADRO = Color.GREEN;
    public static Color Z_CUADRO = Color.RED;
    public static Color J_CUADRO = Color.BLUE;
    public static Color L_CUADRO = Color.ORANGE;
    public static Color O_CUADRO = Color.YELLOW;
    public static Color T_CUADRO = Color.MAGENTA;
}
