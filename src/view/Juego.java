/**
 * Autor: Nancy Obed Martínez Miguel
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 20 de diciembre de 2022
 * Descripción: En este frame se cargará el juego funcional,
 *              con opciones básicas de interacción con el
 *              usuario mediante botones.
 */
package view;

import form.AdministradorDeJuego;
//import java.awt.Toolkit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import utils.Constantes;

public class Juego extends JFrame implements Runnable, KeyListener {

    private static final long serialVersionUID = 1L;
    private AdministradorDeJuego juego;
    private boolean decorate = true;

    /**
     * Tiempo de respuesta visual, intervalos en los que la imagen irá
     * caombiando de posición
     */
    private final double FramesPorSegundo = 60D;
    private final double ActualizacionesPorSegundo = 60D;

    // nanoseconds
    private final double tiempoFps = 1000000000 / FramesPorSegundo;
    private final double tiempoAps = 1000000000 / ActualizacionesPorSegundo;

    private double deltaFps = 0, deltaUps = 0;

    private long tiempoInicial = System.nanoTime();

    private boolean typeRight = false;
    private boolean typeLeft = false;
    //private Constantes constantes= new Constantes();

    public Juego() {
        initComponents();
        // #1: crea una instancia del juego
        this.juego = new AdministradorDeJuego();
        //this.addKeyListener(this);
        
        // #2: Define la ventana
//        this.setUndecorated(decorate);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.pack();
        //this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setSize(640, 640);
        this.getContentPane().add(juego);
        //this.add(juego);
        this.juego.setVisible(true);
        this.juego.setBounds(100, 0, Constantes.ANCHO_DE_PANTALLA, Constantes.ALTO_DE_PANTALLA);
        // #3: agraga escuchas 
        this.addKeyListener(this);
        this.setFocusable(true);
        
        new Thread(this).start();
       

    }

    @Override
    public void run() {
        while (true) {

            long currentTime = System.nanoTime();

            this.deltaFps += (currentTime - this.tiempoInicial) / this.tiempoFps;
            this.deltaUps += (currentTime - this.tiempoInicial) / this.tiempoAps;

            this.tiempoInicial = currentTime;

            // Updates per second
            if (this.deltaUps >= 1) {
                if (typeLeft) {
                    juego.moveLeft();
                }

                if (typeRight) {
                    juego.moveRight();
                }

                this.juego.tick();
                this.deltaUps = 0;
            }

            // Frames per second
            if (this.deltaFps >= 1) {
                this.juego.repaintGame();

                this.deltaFps = 0;
            }
            
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode()
                == KeyEvent.VK_A) {
            typeLeft = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode()
                == KeyEvent.VK_D) {
            typeRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode()
                == KeyEvent.VK_A) {
            typeLeft = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode()
                == KeyEvent.VK_D) {
            typeRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.juego.rotate();
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            this.juego.pauseOrResumeGame();
        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            this.juego.resetGame();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnArriba = new javax.swing.JButton();
        btnIzquierda = new javax.swing.JButton();
        btnDerecha = new javax.swing.JButton();
        btnAbajo = new javax.swing.JButton();
        cajaPuntos = new javax.swing.JTextField();
        labelPuntos = new javax.swing.JLabel();
        labelNivel = new javax.swing.JLabel();
        cajaNivel = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        fondoJuego = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        btnArriba.setIcon(new javax.swing.ImageIcon("resourses/images/arriba.png"));
        btnArriba.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnArriba.setBorderPainted(false);
        getContentPane().add(btnArriba);
        btnArriba.setBounds(480, 260, 90, 20);

        btnIzquierda.setIcon(new javax.swing.ImageIcon("resourses/images/izquierda.png"));
        btnIzquierda.setBorderPainted(false);
        getContentPane().add(btnIzquierda);
        btnIzquierda.setBounds(480, 140, 90, 20);

        btnDerecha.setIcon(new javax.swing.ImageIcon("resourses/images/derecha.png"));
        btnDerecha.setBorderPainted(false);
        getContentPane().add(btnDerecha);
        btnDerecha.setBounds(480, 200, 90, 20);

        btnAbajo.setIcon(new javax.swing.ImageIcon("resourses/images/abajo.png"));
        btnAbajo.setBorderPainted(false);
        getContentPane().add(btnAbajo);
        btnAbajo.setBounds(480, 320, 90, 20);

        cajaPuntos.setEnabled(false);
        cajaPuntos.setFocusable(false);
        getContentPane().add(cajaPuntos);
        cajaPuntos.setBounds(20, 140, 80, 24);

        labelPuntos.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        labelPuntos.setForeground(new java.awt.Color(0, 204, 51));
        labelPuntos.setText("Puntos");
        getContentPane().add(labelPuntos);
        labelPuntos.setBounds(30, 100, 50, 18);

        labelNivel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        labelNivel.setForeground(new java.awt.Color(0, 204, 51));
        labelNivel.setText("Nivel");
        getContentPane().add(labelNivel);
        labelNivel.setBounds(30, 190, 37, 18);

        cajaNivel.setEnabled(false);
        cajaNivel.setFocusable(false);
        getContentPane().add(cajaNivel);
        cajaNivel.setBounds(24, 230, 80, 24);

        btnSalir.setIcon(new javax.swing.ImageIcon("resourses/images/salir_1.png"));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(480, 400, 72, 24);

        fondoJuego.setIcon(new javax.swing.ImageIcon(""
            + "resourses/images/fondoJuego.jpg"));
    getContentPane().add(fondoJuego);
    fondoJuego.setBounds(0, 0, 640, 640);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        PantallaJuego pantallajuego = new PantallaJuego();
        pantallajuego.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbajo;
    private javax.swing.JButton btnArriba;
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField cajaNivel;
    private javax.swing.JTextField cajaPuntos;
    private javax.swing.JLabel fondoJuego;
    private javax.swing.JLabel labelNivel;
    private javax.swing.JLabel labelPuntos;
    // End of variables declaration//GEN-END:variables
}
