package figures;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import enummanager.EnumFigure;
import enummanager.Posicion;
import segregation.Drawable;
import utils.Constantes;

/**
 * Se implementa una interfaz Drawable para que cada clase que quiera pintar
 * algo agregue esa interfaz sin complicación
 */
public abstract class Figura implements Drawable {

    private LinkedList<Cuadro> cuadros = new LinkedList<>();
    private Color color;
    private Posicion posicion;
    private int ancho, alto;
    private int baseX, baseY;
    private EnumFigure figureType;

    public Figura() {
        this.posicion = Posicion.randomDirection();
    }

    /**
     * Constructor para una figura regular, la posición siempre se situa en
     * valor arriba
     */
    public Figura(Color color, EnumFigure figureType) {
        this.posicion = Posicion.ARRIBA;
        this.color = color;
        this.baseX = Constantes.TABLERO_X;
        this.baseY = Constantes.TABLERO_Y;
        this.figureType = figureType;

        // Usar la localización del tablero
        this.ancho = Constantes.ANCHO_DE_CADA_CUADRITO;
        this.alto = Constantes.ALTO_DE_CADA_CUADRITO;
    }

    /**
     * Constructor para la figura dentro de una ubicación y con un tamaño
     * específico
     */
    public Figura(Color color, int baseX, int baseY, int ancho, int alto, EnumFigure figureType) {
        this.posicion = Posicion.ARRIBA;
        this.color = color;
        this.baseX = baseX;
        this.baseY = baseY;
        this.ancho = ancho;
        this.alto = alto;
        this.figureType = figureType;
    }

    @Override
    public void paintElement(Graphics g) {
        g.setColor(this.color);
        for (Cuadro cuadro : this.getCuadros()) {
            g.fill3DRect(cuadro.getX(), cuadro.getY(), ancho, alto, true);
        }
    }

    public void addCuadro(int i, int j) {
        this.cuadros.add(new Cuadro(this.getColor(), this.getAncho(), this.getAlto()).setUbicacion(i, j, baseX, baseY));
    }

    public void addCuadro(Cuadro cuadro) {
        cuadros.add(cuadro);
    }

    public LinkedList<Cuadro> getCuadros() {
        return cuadros;
    }

    public void setCuadros(LinkedList<Cuadro> cuadros) {
        this.cuadros = cuadros;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion position) {
        this.posicion = position;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getBaseX() {
        return baseX;
    }

    public void setBaseX(int baseX) {
        this.baseX = baseX;
    }

    public int getBaseY() {
        return baseY;
    }

    public void setBaseY(int baseY) {
        this.baseY = baseY;
    }

    public EnumFigure getFigureType() {
        return figureType;
    }

    public void setFigureType(EnumFigure figureType) {
        this.figureType = figureType;
    }

    public abstract LinkedList<Cuadro> rotarElemento(Cuadro[][] board);

    public abstract void setUbicacionCuadro(int indexI, int indexJ);

    public abstract void setNextPosicion();
}
