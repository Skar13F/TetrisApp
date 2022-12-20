/**
 * Autor: Nancy Obed Martínez Miguel
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 20 de diciembre de 2022
 * Descripción: En este frame muestra la pantalla de inicio para un
 *              usuario jugador, donde solo se muestran dos botones,
 *              uno de jugar y otro de cerrar.
 */
package view;

public class PantallaJuego extends javax.swing.JFrame {

    public PantallaJuego() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        tituloBienvenida = new javax.swing.JLabel();
        fondoPantalla = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setIcon(new javax.swing.ImageIcon("resourses/images/cerrar_2.png"));
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.setFocusPainted(false);
        btnSalir.setPressedIcon(new javax.swing.ImageIcon("resourses/images/cerrar.png"));
        btnSalir.setRolloverIcon(new javax.swing.ImageIcon("resourses/images/cerrar.png"));
        btnSalir.setSelectedIcon(new javax.swing.ImageIcon("resourses/images/cerrar_2.png"));
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 350, 140));

        btnJugar.setIcon(new javax.swing.ImageIcon("resourses/images/JUGAR.png"));
        btnJugar.setBorderPainted(false);
        btnJugar.setContentAreaFilled(false);
        btnJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnJugar.setFocusPainted(false);
        btnJugar.setRequestFocusEnabled(false);
        btnJugar.setRolloverIcon(new javax.swing.ImageIcon("resourses/images/JUGAR_1.png"));
        btnJugar.setSelectedIcon(new javax.swing.ImageIcon("resourses/images/JUGAR.png"));
        btnJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnJugarMouseClicked(evt);
            }
        });
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        getContentPane().add(btnJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 300, 120));

        tituloBienvenida.setIcon(new javax.swing.ImageIcon("resourses/images/hola.gif"));
        getContentPane().add(tituloBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 570, 150));

        fondoPantalla.setIcon(new javax.swing.ImageIcon("resourses/images/fondo1.png"));
        getContentPane().add(fondoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJugarMouseClicked
        Juego juego = new Juego();
        juego.setVisible(true);
        ocultar();

    }//GEN-LAST:event_btnJugarMouseClicked
    public void ocultar() {
        this.setVisible(false);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel fondoPantalla;
    private javax.swing.JLabel tituloBienvenida;
    // End of variables declaration//GEN-END:variables
}
