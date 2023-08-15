package ghosts;

import java.awt.Color;
import javax.swing.JOptionPane;

public class Configuracion extends javax.swing.JFrame {

    Login login;
    Player player;
    GhostGame gg;

    public Configuracion(Login login, Player player) {
        initComponents();
        this.player = player;
        this.login = login;
        setResizable(false);
        setLocationRelativeTo(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btndificultadnormal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnregresarconfig = new javax.swing.JButton();
        btndificultadgenio = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btndificultadexperto = new javax.swing.JButton();
        btnmodoaleatorio = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnmodomanual = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btndificultadnormal.setBackground(new java.awt.Color(51, 153, 0));
        btndificultadnormal.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        btndificultadnormal.setForeground(new java.awt.Color(0, 0, 0));
        btndificultadnormal.setText("Normal");
        btndificultadnormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndificultadnormalActionPerformed(evt);
            }
        });
        jPanel1.add(btndificultadnormal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 207, 68));

        jLabel1.setFont(new java.awt.Font("Papyrus", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Configuracion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, 62));

        jLabel2.setFont(new java.awt.Font("Papyrus", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Elegir Modo de Juego");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, 62));

        btnregresarconfig.setBackground(new java.awt.Color(153, 0, 0));
        btnregresarconfig.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        btnregresarconfig.setForeground(new java.awt.Color(0, 0, 0));
        btnregresarconfig.setText("Regresar");
        btnregresarconfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarconfigActionPerformed(evt);
            }
        });
        jPanel1.add(btnregresarconfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 170, 50));

        btndificultadgenio.setBackground(new java.awt.Color(153, 0, 0));
        btndificultadgenio.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        btndificultadgenio.setForeground(new java.awt.Color(0, 0, 0));
        btndificultadgenio.setText("Genio");
        btndificultadgenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndificultadgenioActionPerformed(evt);
            }
        });
        jPanel1.add(btndificultadgenio, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 207, 68));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("2 fantasmas + 4 trampa");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("de manera aleatoria");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("4 fantasmas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Papyrus", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Elegir Dificultad");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 74, -1, 62));

        btndificultadexperto.setBackground(new java.awt.Color(153, 0, 0));
        btndificultadexperto.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        btndificultadexperto.setForeground(new java.awt.Color(0, 0, 0));
        btndificultadexperto.setText("Experto");
        btndificultadexperto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndificultadexpertoActionPerformed(evt);
            }
        });
        jPanel1.add(btndificultadexperto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 207, 68));

        btnmodoaleatorio.setBackground(new java.awt.Color(51, 153, 0));
        btnmodoaleatorio.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        btnmodoaleatorio.setForeground(new java.awt.Color(0, 0, 0));
        btnmodoaleatorio.setText("Aleatorio");
        btnmodoaleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodoaleatorioActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodoaleatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 207, 68));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("8 fantasmas");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 216, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("manualmente uno por uno");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Todos los fantasmas se colocan");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Todos los fantasmas se colocan");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, -1, -1));

        btnmodomanual.setBackground(new java.awt.Color(153, 0, 0));
        btnmodomanual.setFont(new java.awt.Font("Papyrus", 1, 24)); // NOI18N
        btnmodomanual.setForeground(new java.awt.Color(0, 0, 0));
        btnmodomanual.setText("Manual");
        btnmodomanual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodomanualActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodomanual, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 207, 68));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/fondoconfiguracion.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndificultadnormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndificultadnormalActionPerformed
        player.dificultad = "NORMAL";
        JOptionPane.showMessageDialog(rootPane, "Dificultad cambiado a normal.");
        btndificultadnormal.setBackground(Color.green);
        btndificultadexperto.setBackground(Color.red);
        btndificultadgenio.setBackground(Color.red);

    }//GEN-LAST:event_btndificultadnormalActionPerformed

    private void btnregresarconfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarconfigActionPerformed
        MenuPrincipal menuprincipal = new MenuPrincipal(login, player);
        menuprincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnregresarconfigActionPerformed

    private void btndificultadgenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndificultadgenioActionPerformed
        player.dificultad = "GENIO";
        JOptionPane.showMessageDialog(rootPane, "Dificultad cambiado a genio.");
        btndificultadnormal.setBackground(Color.red);
        btndificultadexperto.setBackground(Color.red);
        btndificultadgenio.setBackground(Color.green);

    }//GEN-LAST:event_btndificultadgenioActionPerformed

    private void btndificultadexpertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndificultadexpertoActionPerformed
        player.dificultad = "EXPERTO";
        JOptionPane.showMessageDialog(rootPane, "Dificultad cambiado a experto.");
        btndificultadnormal.setBackground(Color.red);
        btndificultadexperto.setBackground(Color.green);
        btndificultadgenio.setBackground(Color.red);

    }//GEN-LAST:event_btndificultadexpertoActionPerformed

    private void btnmodoaleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodoaleatorioActionPerformed
        player.modo = "AZAR";
        btnmodoaleatorio.setBackground(Color.green);
        btnmodomanual.setBackground(Color.red);
        JOptionPane.showMessageDialog(rootPane, "Modo cambiado a aleatorio.");

    }//GEN-LAST:event_btnmodoaleatorioActionPerformed

    private void btnmodomanualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodomanualActionPerformed
        player.modo = "MANUAL";
        btnmodoaleatorio.setBackground(Color.red);
        btnmodomanual.setBackground(Color.green);
        JOptionPane.showMessageDialog(rootPane, "Modo cambiado a manual.");
    }//GEN-LAST:event_btnmodomanualActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndificultadexperto;
    private javax.swing.JButton btndificultadgenio;
    private javax.swing.JButton btndificultadnormal;
    private javax.swing.JButton btnmodoaleatorio;
    private javax.swing.JButton btnmodomanual;
    private javax.swing.JButton btnregresarconfig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
