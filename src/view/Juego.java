/**
 * Autor: Nancy Obed Martínez Miguel
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 20 de diciembre de 2022
 * Descripción: En este frame se cargará el juego funcional,
 *              con opciones básicas de interacción con el
 *              usuario mediante botones.
 */
package view;

public class Juego extends javax.swing.JFrame {

    public Juego() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJuego = new javax.swing.JPanel();
        encabezado = new javax.swing.JLabel();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelJuego.setBackground(new java.awt.Color(0, 0, 0));

        encabezado.setIcon(new javax.swing.ImageIcon("resourses/images/Titulo.png"));

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addComponent(encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 417, Short.MAX_VALUE))
        );

        getContentPane().add(panelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 370, 500));

        btnArriba.setIcon(new javax.swing.ImageIcon("resourses/images/arriba.png"));
        btnArriba.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnArriba.setBorderPainted(false);
        getContentPane().add(btnArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 90, -1));

        btnIzquierda.setIcon(new javax.swing.ImageIcon("resourses/images/izquierda.png"));
        btnIzquierda.setBorderPainted(false);
        getContentPane().add(btnIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 90, -1));

        btnDerecha.setIcon(new javax.swing.ImageIcon("resourses/images/derecha.png"));
        btnDerecha.setBorderPainted(false);
        getContentPane().add(btnDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 90, -1));

        btnAbajo.setIcon(new javax.swing.ImageIcon("resourses/images/abajo.png"));
        btnAbajo.setBorderPainted(false);
        getContentPane().add(btnAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 90, -1));

        cajaPuntos.setEnabled(false);
        cajaPuntos.setFocusable(false);
        getContentPane().add(cajaPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, -1));

        labelPuntos.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        labelPuntos.setForeground(new java.awt.Color(0, 204, 51));
        labelPuntos.setText("Puntos");
        getContentPane().add(labelPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        labelNivel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        labelNivel.setForeground(new java.awt.Color(0, 204, 51));
        labelNivel.setText("Nivel");
        getContentPane().add(labelNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        cajaNivel.setEnabled(false);
        cajaNivel.setFocusable(false);
        getContentPane().add(cajaNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 230, 80, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon("resourses/images/salir_1.png"));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, -1, -1));

        fondoJuego.setIcon(new javax.swing.ImageIcon("resourses/images/fondo6.png"));
        getContentPane().add(fondoJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        PantallaJuego pantallajuego=new PantallaJuego();
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
    private javax.swing.JLabel encabezado;
    private javax.swing.JLabel fondoJuego;
    private javax.swing.JLabel labelNivel;
    private javax.swing.JLabel labelPuntos;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables
}
