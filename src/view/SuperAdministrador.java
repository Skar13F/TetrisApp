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

        modelo = (DefaultTableModel) jTable1.getModel();
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
                jPanel1.getWidth(), jPanel1.getHeight(),
                Image.SCALE_AREA_AVERAGING));
        fondo1 = new JLabel();
        fondo1.setBounds(0, 0, jPanel1.getWidth(),
                jPanel1.getHeight());
        fondo1.setIcon(iAux);
        jPanel1.add(fondo1);

        iAux = new ImageIcon(iFondo2.getImage().getScaledInstance(
                jPanel2.getWidth(), jPanel2.getHeight(),
                Image.SCALE_AREA_AVERAGING));
        fondo2 = new JLabel();
        fondo2.setBounds(0, 0, jPanel2.getWidth(),
                jPanel2.getHeight());
        fondo2.setIcon(iAux);
        jPanel2.add(fondo2);

        addItemRol(cbRol);
        addItemJugador(cbTelefono);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelAdministrador = new javax.swing.JLabel();
        bConfiguracion = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        labelUsuario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbRol = new javax.swing.JComboBox<>();
        cbTelefono = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        labelNombreUsuario = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(280, 387));

        labelAdministrador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelAdministrador.setText("Administrador");

        bConfiguracion.setBackground(new java.awt.Color(153, 153, 153));
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

        labelUsuario.setToolTipText("Soy un usuario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(labelAdministrador))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(labelUsuario)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(java.awt.Color.pink);
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 380));

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

        jLabel4.setText("Contraseña");

        jTable1.setBackground(new java.awt.Color(102, 255, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel5.setText("Gestión de Usuarios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel5))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombreUsuario)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelNombreUsuario)
                        .addGap(2, 2, 2)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4)
                        .addGap(2, 2, 2)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, -3, 620, 390));

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

        usuario.setNombre(this.jTextField1.getText());
        usuario.setPassword(String.valueOf(
                jPasswordField1.getPassword()));
        usuario.setId_jugador(jugador.getId_jugador());
        usuario.setId_rol(rol.getIdRol());

        userController.crearActualizarUsuario(usuario);
        userController.mostrarRegistros(modelo);
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        idUsuario = Integer.parseInt(jTable1.getValueAt(
                jTable1.getSelectedRow(), 0).toString());
        jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(),
                1).toString());
        jPasswordField1.setText(jTable1.getValueAt(
                jTable1.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_jTable1MouseClicked

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
        usuario.setNombre(jTextField1.getText());
        usuario.setPassword(String.valueOf(
                jPasswordField1.getPassword()));
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelAdministrador;
    private javax.swing.JLabel labelNombreUsuario;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}
