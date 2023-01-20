package components;

import utils.Constantes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import enummanager.EnumFigure;
import figures.Figura;
import figures.Cuadro;
import figures.GeneradorDeCuadrados;
import segregation.Drawable;

public class TableroTetris implements Drawable {

    private Cuadro[][] tablero = new Cuadro[Constantes.COLUMNAS][Constantes.FILAS];
    /**
     * Vista actual y vista siguiente
     */
    private VerFigura vistaActual;
    private VerFigura vistaSiguiente;
    /**
     * Figura actual y figura siguiente
     */
    private Figura figuraActual;
    private Figura figuraSiguiente;
    
    private int baseX, baseY;
    /**
     * Velocidad del juego
     */
    private int velocidad = 450;
    private boolean isGameOver = false;
    private boolean isRotating = false;
    private boolean stop = false;
    private int puntos = 0;
    
    public TableroTetris() {
        this.baseX = Constantes.TABLERO_X;
        this.baseY = Constantes.TABLERO_Y;
        /**
         * Se crea la ubicación donde aparecerá la figuara en juego actual, y
         * la siguiente figura en salir al atablero
         * la figura siguiente aparecerá a la izquierda del tablero y la 
         * actual a la derecha de este
         */
        this.vistaSiguiente = new VerFigura(baseX+30, (baseY - Constantes.ALTO_VISTA_FIGURA) - 20);
        this.vistaActual = new VerFigura(baseX + Constantes.ANCHO_DE_PANTALLA - Constantes.ANCHO_VISTA_FIGURA,
                (baseY - Constantes.ALTO_VISTA_FIGURA) - 20);
        
        this.addNewFigure();
        
        
    }

    /**
     * Mediante este método agregamos las figuras en las vistas actual y 
     * siguiente
     */
    public void addNewFigure() {
        /**
         * Al iniciar el juego estarán vacías, por ende generaremos figuras 
         * para ambas vistas, despues, mediante esta validación, cambiamos
         * la figura siguiente a salir, a la actual y generamos una nueva 
         * figura para colocar en la vista siguiente
         */
        if (this.figuraSiguiente != null) {
            this.figuraActual = this.figuraSiguiente;
            this.figuraSiguiente = GeneradorDeCuadrados.getRegularFigure();
        } else {
            this.figuraActual = GeneradorDeCuadrados.getRegularFigure();
            this.figuraSiguiente = GeneradorDeCuadrados.getRegularFigure();
        }

        
        this.vistaActual.setFigura(GeneradorDeCuadrados.getFiguraVista(
                figuraActual.getFigureType(),
                vistaActual.getPosicionX(),
                vistaActual.getPosicionY(),
                Constantes.ANCHO_DE_CUADRO_DE_VISTA,
                Constantes.ALTO_DE_CUADRO_DE_VISTA)
        );

        this.vistaSiguiente.setFigura(GeneradorDeCuadrados.getFiguraVista(
                figuraSiguiente.getFigureType(),
                vistaSiguiente.getPosicionX(),
                vistaSiguiente.getPosicionY(),
                Constantes.ANCHO_DE_CUADRO_DE_VISTA,
                Constantes.ALTO_DE_CUADRO_DE_VISTA)
        );
        this.validateCurrentLocation();
    }

    private void validateCurrentLocation() {
        for (Cuadro square : this.figuraActual.getCuadros()) {
            if (this.tablero[square.getIndiceI()][square.getIndiceJ()] != null) {
                System.out.println("GAME OVER!!");
                this.isGameOver = true;
                break;
            }
        }
    }

    private void moveImageDown() {
        if (this.figuraActual == null || this.isGameOver) {
            return;
        }

        boolean merge = false;
        for (Cuadro square : this.figuraActual.getCuadros()) {
            if (square.getIndiceJ() >= Constantes.FILAS - 1) {
                merge = true;
                break;
            } else if (this.tablero[square.getIndiceI()][square.getIndiceJ() + 1] != null) {
                merge = true;
                break;
            }
        }

        if (!merge) {
            for (Cuadro square : this.figuraActual.getCuadros()) {
                square.setUbicacion(square.getIndiceI(), square.getIndiceJ() + 1, this.baseX, this.baseY);
            }
        } else {
            for (Cuadro square : this.figuraActual.getCuadros()) {
                this.tablero[square.getIndiceI()][square.getIndiceJ()] = square;
            }
            this.searchLines();
            this.addNewFigure();
        }
    }

    private void searchLines() {
        int countLines = 0;
        for (int j = Constantes.FILAS - 1; j > 0; j--) {
            for (int i = 0; i < Constantes.COLUMNAS; i++) {
                if (this.tablero[i][j] == null) {
                    break;
                }
                countLines++;
            }

            if (countLines == Constantes.COLUMNAS) {
                this.deleteLine(j);
                this.puntos += Constantes.COLUMNAS;
                // Since a line was deleted, then start in the same line
                j++;
            }
            countLines = 0;
        }
    }

