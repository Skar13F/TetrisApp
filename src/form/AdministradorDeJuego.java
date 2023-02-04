/**
 * Autor: Oscar Fuentes Alvarado y Nancy Obed Martínez Miguel
 * Fecha de creación: 04 de enero del 2023
 * Fecha de actualización:20 de enero del 2023
 * Descripcion : En la siguente clase se administra el juego
 */
package form;

import java.awt.Graphics;

import javax.swing.JPanel;

import components.TableroTetris;

public class AdministradorDeJuego extends JPanel {

    private static final long serialVersionUID = 1L;

    TableroTetris board = new TableroTetris();
    private int puntos;

    public AdministradorDeJuego() {
    }

    @Override
    public void paintComponent(Graphics g) {

        board.paintElement(g);
    }

    public void repaintGame() {
        if (isGameInPlay()) {
            this.repaint();
        }
    }

    public void moveRight() {
        if (isGameInPlay() && !this.board.isRotating()) {
            this.board.moveRight();
        }
    }

    public void moveLeft() {
        if (isGameInPlay()) {
            this.board.moveLeft();
        }
    }

    public void rotate() {
        if (isGameInPlay()) {
            this.board.rotateFigure();
        }

    }

    public void pauseOrResumeGame() {
        this.board.pauseOrResume();
    }

    public void resetGame() {
        this.board = new TableroTetris();
    }

    public void tick() {
        if (isGameInPlay()) {
            this.board.tick();
        }
    }

    public boolean isGameInPlay() {
        this.puntos=board.getPuntos();
        return !board.isGameOver() && !this.board.isStop();
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}
