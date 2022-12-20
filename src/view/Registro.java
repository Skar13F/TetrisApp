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

public class Registro extends JFrame implements ActionListener {

    /**
     * Definición de las variables
     */
    private JPanel pPrincipal;
    private ImageIcon iFondo;
    private ImageIcon iDimAux;

    private JLabel lFondo;

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

    public Registro() {
        final int tamanioY = 30;

        /**
         * Carga de imagen para el fondo
         */
        iFondo = new ImageIcon("resourses/images/fondoL1.png");

        /**
         * Creación de la fuente de texto
         */
        fontMedia = new Font("LuzSans-Book", Font.PLAIN, 15);

        /**
         * Creación de borde para los cuadros de texto
         */
        bInferiorAzul = BorderFactory.createMatteBorder(0, 0, 2,
                0, Color.BLUE);

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
                80, Color.BLUE, Color.WHITE,
                Color.gray, bInferiorAzul);
        pPrincipal.add(tNombreUsuario);
        cajaTexto(tNombreUsuario, "Nombre");

        tEdad = crearCuadroTexto("Edad",
                tamJtexts, tamanioY, obtenerPosicionX(tamJtexts),
                (tNombreUsuario.getY() + tamanioY + 20), Color.BLUE,
                Color.WHITE, Color.gray, bInferiorAzul);
        pPrincipal.add(tEdad);
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
                cbSexo.getY() + tamanioY + 20, Color.BLUE,
                Color.WHITE, Color.gray, bInferiorAzul);
        pPrincipal.add(tTelefono);
        cajaTexto(tTelefono, "Teléfono");

        tCorreo = crearCuadroTexto("Correo",
                tamJtexts, tamanioY, obtenerPosicionX(tamJtexts),
                tTelefono.getY() + tamanioY + 20, Color.BLUE,
                Color.WHITE, Color.gray, bInferiorAzul);
        pPrincipal.add(tCorreo);
        cajaTexto(tCorreo, "Correo");

        tNombreJugador = crearCuadroTexto("Nombre Usuario",
                tamJtexts, tamanioY, obtenerPosicionX(tamJtexts),
                tCorreo.getY() + tamanioY + 20, Color.BLUE,
                Color.WHITE, Color.gray, bInferiorAzul);
        pPrincipal.add(tNombreJugador);
        cajaTexto(tNombreJugador, "Nombre Usuario");

        jContrasenia = new JPasswordField();
        jContrasenia.setText("////////");
        jContrasenia.setSize(tamJtexts, tamanioY);
        jContrasenia.setLocation(obtenerPosicionX(tamJtexts),
                tNombreJugador.getY() + tamanioY + 20);
        jContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
        jContrasenia.setForeground(Color.BLACK);
        jContrasenia.setBackground(Color.WHITE);
        jContrasenia.setCaretColor(Color.GRAY);
        jContrasenia.setFont(fontMedia);
        jContrasenia.setBorder(bInferiorAzul);
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
                UsuarioController controller = new UsuarioController();

                Usuario user = controller.buscarRegistoNombre(
                        tNombreJugador.getText());
                /**
                 * Primero validamos que el usuario no exista en la base de
                 * datos para poderlo registrar, de lo contrario enviar un aviso
                 * al usuario que esos datos ya existen en la BD
                 */
                if (user == null) {
                    JugadorController jugadorController
                            = new JugadorController();
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
                        userAux.setId_rol(-1);
                        int idJugador = jugadorA.getId_jugador();
                        userAux.setId_jugador(idJugador);
                        controller.crearActualizarUsuario(userAux);

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
                //bRegistrar.setBorder(bInferiorAzul);
            }

        }
        );

        this.bRegresar = new JButton("Regresar");//botón ingresar

        this.bRegresar.setBounds(
                350, 10, 80, 30);

        this.bRegresar.setForeground(Color.WHITE);

        this.bRegresar.addActionListener(
                this);

        this.bRegresar.setLocation(pPrincipal.getX() + 10,
                pPrincipal.getHeight() - 50);

        this.pPrincipal.add(
                this.bRegresar);

        this.bRegresar.setFocusable(
                false);

        this.bRegresar.setBorder(
                null);

        this.bRegresar.setContentAreaFilled(
                false);

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

        iDimAux = new ImageIcon(iFondo.getImage().getScaledInstance(
                pPrincipal.getWidth(), pPrincipal.getHeight(),
                Image.SCALE_AREA_AVERAGING));
        lFondo = new JLabel();

        lFondo.setBounds(
                0, 0, pPrincipal.getWidth(),
                pPrincipal.getHeight());
        lFondo.setIcon(iDimAux);

        pPrincipal.add(lFondo);

        //configurar el jframe
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(
                600, 500);

        this.setLocationRelativeTo(
                this);

        this.setLayout(
                null);

        this.setUndecorated(
                true);

        this.setVisible(
                true);
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
     * Método para crear un jtext con características que se especifiquen, 
     * estas se reciben como parámetros y al final la retorna
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
     * Este método ayuda a generar números aleatorios que se ocupan
     * para las posiciones en x de un componente de acuerdo al tamaño del mismo
     * y al tamaño del panel al que se agragará
     */
    public int obtenerPosicionX(int tamanio) {
        return (pPrincipal.getWidth() - tamanio) / 2;
    }

    /**
     * Método para hacer validaciones en los cuadros de texto, cuando el
     * cursor esté en el cuadro de texto, este se habilitará para 
     * escritura ocultando su previo contenido solo si estaba predefinido
     * si ya ha sido alterado permanecerá la modificación, de la misma manera
     * al perder el foco se enviará un texto predefinido si no hubo modificación
     * en el, de lo contrario permanecerá
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
     * Método para enviar mostrar u ocultar un texto predeterminado en el 
     * cuadro para la contraseña, si el usuario ingresa datos estos permanecerán
     * de lo contrrario se volverá a un estado predeterminado
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
}
