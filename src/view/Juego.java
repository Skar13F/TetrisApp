/**
 * Autor: Nancy Obed Martínez y Oscar Fuentes Alvarado
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización:  20 de enero de 2023
 * Descripción: En este frame se cargará el juego funcional,
 *              con opciones básicas de interacción con el
 *              usuario mediante botones.
 */
package view;

import com.sun.jdi.connect.spi.Connection;
import form.AdministradorDeJuego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import reporte.Conexion;
import utils.Constantes;

public class Juego extends JFrame implements Runnable, KeyListener {
    /**
     * Creamos una instancia de la clase administrador donde se cargará el juego
     */
    private AdministradorDeJuego juego;

    /**
     * Tiempo de respuesta visual, intervalos en los que la imagen irá
     * cambiando de posición
     */
    private final double FramesPorSegundo = 60D;
    private final double ActualizacionesPorSegundo = 60D;

    /**
     * El tiempo que se manejará es de nanosegundos, 
     */
    private final double tiempoFps = 1000000000 / FramesPorSegundo;
    private final double tiempoAps = 1000000000 / ActualizacionesPorSegundo;

    private double deltaFps = 0;
    private double deltaUps = 0;

    private long tiempoInicial = System.nanoTime();

    private boolean typeRight = false;
    private boolean typeLeft = false;
    
    private ImageIcon pause;
    private ImageIcon play;

    private Connection conection;
    private Conexion conexion;
    
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

            long tiempoActual = System.nanoTime();

            this.deltaFps += (tiempoActual - this.tiempoInicial) / this.tiempoFps;
            this.deltaUps += (tiempoActual - this.tiempoInicial) / this.tiempoAps;

            this.tiempoInicial = tiempoActual;

            /**
             * Actualizaciones por segundo
             */
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

            /**
             * Frames por segundo
             */
            if (this.deltaFps >= 1) {
                this.juego.repaintGame();

                this.deltaFps = 0;
            }

        }

    }

    /**
     * Método abstracto, no se utiliza
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Método que valida el teclado presionado para mover la figura en juego,
     * esta puede ser A o flecha izquierda (para mover la figura a la izquierda)
     * y D o flecha derecha (para mover la figura a la derecha)
     */
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

    /**
     * Método para setear a falso despues de haber presionado una tecla para 
     * mover la imagen y que no se vaya la figura en una misma dirección
     */
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
        btnSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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

        jButton2.setText("Reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 190, 82, 24);

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
        this.setVisible(false);
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            conexion = new Conexion();
            String path="/home/labingsw03/NetBeansProjects/TetrisApp/src/reportes/report1.jasper";
            //String path="/home/oscar/NetBeansProjects/appReportes/src/main/java/unsis/app/reportes/appreportes/report2.jasper";
            
            JasperReport jr=null;
            jr=(JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp=JasperFillManager.fillReport(jr,null,conexion.getConnection());
            JasperViewer jv= new JasperViewer(jp);
            jv.setVisible(true);
            jv.setTitle(path);
            conexion.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed
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
    private javax.swing.JLabel fondoJuego;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
