/**
 * Autor: Oscar Fuentes Alvarado y Nancy Obed Martínez Miguel
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 26 de enero del 2023
 * Descripción: En esta clase de codifica desde cero lo que es un frame para
 *              mostrar un formulario, donde se registran las personas nuevas
 *              en el juego.
 *
 */
package view;

import controller.JugadorController;
import controller.UsuarioController;
import entity.Jugador;
import entity.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Registro extends JFrame implements ActionListener,
        KeyListener {

    /**
     * Definición de las variables
     */
    private JPanel pPrincipal;
    private ImageIcon iFondo;
    private ImageIcon iDimAux;
    private ImageIcon iNombre;
    private ImageIcon iEdad;
    private ImageIcon iTelefono;
    private ImageIcon iCorreo;
    private ImageIcon iContrasena;
    private ImageIcon iUsuario;
    private JLabel lUsuario;
    private JLabel lContraseña;
    private JLabel lCorreo;
    private JLabel lTelefono;
    private JLabel lEdad;
    private JLabel lFondo;
    private JLabel lNombre;

    private JTextField tNombreUsuario;
    private JTextField tEdad;
    private JTextField tTelefono;
    private JTextField tCorreo;
    private JTextField tNombreJugador;

    private JPasswordField jContrasenia;

    private JComboBox cbSexo;

    private JButton bRegresar;
    private JButton bRegistrar;

    private Font fontMedia;

    private Border bInferiorAzul;

    private final int tamJtexts = 200;

    /**
     * Controllers
     */
    UsuarioController usuarioController;
    JugadorController jugadorController;

    public Registro() {
        final int tamanioY = 30;
        usuarioController = new UsuarioController();
        jugadorController = new JugadorController();
        usuarioController.init();
        jugadorController.init();
        /**
         * Carga de imagen para el fondo
         */
        iFondo = new ImageIcon("resourses/images/fondoL1.jpg");
        iNombre = new ImageIcon("resourses/images/nombre3.png");
        iCorreo = new ImageIcon("resourses/images/correo.png");
        iEdad = new ImageIcon("resourses/images/edad1.png");
        iTelefono = new ImageIcon("resourses/images/telefono.png");
        iContrasena = new ImageIcon("resourses/images/candado.png");
        iUsuario = new ImageIcon("resourses/images/usuario2.png");

        /**
         * Creación de la fuente de texto
         */
        fontMedia = new Font("LuzSans-Book", Font.BOLD, 15);

        /**
         * Creación de borde para los cuadros de texto
         */
        bInferiorAzul = BorderFactory.createMatteBorder(0, 0, 2,
                0, Color.white);

        /**
         * Configuración del panel de registro
         */
        pPrincipal = new JPanel();
        pPrincipal.setSize(600, 500);
        pPrincipal.setLocation(0, 0);
        pPrincipal.setBackground(Color.BLACK);
        pPrincipal.setLayout(null);
        this.add(pPrincipal);

        /**
         * Creación y edición de los cuadros de texto
         */
        tNombreUsuario = crearCuadroTexto("Nombre",
                tamJtexts, tamanioY, obtenerPosicionX(tamJtexts),
                80, Color.white, Color.black,
                Color.gray, bInferiorAzul);
        pPrincipal.add(tNombreUsuario);
        tNombreUsuario.setOpaque(false);
        cajaTexto(tNombreUsuario, "Nombre");

        tEdad = crearCuadroTexto("Edad",
                tamJtexts, tamanioY, obtenerPosicionX(tamJtexts),
                (tNombreUsuario.getY() + tamanioY + 20), Color.white,
                Color.WHITE, Color.gray, bInferiorAzul);
        pPrincipal.add(tEdad);
        tEdad.setOpaque(false);
        cajaTexto(tEdad, "Edad");

        cbSexo = new JComboBox();
        cbSexo.addItem("Hombre");
        cbSexo.addItem("Mujer");
        cbSexo.setSize(tamJtexts, tamanioY);
        cbSexo.setLocation(obtenerPosicionX(tamJtexts), tEdad.getY()
                + tamanioY + 20);
        cbSexo.setBackground(Color.WHITE);
        cbSexo.setForeground(Color.BLACK);

        ((JLabel) cbSexo.getRenderer()).setHorizontalAlignment(
                SwingConstants.CENTER);
        pPrincipal.add(cbSexo);

        tTelefono = crearCuadroTexto("Teléfono",
                tamJtexts, tamanioY, obtenerPosicionX(tamJtexts),
                cbSexo.getY() + tamanioY + 20, Color.white,
                Color.WHITE, Color.gray, bInferiorAzul);
        pPrincipal.add(tTelefono);
        tTelefono.setOpaque(false);
        cajaTexto(tTelefono, "Teléfono");

        tCorreo = crearCuadroTexto("Correo",
                tamJtexts, tamanioY, obtenerPosicionX(tamJtexts),
                tTelefono.getY() + tamanioY + 20, Color.white,
                Color.WHITE, Color.gray, bInferiorAzul);
        pPrincipal.add(tCorreo);
        tCorreo.setOpaque(false);
        cajaTexto(tCorreo, "Correo");

        tNombreJugador = crearCuadroTexto("Nombre Usuario",
                tamJtexts, tamanioY, obtenerPosicionX(tamJtexts),
                tCorreo.getY() + tamanioY + 20, Color.white,
                Color.WHITE, Color.gray, bInferiorAzul);
        pPrincipal.add(tNombreJugador);
        tNombreJugador.setOpaque(false);
        cajaTexto(tNombreJugador, "Nombre Usuario");

        jContrasenia = new JPasswordField();
        jContrasenia.setText("////////");
        jContrasenia.setSize(tamJtexts, tamanioY);
        jContrasenia.setLocation(obtenerPosicionX(tamJtexts),
                tNombreJugador.getY() + tamanioY + 20);
        jContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
        jContrasenia.setForeground(Color.WHITE);
        jContrasenia.setBackground(Color.WHITE);
        jContrasenia.setCaretColor(Color.GRAY);
        jContrasenia.setFont(fontMedia);
        jContrasenia.setBorder(bInferiorAzul);
        jContrasenia.setOpaque(false);
        pPrincipal.add(jContrasenia);
        cajaContrasenia(jContrasenia, "////////");

        /**
         * creación y configuración de los botones
         */
        this.bRegistrar = new JButton("Registrar");

        this.bRegistrar.setBounds(
                350, 10, 80, 30);

        this.bRegistrar.setForeground(Color.WHITE);

        this.bRegistrar.addActionListener(
                this);

        this.bRegistrar.setLocation(
                (pPrincipal.getWidth() - bRegistrar.getWidth()) / 2,
                pPrincipal.getHeight() - 65);

        this.pPrincipal.add(
                this.bRegistrar);

        this.bRegistrar.setFocusable(
                false);

        this.bRegistrar.setBorder(
                null);

        this.bRegistrar.setContentAreaFilled(
                false);

        /**
         * Evento en el botón registrar, cuando el cursor entra, sale y si el
         * usuario da click sobre el
         */
        bRegistrar.addMouseListener(
                new MouseAdapter() {
            /**
             * cuando el mouse entre en el área del botón se mostrará el área
             * del botón de un color diferente
             */
            @Override
            public void mouseEntered(MouseEvent e
            ) {
                bRegistrar.setBackground(Color.LIGHT_GRAY);
                bRegistrar.setContentAreaFilled(true);
            }

            /**
             * cuando el mouse salga del área del botón se activará un nuevo
             * evento que dejará de mostrar el área del botón y este pasara a
             * ser invisible
             */
            @Override
            public void mouseExited(MouseEvent e
            ) {
                bRegistrar.setContentAreaFilled(false);
                bRegistrar.setBorder(null);
            }

            /**
             * Evento de click sobre el botón, primero declaramos e
             * inicializamos un objeto de tipo controller para las llamadas a
             * funcion del objeto usuario
             */
            @Override
            public void mouseClicked(MouseEvent e
            ) {

                Usuario user = usuarioController.buscarRegistoNombre(
                        tNombreJugador.getText());

                /**
                 * Primero validamos que el usuario no exista en la base de
                 * datos para poderlo registrar, de lo contrario enviar un aviso
                 * al usuario que esos datos ya existen en la BD
                 */
                if (user == null) {

                    Jugador jugadorAux = new Jugador();
                    jugadorAux.setNombre(tNombreUsuario.getText());
                    jugadorAux.setEdad(Integer.valueOf(tEdad.getText()));
                    jugadorAux.setSexo(cbSexo.getSelectedItem().toString());
                    jugadorAux.setTelefono(tTelefono.getText());
                    jugadorAux.setCorreo(tCorreo.getText());
                    Jugador jugadorA = jugadorController.buscarRegistroTelefono(
                            jugadorAux.getTelefono());
                    /**
                     * Enseguida verificamos que el jugador al cual se le quiere
                     * asignar el usuario exista, si no, lo registramos y
                     * enviamos la vista a la plantilla de logueo nuevamente
                     */
                    if (jugadorA == null) {
                        jugadorController.crearRegistro(jugadorAux);
                        String telefono = jugadorAux.getTelefono();
                        jugadorA
                                = jugadorController.buscarRegistroTelefono(
                                        telefono);

                        Usuario userAux = new Usuario();
                        userAux.setNombre(tNombreJugador.getText());
                        userAux.setPassword(String.valueOf(
                                jContrasenia.getPassword()));
                        userAux.setId_rol(1);
                        int idJugador = jugadorA.getId_jugador();
                        userAux.setId_jugador(idJugador);
                        usuarioController.crearActualizarUsuario(userAux);

                        //creamos un registro en la tabla id_usuario_rol
                        PlantillaLogueo plantillaLogueo = new PlantillaLogueo();
                        plantillaLogueo.setVisible(true);

                        cerrarFrame();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "El jugador ya existe/n intenta de nuevo"
                                + "");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El "
                            + "usuario ya existe/n intenta de nuevo");
                }

            }

        }
        );
        /**
         * Se agrega y se da formato al botón Regresar
         */
        this.bRegresar = new JButton("Regresar");
        this.bRegresar.setBounds(
                350, 10, 80, 30);
        this.bRegresar.setForeground(Color.WHITE);
        this.bRegresar.addActionListener(this);
        this.bRegresar.setLocation(pPrincipal.getX() + 10,
                pPrincipal.getHeight() - 50);
        this.pPrincipal.add(this.bRegresar);
        this.bRegresar.setFocusable(false);
        this.bRegresar.setBorder(null);
        this.bRegresar.setContentAreaFilled(false);

        /**
         * Tenemos eventos para el mouse, cuando ingresa o sale del área del
         * botón, y cuando hace click sobre este, lo regresa a la pantalla de
         * logueo
         */
        bRegresar.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e
            ) {
                bRegresar.setBackground(Color.LIGHT_GRAY);
                bRegresar.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e
            ) {
                bRegresar.setContentAreaFilled(false);
                bRegresar.setBorder(null);
            }

            @Override
            public void mouseClicked(MouseEvent e
            ) {
                PlantillaLogueo logueo = new PlantillaLogueo();
                cerrarFrame();
            }

        }
        );
        /**
         * En este bloque de código se pone una imagen para el fondo
         */
        iDimAux = new ImageIcon(iFondo.getImage().getScaledInstance(
                pPrincipal.getWidth(), pPrincipal.getHeight(),
                Image.SCALE_AREA_AVERAGING));
        lFondo = new JLabel();

        lFondo.setBounds(
                0, 0, pPrincipal.getWidth(),
                pPrincipal.getHeight());
        lFondo.setIcon(iDimAux);
        pPrincipal.add(lFondo);
        /**
         * Se agrega una imagen para ícono de la caja nombre del formulario
         */
        iDimAux = new ImageIcon(
                iNombre.getImage()
                        .getScaledInstance(30, 30,
                                Image.SCALE_AREA_AVERAGING)
        );

        lNombre = new JLabel();
        lNombre.setBounds(0, 0, 30, 28);
        lNombre.setLocation(0, 0);
        lNombre.setIcon(iDimAux);
        lNombre.setVisible(true);
        tNombreUsuario.add(lNombre);
        /**
         * Se agrega una imagen para ícono de la caja edad del formulario
         */

        iDimAux = new ImageIcon(
                iEdad.getImage()
                        .getScaledInstance(30, 30,
                                Image.SCALE_AREA_AVERAGING)
        );

        lEdad = new JLabel();
        lEdad.setBounds(0, 0, 30, 28);
        lEdad.setLocation(0, 0);
        lEdad.setIcon(iDimAux);
        lEdad.setVisible(true);
        tEdad.add(lEdad);
        /**
         * Se agrega una imagen para ícono de la caja télefono del formulario
         */
        iDimAux = new ImageIcon(
                iTelefono.getImage()
                        .getScaledInstance(30, 30,
                                Image.SCALE_AREA_AVERAGING)
        );

        lTelefono = new JLabel();
        lTelefono.setBounds(0, 0, 30, 28);
        lTelefono.setLocation(0, 0);
        lTelefono.setIcon(iDimAux);
        lTelefono.setVisible(true);
        tTelefono.add(lTelefono);
        /**
         * Se agrega una imagen para ícono de la caja correo del formulario
         */
        iDimAux = new ImageIcon(
                iCorreo.getImage()
                        .getScaledInstance(30, 30,
                                Image.SCALE_AREA_AVERAGING)
        );

        lCorreo = new JLabel();
        lCorreo.setBounds(0, 0, 30, 28);
        lCorreo.setLocation(0, 0);
        lCorreo.setIcon(iDimAux);
        lCorreo.setVisible(true);
        tCorreo.add(lCorreo);
        /**
         * Se agrega una imagen para ícono de la caja nombre usuario del
         * formulario
         */
        iDimAux = new ImageIcon(
                iUsuario.getImage()
                        .getScaledInstance(30, 30,
                                Image.SCALE_AREA_AVERAGING)
        );

        lUsuario = new JLabel();
        lUsuario.setBounds(0, 0, 30, 30);
        lUsuario.setLocation(0, 0);
        lUsuario.setIcon(iDimAux);
        lUsuario.setVisible(true);
        tNombreJugador.add(lUsuario);
        /**
         * Se agrega una imagen para ícono de la caja contraseña del formulario
         */
        iDimAux = new ImageIcon(
                iContrasena.getImage()
                        .getScaledInstance(30, 30,
                                Image.SCALE_AREA_AVERAGING)
        );

        lContraseña = new JLabel();
        lContraseña.setBounds(0, 0, 30, 28);
        lContraseña.setLocation(0, 0);
        lContraseña.setIcon(iDimAux);
        lContraseña.setVisible(true);
        jContrasenia.add(lContraseña);

        /**
         * Configuración del jframe
         */
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocationRelativeTo(this);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setVisible(true);

        /**
         * Agregamos escucha del teclado
         */
        this.addKeyListener(this);
        this.setFocusable(true);

        /**
         * Método para validar el tamaño y tipo de texto dentro del cuadro de
         * texto nombre la logica de programación es confusa donde valida el
         * la entrada del espacio
         */
        this.tNombreUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (tNombreUsuario.getText().length() >= 20) {
                    e.consume();
                } else {
                    char letra = e.getKeyChar();
                    if (!Character.isAlphabetic(letra)
                            && (e.getKeyCode() == KeyEvent.VK_SPACE)) {
                        e.consume();
                    }
                }
            }

        });

        /**
         * Método para validar el tamaño y tipo de texto dentro del cuadro de
         * texto edad
         */
        this.tEdad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char letra = e.getKeyChar();
                char cero = '0';
                if (tEdad.getText().length() >= 2) {
                    e.consume();

                } else if (Character.compare(letra, cero) == 0
                        && tEdad.getText().length() == 0) {
                    e.consume();
                } else {
                    if (!Character.isDigit(letra)) {
                        e.consume();
                    }
                }
            }

        });

        /**
         * Método para validar el tamaño y tipo de texto dentro del cuadro de
         * texto teléfono
         */
        this.tTelefono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (tTelefono.getText().length() >= 10) {
                    e.consume();
                } else {
                    char letra = e.getKeyChar();
                    if (!Character.isDigit(letra)) {
                        e.consume();
                    }
                }
            }

        });

        /**
         * Método para validar el tamaño y tipo de texto dentro del cuadro de
         * texto correo
         */
        this.tCorreo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (tCorreo.getText().length() >= 15) {
                    e.consume();
                } else {
                    char letra = e.getKeyChar();
                    if (!Character.isAlphabetic(letra)
                            && !Character.isDigit(letra)) {
                        e.consume();
                    }
                }
            }

        });

        /**
         * Método para validar el tamaño y tipo de texto dentro del cuadro de
         * texto nombre del jugador
         */
        this.tNombreJugador.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (tNombreJugador.getText().length() >= 15) {
                    e.consume();
                } else {
                    char letra = e.getKeyChar();
                    if (!Character.isAlphabetic(letra)
                            && !Character.isDigit(letra)) {
                        e.consume();
                    }
                }
            }

        });

        /**
         * Método para validar el tamaño y tipo de texto dentro de un jPassword
         */
        this.jContrasenia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jContrasenia.getPassword().length >= 15) {
                    e.consume();
                }
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Método para cerrar el ocultar el frame que se está ejecutando
     */
    public void cerrarFrame() {
        this.setVisible(false);
    }

    /**
     * Método para crear un jtext con características que se especifiquen, estas
     * se reciben como parámetros y al final la retorna
     */
    public JTextField crearCuadroTexto(String nombre, int tX,
            int tY, int pX, int pY, Color TextC, Color fondoC, Color cursorC,
            Border bordeI) {
        JTextField jGenerica = new JTextField(nombre);
        jGenerica.setSize(tX, tY);
        jGenerica.setLocation(pX, pY);
        jGenerica.setHorizontalAlignment(SwingConstants.CENTER);
        jGenerica.setForeground(TextC);
        jGenerica.setBackground(fondoC);
        jGenerica.setCaretColor(cursorC);
        jGenerica.setFont(fontMedia);
        jGenerica.setBorder(bordeI);
        return jGenerica;
    }

    /**
     * Este método ayuda a generar números aleatorios que se ocupan para las
     * posiciones en x de un componente de acuerdo al tamaño del mismo y al
     * tamaño del panel al que se agragará
     */
    public int obtenerPosicionX(int tamanio) {
        return (pPrincipal.getWidth() - tamanio) / 2;
    }

    /**
     * Método para hacer validaciones en los cuadros de texto, cuando el cursor
     * esté en el cuadro de texto, este se habilitará para escritura ocultando
     * su previo contenido solo si estaba predefinido si ya ha sido alterado
     * permanecerá la modificación, de la misma manera al perder el foco se
     * enviará un texto predefinido si no hubo modificación en el, de lo
     * contrario permanecerá
     */
    public void cajaTexto(JTextField jTexto, String contenido) {
        jTexto.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTexto.hasFocus() && jTexto.getText().equals(
                        contenido)) {
                    jTexto.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTexto.getText().equals("")) {
                    jTexto.setText(contenido);
                }
            }

        });
    }

    /**
     * Método para enviar mostrar u ocultar un texto predeterminado en el cuadro
     * para la contraseña, si el usuario ingresa datos estos permanecerán de lo
     * contrrario se volverá a un estado predeterminado
     */
    public void cajaContrasenia(JPasswordField jContrasenia, String contenido) {
        jContrasenia.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jContrasenia.hasFocus() && String.valueOf(
                        jContrasenia.getPassword()).equals(
                        contenido)) {
                    jContrasenia.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(jContrasenia.getPassword()).equals(
                        "")) {
                    jContrasenia.setText(contenido);
                }
            }

        });
    }

    /**
     * Métodos para captar los eventos del teclado en el sistema
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
