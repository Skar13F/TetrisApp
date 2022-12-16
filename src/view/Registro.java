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

    private JPanel pPrincipal;
    private ImageIcon iFondo;
    private ImageIcon iDimAux;

    private JLabel lFondo;

    //solicitar datos
    private JTextField tNombreUsuario;
    private JTextField tEdad;
    private JTextField tTelefono;
    private JTextField tCorreo;

    private JTextField tNombreJugador;
    private JPasswordField jContrasenia;

    private JComboBox cbSexo;

    //botones
    private JButton bRegresar;
    private JButton bRegistrar;

    //Fuente
    private Font fontMedia;

    //borde
    private Border bInferiorAzul;

    public Registro() {
        //imagenes
        final int tamañoY = 30;
        iFondo = new ImageIcon("resourses/images/fondoL1.png");

        //fuente de texto
        fontMedia = new Font("LuzSans-Book", Font.PLAIN, 15);

        //borde
        bInferiorAzul = BorderFactory.createMatteBorder(0, 0, 2,
                0, Color.BLUE);

        //configurar el panel
        pPrincipal = new JPanel();
        pPrincipal.setSize(600, 500);
        pPrincipal.setLocation(0, 0);
        pPrincipal.setBackground(Color.BLACK);
        pPrincipal.setLayout(null);
        this.add(pPrincipal);
        //configuración de cuadros de texto
        tNombreUsuario = crearCuadroTexto("Nombre",
                140, tamañoY, obtenerPosicionX(140),
                40, Color.BLUE, Color.WHITE,
                Color.gray, bInferiorAzul);
        pPrincipal.add(tNombreUsuario);
        cajaTexto(tNombreUsuario, "Nombre");

        //    private JTextField tEdad;
        tEdad = crearCuadroTexto("Edad",
                60, tamañoY, obtenerPosicionX(60),
                (tNombreUsuario.getY() + tamañoY + 20), Color.BLUE,
                Color.WHITE, Color.gray, bInferiorAzul);
        pPrincipal.add(tEdad);
        cajaTexto(tEdad, "Edad");

        //jcombobx cbSexo
        cbSexo = new JComboBox();
        cbSexo.addItem("Hombre");
        cbSexo.addItem("Mujer");
        cbSexo.setSize(220, tamañoY);
        cbSexo.setLocation(obtenerPosicionX(220), tEdad.getY()
                + tamañoY + 20);
        cbSexo.setBackground(Color.WHITE);
        cbSexo.setForeground(Color.BLACK);

        ((JLabel) cbSexo.getRenderer()).setHorizontalAlignment(
                SwingConstants.CENTER);
        pPrincipal.add(cbSexo);

        //    private JTextField tTelefono;
        tTelefono = crearCuadroTexto("Teléfono",
                120, tamañoY, obtenerPosicionX(120),
                cbSexo.getY() + tamañoY + 20, Color.BLUE,
                Color.WHITE, Color.gray, bInferiorAzul);
        pPrincipal.add(tTelefono);
        cajaTexto(tTelefono, "Teléfono");

        //    private JTextField tCorreo;
        tCorreo = crearCuadroTexto("Correo",
                140, tamañoY, obtenerPosicionX(120),
                tTelefono.getY() + tamañoY + 20, Color.BLUE,
                Color.WHITE, Color.gray, bInferiorAzul);
        pPrincipal.add(tCorreo);
        cajaTexto(tCorreo, "Correo");

        //private JTextField tNombreJugador;
        tNombreJugador = crearCuadroTexto("Nombre Usuario",
                140, tamañoY, obtenerPosicionX(140),
                tCorreo.getY() + tamañoY + 20, Color.BLUE,
                Color.WHITE, Color.gray, bInferiorAzul);
        pPrincipal.add(tNombreJugador);
        cajaTexto(tNombreJugador, "Nombre Usuario");

        jContrasenia = new JPasswordField();
        jContrasenia.setText("////////");
        jContrasenia.setSize(260, tamañoY);
        jContrasenia.setLocation(obtenerPosicionX(260),
                tNombreJugador.getY() + tamañoY + 20);
        jContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
        jContrasenia.setForeground(Color.BLACK);
        jContrasenia.setBackground(Color.WHITE);
        jContrasenia.setCaretColor(Color.GRAY);
        jContrasenia.setFont(fontMedia);
        jContrasenia.setBorder(bInferiorAzul);
        pPrincipal.add(jContrasenia);
        cajaContrasenia(jContrasenia, "////////");
        //Botones
        this.bRegistrar = new JButton("Registrar");

        this.bRegistrar.setBounds(
                350, 10, 80, 30);

        this.bRegistrar.setForeground(Color.WHITE);
        //this.bRegistrar.setCursor(cMano);

        this.bRegistrar.addActionListener(
                this);

        this.bRegistrar.setLocation(
                (pPrincipal.getWidth() - bRegistrar.getWidth()) / 2,
                pPrincipal.getHeight() - 100);

        this.pPrincipal.add(
                this.bRegistrar);

        this.bRegistrar.setFocusable(
                false);

        this.bRegistrar.setBorder(
                null);

        this.bRegistrar.setContentAreaFilled(
                false);

        bRegistrar.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e
            ) {
                bRegistrar.setBackground(Color.LIGHT_GRAY);
                bRegistrar.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e
            ) {
                bRegistrar.setContentAreaFilled(false);
                bRegistrar.setBorder(null);
            }

            @Override
            public void mouseClicked(MouseEvent e
            ) {
                UsuarioController controller = new UsuarioController();

                Usuario user = controller.buscarRegistoNombre(
                        tNombreJugador.getText());
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
        //this.bRegresar.setCursor(cMano);

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

    public void cerrarFrame() {
        this.setVisible(false);
    }

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

    public int obtenerPosicionX(int tamanio) {
        return (pPrincipal.getWidth() - tamanio) / 2;
    }

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