    private void deleteLine(int j) {
        for (int i = 0; i < Constantes.COLUMNAS; i++) {
            this.tablero[i][j] = null;
        }

        for (; j > 1; j--) {
            for (int i = 0; i < Constantes.COLUMNAS; i++) {
                if (this.tablero[i][j - 1] != null) {
                    this.tablero[i][j] = this.tablero[i][j - 1];
                    this.tablero[i][j - 1] = null;
                    this.tablero[i][j].setUbicacion(i, j, this.baseX, this.baseY);
                }
            }
        }
    }

    public void moveRight() {
        if (this.figuraActual == null) {
            return;
        }

        for (Cuadro square : this.figuraActual.getCuadros()) {
            if (square.getIndiceI() + 1 >= Constantes.COLUMNAS) {
                return;
            } else if (this.tablero[square.getIndiceI() + 1][square.getIndiceJ()] != null) {
                return;
            }
        }

        for (Cuadro square : this.figuraActual.getCuadros()) {
            square.setUbicacion(square.getIndiceI() + 1, 
                    square.getIndiceJ(), 
                    this.baseX, this.baseY);
        }
    }

    public void moveLeft() {
        if (this.figuraActual == null) {
            return;
        }

        for (Cuadro square : this.figuraActual.getCuadros()) {
            if (square.getIndiceI() - 1 < 0) {
                return;
            } else if (this.tablero[square.getIndiceI() - 1][square.getIndiceJ()] != null) {
                return;
            }
        }

        for (Cuadro square : this.figuraActual.getCuadros()) {
            square.setUbicacion(square.getIndiceI() - 1, square.getIndiceJ(), this.baseX, this.baseY);
        }
    }

    public void setIsRotating(boolean isRotating) {
        this.isRotating = isRotating;

    }

    public boolean isRotating() {
        return this.isRotating;
    }

    public void rotateFigure() {

        if (this.figuraActual.getFigureType() == EnumFigure.O_CUADRO) {
            // Do not rotate in case is already rotating
            return;
        }

        this.isRotating = true;

        LinkedList<Cuadro> squares = figuraActual.rotarElemento(this.tablero);

        // Validate if the squares are outside the area
        int top = 0, right = 0, left = 0, down = 0, current = 0;
        for (Cuadro square : squares) {
            if (square.getIndiceI() < 0) {
                current = square.getIndiceI() * - 1;
                left = left < current ? current : left;
            }
            if (square.getIndiceI() > Constantes.COLUMNAS - 1) {
                current = square.getIndiceI() - (Constantes.COLUMNAS - 1);
                right = right < current ? current : right;
            }
            if (square.getIndiceJ() < 0) {
                current = square.getIndiceJ() * - 1;
                top = top < current ? current : top;
            }
            if (square.getIndiceJ() > Constantes.FILAS - 1) {
                current = square.getIndiceJ() - (Constantes.FILAS - 1);
                down = down < current ? current : down;
            }
        }

        // Increment or decrement depending of the distance outside for every side of the table
        for (Cuadro square : squares) {
            if (top > 0) {
                square.setIndiceJ(square.getIndiceJ() + top);
            }
            if (down > 0) {
                square.setIndiceJ(square.getIndiceJ() - down);
            }
            if (left > 0) {
                square.setIndiceI(square.getIndiceI() + left);
            }
            if (right > 0) {
                square.setIndiceI(square.getIndiceI() - right);
            }
            square.setUbicacion(this.baseX, this.baseY);
        }

        // If any of the squares is located inside a place that is not null, can�t be rotated
        for (Cuadro square : squares) {
            if (this.tablero[square.getIndiceI()][square.getIndiceJ()] != null) {
                this.isRotating = false;
                return;
            }
        }

        this.figuraActual.setCuadros(squares);
        this.figuraActual.setNextPosicion(); // Only enable rotation when everything is ok

        this.isRotating = false;
    }

    public void tick() {
        if (!isGameOver) {

            if (!isRotating) {
                moveImageDown();
            }

            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void paintElement(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, Constantes.SCREEN_WIDTH, 
                Constantes.SCREEN_WIDTH);
        this.vistaActual.paintElement(g);
        this.vistaSiguiente.paintElement(g);

        g.setColor(Color.black);
        g.fill3DRect(this.baseX, this.baseY, 
                Constantes.ANCHO_DE_PANTALLA, 
                Constantes.ALTO_DE_PANTALLA, false);
        for (int i = 0; i < Constantes.COLUMNAS; i++) {
            for (int j = 0; j < Constantes.FILAS; j++) {

                if (this.tablero[i][j] != null) {
                    Cuadro square = this.tablero[i][j];
                    g.setColor(square.getColor());
                    g.fill3DRect(square.getX(), 
                            square.getY(), 
                            Constantes.ANCHO_DE_CADA_CUADRITO, 
                            Constantes.ALTO_DE_CADA_CUADRITO, 
                            true);
                }
            }
        }

        this.figuraActual.paintElement(g);
        g.setColor(Color.BLACK);

        g.setFont(Constantes.FUENTE);
        g.drawString("Puntos: " + this.puntos,
                this.vistaSiguiente.getPosicionX()
                + Constantes.ANCHO_VISTA_FIGURA,
                this.vistaSiguiente.getPosicionY()
                + Constantes.TAMANIO_DE_FUENTE);
        g.setColor(Color.white);
    }

    public void pauseOrResume() {
        this.stop = !this.stop;
    }

    public boolean isStop() {
        return this.stop;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

}
