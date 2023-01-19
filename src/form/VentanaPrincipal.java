package form;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import utils.Constantes;

/*
 * Esta ventana maneja clics, eventos del mouse, tiempos y otras configuraciones
   de ventanas.
 */
public class VentanaPrincipal extends JFrame implements Runnable, KeyListener {

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

    public VentanaPrincipal() {
        // #1: crea una instancia del juego
        
        this.juego = new AdministradorDeJuego();

        // #2: Define la ventana
        this.setUndecorated(decorate);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        this.pack();

        //this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setSize(Constantes.ANCHO_DE_VISTA, Constantes.ALTO_DE_VISTA);
        this.getContentPane().add(juego);

        // #3: agraga escuchas 
        this.addKeyListener(this);

        new Thread(this).start();
    }

    // Delta time: Tick
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
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            typeLeft = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            typeRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            typeLeft = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
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
}
