package view;

import controller.UsuarioController;
import entity.Rol;
import entity.Usuario;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
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
import service.RolServiceImpl;

public class PlantillaLogueo extends JFrame implements ActionListener {

    private JPanel panelDerecho;
    private JPanel panelIzquierdo;
    private JButton bCerrar;
    private JButton bIngresar;
    private JButton bRegistrar;
    private Cursor cMano;
    private ImageIcon iCerrar;
    private ImageIcon iFondo;
    private ImageIcon iDimAux;
    private ImageIcon iSvg1;
    private JLabel lFondo;
    private JLabel lSvg1;
    private JTextField tNombreUsuario;
    private JPasswordField jContrasenia;

    private Color colorPrincipal;
    private Color colorGrisOscuro;
    private Border bInferiorAzul;
    private Border bTotal;
    private Font fontMedia;

    private JComboBox cbTipoUsuario;

    private UsuarioController usuarioController;

    public PlantillaLogueo() {
        usuarioController = new UsuarioController();
        usuarioController.init();

        //cursores
        this.cMano = new Cursor(Cursor.HAND_CURSOR);

        //Cargar fuente
        generarFuente();

        //Agregar imágenes
        iCerrar = new ImageIcon("resourses/images/cerrar2.png");
        iFondo = new ImageIcon("resourses/images/fondoL1.png");
        iSvg1 = new ImageIcon("resourses/images/fondoL.png");

        //definición de colores
        colorPrincipal = new Color(60, 78, 120);
        colorGrisOscuro = new Color(80, 80, 80);

        bInferiorAzul = BorderFactory.createMatteBorder(0, 0, 2,
                0, colorPrincipal);
        bTotal = BorderFactory.createMatteBorder(1, 1, 1, 1,
                Color.WHITE);

        fontMedia = new Font("LuzSans-Book", Font.PLAIN, 15);

        panelIzquierdo = new JPanel();
        panelIzquierdo.setSize(550, 450);
        panelIzquierdo.setLocation(0, 0);
        panelIzquierdo.setBackground(Color.BLACK);
        //panelIzquierdo.setBackground(Color.WHITE);
        panelIzquierdo.setLayout(null);
        this.add(panelIzquierdo);

        panelDerecho = new JPanel();
        panelDerecho.setSize(300, 300);
        panelDerecho.setLocation((panelIzquierdo.getWidth()
                - panelDerecho.getWidth()) / 2, (panelIzquierdo.getHeight()
                - panelDerecho.getHeight()) / 2);
        panelDerecho.setBackground(Color.WHITE);

        panelDerecho.setLayout(null);
        panelIzquierdo.add(panelDerecho);

        //Comoponentes del panel derecho
        tNombreUsuario = new JTextField("Nombre Usuario");
        tNombreUsuario.setSize(260, 40);
        tNombreUsuario.setLocation((panelDerecho.getWidth()
                - tNombreUsuario.getWidth()) / 2, 60);
        tNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        tNombreUsuario.setForeground(colorPrincipal);
        tNombreUsuario.setBackground(Color.WHITE);
        tNombreUsuario.setCaretColor(colorGrisOscuro);
        tNombreUsuario.setFont(fontMedia);
        tNombreUsuario.setBorder(bInferiorAzul);
        panelDerecho.add(tNombreUsuario);

        jContrasenia = new JPasswordField();
        jContrasenia.setText("////////");
        jContrasenia.setSize(260, 40);
        jContrasenia.setLocation(tNombreUsuario.getX(), tNombreUsuario.getY()
                + tNombreUsuario.getHeight() + 10);
        jContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
        jContrasenia.setForeground(colorPrincipal);
        jContrasenia.setBackground(Color.WHITE);
        jContrasenia.setCaretColor(colorGrisOscuro);
        jContrasenia.setFont(fontMedia);
        jContrasenia.setBorder(bInferiorAzul);
        panelDerecho.add(jContrasenia);

        tNombreUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tNombreUsuario.hasFocus()
                        && tNombreUsuario.getText().equals("Nombre Usuario"
                                + "")) {
                    tNombreUsuario.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tNombreUsuario.getText().equals("")) {
                    tNombreUsuario.setText("Nombre Usuario");
                }
            }

        });
        jContrasenia.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jContrasenia.hasFocus() && String.valueOf(
                        jContrasenia.getPassword()).equals("////////"
                        + "")) {
                    jContrasenia.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(jContrasenia.getPassword()).equals(
                        "")) {
                    jContrasenia.setText("////////");
                }
            }

        });

        cbTipoUsuario = new JComboBox();
        aniadirItem(cbTipoUsuario);
        cbTipoUsuario.setSize(220, 30);
        cbTipoUsuario.setLocation((panelDerecho.getWidth()
                - cbTipoUsuario.getWidth()) / 2, jContrasenia.getY()
                + jContrasenia.getHeight() + 10);
        cbTipoUsuario.setBackground(Color.WHITE);
        cbTipoUsuario.setForeground(colorPrincipal);
        ((JLabel) cbTipoUsuario.getRenderer()).setHorizontalAlignment(
                SwingConstants.CENTER);
        panelDerecho.add(cbTipoUsuario);

        //Botones
        this.bCerrar = new JButton("X");
        this.bCerrar.setBounds(350, 10, 45, 30);
        this.bCerrar.setBackground(Color.BLUE);
        this.bCerrar.setForeground(Color.WHITE);
        this.bCerrar.setCursor(cMano);
        this.bCerrar.addActionListener(this);
        this.bCerrar.setLocation(panelIzquierdo.getWidth() - 35, 10);
        this.panelIzquierdo.add(this.bCerrar);
        iDimAux = new ImageIcon(iCerrar.getImage().getScaledInstance(
                30, 30, Image.SCALE_AREA_AVERAGING));

        this.bCerrar.setIcon(iDimAux);
        this.bCerrar.setFocusable(false);
        this.bCerrar.setBorder(null);
        this.bCerrar.setContentAreaFilled(false);

        this.bIngresar = new JButton("Ingresar");
        this.bIngresar.setBounds(350, 10, 80, 30);
        this.bIngresar.setForeground(Color.WHITE);
        this.bIngresar.setCursor(cMano);
        this.bIngresar.addActionListener(this);
        this.bIngresar.setLocation(cbTipoUsuario.getX(), cbTipoUsuario.getY()
                + cbTipoUsuario.getHeight() + 10);
        this.panelDerecho.add(this.bIngresar);

        this.bIngresar.setFocusable(false);
        this.bIngresar.setBorder(null);
        this.bIngresar.setContentAreaFilled(false);

        /**
         * eventos sobre el botón ingresar, si el mouse entra o sale del área
         * este cambiará su fondo
         */
        bIngresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bIngresar.setBackground(Color.LIGHT_GRAY);
                bIngresar.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bIngresar.setContentAreaFilled(false);
                bIngresar.setBorder(null);
            }

            /**
             * Al hacer click en el botón se hará una búsqueda en la BD
             * para comparar las credenciales que el usuario ingresó, si estas
             * coninciden se habilitará una nueva ventana dependiendo del 
             * tipo de usuario que este eligió, ya sea usuario(jugador) o 
             * usuario(administrador)
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                bIngresar.setBorder(bInferiorAzul);

                Usuario userAux = new Usuario();
                userAux.setNombre(tNombreUsuario.getText());
                userAux.setPassword(String.valueOf(
                        jContrasenia.getPassword()));
                userAux.setId_jugador(cbTipoUsuario.getSelectedIndex() + 1);
                Usuario user = usuarioController.buscarRegistoNC(userAux);

                if (user != null) {
                    cerrarFrame();
                    if ((cbTipoUsuario.getSelectedIndex() + 1) == 1) {
                        PantallaJuego pantallaJuego = new PantallaJuego();
                        pantallaJuego.setVisible(true);
                    } else if ((cbTipoUsuario.getSelectedIndex() + 1) == 2) {;
                        SuperAdministrador superAdministrador
                                = new SuperAdministrador();
                        superAdministrador.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, ""
                            + "Registro no encontrado");
                }

            }

        }
        );

        this.bRegistrar = new JButton("Registrate");
        this.bRegistrar.setBounds(350, 10, 80, 30);
        this.bRegistrar.setForeground(Color.WHITE);
        this.bRegistrar.setCursor(cMano);
        this.bRegistrar.addActionListener(this);
        this.bRegistrar.setLocation((cbTipoUsuario.getX()
                + cbTipoUsuario.getWidth() - this.bRegistrar.getWidth()),
                cbTipoUsuario.getY() + cbTipoUsuario.getHeight() + 10);
        this.panelDerecho.add(this.bRegistrar);
        this.bRegistrar.setFocusable(false);
        this.bRegistrar.setBorder(null);
        this.bRegistrar.setContentAreaFilled(false);
        bRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bRegistrar.setBackground(Color.LIGHT_GRAY);
                bRegistrar.setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bRegistrar.setContentAreaFilled(false);
                bRegistrar.setBorder(null);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                cerrarFrame();
                Registro registro = new Registro();
            }

        }
        );

        // colocar el fondo
        iDimAux = new ImageIcon(iSvg1.getImage().getScaledInstance(
                panelDerecho.getWidth(), panelDerecho.getHeight(),
                Image.SCALE_AREA_AVERAGING));
        lSvg1 = new JLabel();
        lSvg1.setBounds(0, 0, panelDerecho.getWidth(),
                panelDerecho.getHeight());
        lSvg1.setIcon(iDimAux);
        lSvg1.setBorder(bTotal);
        panelDerecho.add(lSvg1);

        iDimAux = new ImageIcon(iFondo.getImage().getScaledInstance(
                panelIzquierdo.getWidth(),
                panelIzquierdo.getHeight(),
                Image.SCALE_AREA_AVERAGING));
        lFondo = new JLabel();
        lFondo.setBounds(0, 0, panelIzquierdo.getWidth(),
                panelIzquierdo.getHeight());
        lFondo.setIcon(iDimAux);
        panelIzquierdo.add(lFondo);

        //configurar el jframe
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(550, 450);
        this.setLocationRelativeTo(this);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setVisible(true);

    }

    /**
     * Método para salir del frame si el usuario presiona el botón exit
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.getBCerrar()) {
            System.exit(0);
        }

    }

    /**
     * Método que retorna una acción sobre el botón cerrar
     */
    public JButton getBCerrar() {
        return this.bCerrar;
    }

       
    /**
     * Método que retorna una acción sobre el botón registrar
     */
    public JButton getBRegistrar() {
        return this.bRegistrar;
    }

    
    /**
     * Método para ocultar el frame
     */
    public void cerrarFrame() {
        this.setVisible(false);
    }

    /**
     * Método para cargar la fuente al proyecto
     */
    private void generarFuente() {
        try {
            GraphicsEnvironment ge
                    = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(
                    Font.TRUETYPE_FONT, new File(
                            "resourses/fonts/LUZRO.TTF")));
        } catch (Exception e) {
        }
    }

    /**
     * Método para agrgar los items al jcombobox de roles
     */
    public void aniadirItem(JComboBox jcRol) {
       RolServiceImpl impl = new RolServiceImpl();
        List<Rol> listaRol = impl.obtenerRegistro();
        for (int i = 0; i < listaRol.size(); i++) {
            jcRol.addItem(listaRol.get(i).getRol());
        }
    }

}
