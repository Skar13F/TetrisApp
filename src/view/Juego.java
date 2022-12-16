/**
 * Autor: Nancy Obed Martínez Miguel
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 05 de diciembre de 2022
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
        jLabel2 = new javax.swing.JLabel();
        btnArriba = new javax.swing.JButton();
        btnIzquierda = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelJuego.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon("resourses/images/nn.png"));

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJuegoLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 500, Short.MAX_VALUE))
        );

        getContentPane().add(panelJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 370, 500));

        btnArriba.setText("Arriba");
        btnArriba.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnArriba.setBorderPainted(false);
        getContentPane().add(btnArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 70, 20));

        btnIzquierda.setText("Izquierda");
        btnIzquierda.setBorderPainted(false);
        getContentPane().add(btnIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        jButton3.setText("Derecha");
        jButton3.setBorderPainted(false);
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, -1, -1));

        jButton4.setText("Abajo");
        jButton4.setBorderPainted(false);
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 70, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/labingsw03/NetBeansProjects/TetrisApp/resourses/images/fondo6.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArriba;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables
}
