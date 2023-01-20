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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import utils.Constantes;

public class Juego extends JFrame implements Runnable, KeyListener {

    private static final long serialVersionUID = 1L;
    private AdministradorDeJuego juego;

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
    
    private ImageIcon pause;
    private ImageIcon play;

    public Juego() {
        initComponents();
        // #1: crea una instancia del juego
        this.juego = new AdministradorDeJuego();

        play=new ImageIcon("resourses/images/play.png");
        pause=new ImageIcon("resourses/images/pause.png");
        
        
        // #2: Define la ventana
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.pack();
        this.setBounds((Constantes.SCREEN_WIDTH - 685) / 2, (Constantes.SCREEN_HEIGHT - 700) / 2, 685, 740);
        this.getContentPane().add(juego);
        //this.add(juego);
        this.juego.setVisible(true);
        this.juego.setBounds(125, 20, Constantes.ANCHO_DE_VISTA,
                Constantes.ALTO_DE_VISTA);
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

        btnAbajo = new javax.swing.JButton();
        labelNivel = new javax.swing.JLabel();
        cajaNivel = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        fondoJuego = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        btnAbajo.setIcon(new javax.swing.ImageIcon("resourses/images/pause.png"));
        btnAbajo.setBorderPainted(false);
        btnAbajo.setContentAreaFilled(false);
        btnAbajo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbajoMouseClicked(evt);
            }
        });
        getContentPane().add(btnAbajo);
        btnAbajo.setBounds(580, 220, 60, 60);

        labelNivel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        labelNivel.setForeground(new java.awt.Color(0, 204, 51));
        labelNivel.setText("Nivel");
        getContentPane().add(labelNivel);
        labelNivel.setBounds(40, 190, 37, 18);

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
        btnSalir.setBounds(580, 300, 72, 24);

        jButton1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("resourses/images/reset.png"));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 280, 60, 60);

        fondoJuego.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        fondoJuego.setForeground(new java.awt.Color(255, 255, 255));
        fondoJuego.setIcon(new javax.swing.ImageIcon("resourses/images/FondoJuego2.jpg"));
        fondoJuego.setText("Reiniciar");
        getContentPane().add(fondoJuego);
        fondoJuego.setBounds(0, 0, 690, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        PantallaJuego pantallajuego = new PantallaJuego();
        pantallajuego.setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAbajoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbajoMouseClicked
        if(this.btnAbajo.getIcon()==this.play){
            this.juego.pauseOrResumeGame();
            this.btnAbajo.setIcon(pause);
        }else{
            this.juego.pauseOrResumeGame();
            this.btnAbajo.setIcon(play);
        }
        
        
    }//GEN-LAST:event_btnAbajoMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.juego.resetGame();
        this.btnAbajo.setIcon(pause);
    }//GEN-LAST:event_jButton1MouseClicked
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbajo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField cajaNivel;
    private javax.swing.JLabel fondoJuego;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelNivel;
    // End of variables declaration//GEN-END:variables
}
