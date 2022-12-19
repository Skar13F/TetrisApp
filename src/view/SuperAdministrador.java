/**
 * Autor: Nancy Obed Martínez Miguel y Oscar Fuentes
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 05 de diciembre de 2022
 * Descripción: En este frame se mostrará la pantalla de interacción como
 *              usuario administrador,dónde muestra una tabla con los datos de
 *              los diferentes usuarios, al igual que se pueden  insertar
 *              eliminar, y actualizar registros.
 */
package view;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import controller.JugadorController;
import controller.RolController;
import controller.UsuarioController;
import entity.Jugador;
import entity.Rol;
import entity.Usuario;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import service.JugadorServiceImpl;
import service.RolServiceImpl;

public class SuperAdministrador extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private int idUsuario;
    private UsuarioController userController;
    private RolController rolController;
    private JugadorController jugadorController;

    private JLabel fondo1;
    private JLabel fondo2;

    private ImageIcon iFondo1;
    private ImageIcon iFondo2;
    private ImageIcon iAux;

    public SuperAdministrador() {
        initComponents();

        modelo = (DefaultTableModel) tablaUsuario.getModel();
        userController = new UsuarioController();
        rolController = new RolController();
        jugadorController = new JugadorController();
        userController.init();
        jugadorController.init();
        userController.init();
        rolController.init();
        userController.mostrarRegistros(modelo);

        iFondo1 = new ImageIcon("resourses/images/fondoC1.png");
        iFondo2 = new ImageIcon("resourses/images/fondoC3.png");

        iAux = new ImageIcon(iFondo1.getImage().getScaledInstance(
                panelAdministrador.getWidth(), panelAdministrador.getHeight(),
                Image.SCALE_AREA_AVERAGING));
        fondo1 = new JLabel();
        fondo1.setBounds(0, 0, panelAdministrador.getWidth(),
                panelAdministrador.getHeight());
        fondo1.setIcon(iAux);
        panelAdministrador.add(fondo1);

        iAux = new ImageIcon(iFondo2.getImage().getScaledInstance(
                panelGestion.getWidth(), panelGestion.getHeight(),
                Image.SCALE_AREA_AVERAGING));
        fondo2 = new JLabel();
        fondo2.setBounds(0, 0, panelGestion.getWidth(),
                panelGestion.getHeight());
        fondo2.setIcon(iAux);
        panelGestion.add(fondo2);

        addItemRol(cbRol);
        addItemJugador(cbTelefono);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAdministrador = new javax.swing.JPanel();
        labelAdministrador = new javax.swing.JLabel();
        bConfiguracion = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        labelUsuario = new javax.swing.JLabel();
        panelGestion = new javax.swing.JPanel();
        cbRol = new javax.swing.JComboBox<>();
        cbTelefono = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        labelNombreUsuario = new javax.swing.JLabel();
        textFieldNombre = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        labelContraseña = new javax.swing.JLabel();
        scrollPanelTabla = new javax.swing.JScrollPane();
        tablaUsuario = new javax.swing.JTable();
        labelTituloUsuarios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAdministrador.setBackground(new java.awt.Color(0, 204, 204));
        panelAdministrador.setPreferredSize(new java.awt.Dimension(280, 387));

        labelAdministrador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelAdministrador.setText("Administrador");

        bConfiguracion.setBackground(new java.awt.Color(153, 153, 153));
        bConfiguracion.setIcon(new javax.swing.ImageIcon("/home/labingsw03/NetBeansProjects/TetrisApp/resourses/images/config.png")); // NOI18N
        bConfiguracion.setText("Configuración");
        bConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bConfiguracion.setFocusable(false);
        bConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfiguracionActionPerformed(evt);
            }
        });

        bSalir.setBackground(new java.awt.Color(153, 153, 153));
        bSalir.setText("Salir");
        bSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bSalir.setFocusable(false);
        bSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSalirMouseClicked(evt);
            }
        });
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        labelUsuario.setIcon(new javax.swing.ImageIcon("/home/labingsw03/NetBeansProjects/TetrisApp/resourses/images/usuario2.png")); // NOI18N
        labelUsuario.setToolTipText("Soy un usuario");

        javax.swing.GroupLayout panelAdministradorLayout = new javax.swing.GroupLayout(panelAdministrador);
        panelAdministrador.setLayout(panelAdministradorLayout);
        panelAdministradorLayout.setHorizontalGroup(
            panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdministradorLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAdministradorLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(labelAdministrador))
                    .addGroup(panelAdministradorLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(labelUsuario)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelAdministradorLayout.setVerticalGroup(
            panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdministradorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labelAdministrador)
                .addGap(32, 32, 32)
                .addComponent(labelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(bConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        getContentPane().add(panelAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelGestion.setBackground(java.awt.Color.pink);
        panelGestion.setPreferredSize(new java.awt.Dimension(500, 380));

        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - ROL - -" }));

        cbTelefono.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - TELÉFONO - -" }));
        cbTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTelefonoActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        labelNombreUsuario.setText("Nombre del usuario");

        labelContraseña.setText("Contraseña");

        tablaUsuario.setBackground(new java.awt.Color(102, 255, 102));
        tablaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usuario", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuarioMouseClicked(evt);
            }
        });
        scrollPanelTabla.setViewportView(tablaUsuario);
        if (tablaUsuario.getColumnModel().getColumnCount() > 0) {
            tablaUsuario.getColumnModel().getColumn(0).setResizable(false);
        }

        labelTituloUsuarios.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        labelTituloUsuarios.setText("Gestión de Usuarios");

        javax.swing.GroupLayout panelGestionLayout = new javax.swing.GroupLayout(panelGestion);
        panelGestion.setLayout(panelGestionLayout);
        panelGestionLayout.setHorizontalGroup(
            panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGestionLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(labelTituloUsuarios))
            .addGroup(panelGestionLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombreUsuario)
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelContraseña)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGestionLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(scrollPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelGestionLayout.setVerticalGroup(
            panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGestionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelTituloUsuarios)
                .addGap(38, 38, 38)
                .addGroup(panelGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGestionLayout.createSequentialGroup()
                        .addComponent(labelNombreUsuario)
                        .addGap(2, 2, 2)
                        .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(labelContraseña)
                        .addGap(2, 2, 2)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(cbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnGuardar)
                        .addGap(9, 9, 9)
                        .addComponent(btnActualizar)
                        .addGap(10, 10, 10)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(panelGestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, -3, 620, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfiguracionActionPerformed

    }//GEN-LAST:event_bConfiguracionActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed

    }//GEN-LAST:event_bSalirActionPerformed

    private void cbTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTelefonoActionPerformed

    }//GEN-LAST:event_cbTelefonoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        Usuario usuario = new Usuario();

        String telefono = cbTelefono.getSelectedItem().toString();
        String rolA = cbRol.getSelectedItem().toString();

        Jugador jugador = jugadorController.buscarRegistroTelefono(telefono);
        Rol rol = rolController.buscarRegistro(rolA);

        usuario.setNombre(this.textFieldNombre.getText());
        usuario.setPassword(String.valueOf(
                passwordField.getPassword()));
        usuario.setId_jugador(jugador.getId_jugador());
        usuario.setId_rol(rol.getIdRol());

        userController.crearActualizarUsuario(usuario);
        userController.mostrarRegistros(modelo);
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void tablaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuarioMouseClicked
        idUsuario = Integer.parseInt(tablaUsuario.getValueAt(
                tablaUsuario.getSelectedRow(), 0).toString());
        textFieldNombre.setText(tablaUsuario.getValueAt(tablaUsuario.getSelectedRow(),
                1).toString());
        passwordField.setText(tablaUsuario.getValueAt(
                tablaUsuario.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tablaUsuarioMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        userController.eliminarRegistro(idUsuario);
        userController.mostrarRegistros(modelo);
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        String telefono = cbTelefono.getSelectedItem().toString();
        String rolA = cbRol.getSelectedItem().toString();

        Jugador jugador = jugadorController.buscarRegistroTelefono(telefono);
        Rol rol = rolController.buscarRegistro(rolA);
        Usuario usuario = new Usuario();

        usuario.setId_usuario(idUsuario);
        usuario.setNombre(textFieldNombre.getText());
        usuario.setPassword(String.valueOf(
                passwordField.getPassword()));
        usuario.setId_jugador(jugador.getId_jugador());
        usuario.setId_rol(rol.getIdRol());

        userController.crearActualizarUsuario(usuario);
        userController.mostrarRegistros(modelo);
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void bSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSalirMouseClicked
        this.setVisible(false);
        PlantillaLogueo logueo = new PlantillaLogueo();
        logueo.setVisible(true);
    }//GEN-LAST:event_bSalirMouseClicked

    public void addItemRol(JComboBox jcB) {
        RolServiceImpl impl = new RolServiceImpl();
        List<Rol> listaRol = impl.obtenerRegistro();
        for (Rol rol : listaRol) {
            jcB.addItem(rol.getRol());
        }
    }

    public void addItemJugador(JComboBox jcB) {
        JugadorServiceImpl impl = new JugadorServiceImpl();
        List<Jugador> listaJugador = impl.obtenerRegistro();
        for (Jugador rol : listaJugador) {
            jcB.addItem(rol.getTelefono());
        }
    }

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(new AeroLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuperAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bConfiguracion;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JComboBox<String> cbTelefono;
    private javax.swing.JLabel labelAdministrador;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelNombreUsuario;
    private javax.swing.JLabel labelTituloUsuarios;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelAdministrador;
    private javax.swing.JPanel panelGestion;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JScrollPane scrollPanelTabla;
    private javax.swing.JTable tablaUsuario;
    private javax.swing.JTextField textFieldNombre;
    // End of variables declaration//GEN-END:variables
}
