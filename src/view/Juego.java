/**
 * Autor: Nancy Obed Martínez Miguel
 * Fecha de creación: 28 de noviembre de 2022
 * Fecha de actualización: 19 de diciembre de 2022
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
        jTextField2 = new javax.swing.JTextField();
        fondoJuego = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelJuego.setBackground(new java.awt.Color(0, 0, 0));

        encabezado.setIcon(new javax.swing.ImageIcon("/home/labingsw03/NetBeansProjects/TetrisApp/resourses/images/Titulo.png")); // NOI18N

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

        btnArriba.setText("Arriba");
        btnArriba.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnArriba.setBorderPainted(false);
        getContentPane().add(btnArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 90, -1));

        btnIzquierda.setText("Izquierda");
        btnIzquierda.setBorderPainted(false);
        getContentPane().add(btnIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        btnDerecha.setText("Derecha");
        btnDerecha.setBorderPainted(false);
        getContentPane().add(btnDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, -1, -1));

        btnAbajo.setText("Abajo");
        btnAbajo.setBorderPainted(false);
        getContentPane().add(btnAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 90, -1));
        getContentPane().add(cajaPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, -1));

        labelPuntos.setForeground(new java.awt.Color(204, 0, 51));
        labelPuntos.setText("Puntos");
        getContentPane().add(labelPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        labelNivel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        labelNivel.setForeground(new java.awt.Color(204, 0, 51));
        labelNivel.setText("Nivel");
        getContentPane().add(labelNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 230, 80, -1));

        fondoJuego.setIcon(new javax.swing.ImageIcon("/home/labingsw03/NetBeansProjects/TetrisApp/resourses/images/fondo6.png")); // NOI18N
        getContentPane().add(fondoJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
    private javax.swing.JButton btnAbajo;
    private javax.swing.JButton btnArriba;
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JTextField cajaPuntos;
    private javax.swing.JLabel encabezado;
    private javax.swing.JLabel fondoJuego;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelNivel;
    private javax.swing.JLabel labelPuntos;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables
}
