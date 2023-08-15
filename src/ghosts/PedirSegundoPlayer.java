package ghosts;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PedirSegundoPlayer extends javax.swing.JFrame {

    public String bandoElegido;
    Player player;
    Login login;
    MenuPrincipal menuprincipal;
    String primerPlayer;
    String segundoPlayer;
    JLabel lblTurnos;
    JTextArea taPlayer1;
    JTextArea taPlayer2;

    public PedirSegundoPlayer(Player player, Login login) {
        initComponents();
        setLocationRelativeTo(this);
        this.player = player;
        this.login = login;
        player.turno=1;
        lblUsuarioLogeado.setText(player.usuarioLogeado);
        if (player.listaUsuarios.size() < 2) {
            btnConfirmar.setEnabled(false);
        } else {
            btnConfirmar.setEnabled(true);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuarioLogeado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSegundoPlayer = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Player 1:");

        lblUsuarioLogeado.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lblUsuarioLogeado.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Player 2:");

        txtSegundoPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSegundoPlayerActionPerformed(evt);
            }
        });

        btnConfirmar.setBackground(new java.awt.Color(102, 0, 0));
        btnConfirmar.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("CONFIRMAR");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(102, 0, 0));
        btnExit.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuarioLogeado, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 106, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSegundoPlayer)))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnConfirmar)
                .addGap(49, 49, 49)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUsuarioLogeado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSegundoPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnExit))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSegundoPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegundoPlayerActionPerformed
        
    }//GEN-LAST:event_txtSegundoPlayerActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
        String segundoplayer = txtSegundoPlayer.getText();
        Usuarios user = player.buscarUsuario(segundoplayer, 0);
        if (txtSegundoPlayer.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos.");
        } else {
            if (user != null) {
                if (segundoplayer.equals(String.valueOf(player.usuarioLogeado))) {
                    JOptionPane.showMessageDialog(null, "El segundo player no puede ser el mismo que el primer player.");
                } else {
                    if (user.getUser().equals(segundoplayer)) {
                        player.segundoPlayer=segundoplayer;
                        AlrededorTablero at = new AlrededorTablero(login, player);
                        at.setVisible(true);
                        this.dispose();
                        
                    }else{
                JOptionPane.showMessageDialog(null, "El username del segundo player no existe.");
                        
                    }
                    
                }
                
            }
            
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        menuprincipal = new MenuPrincipal(login, player);
        menuprincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */

    public String getPrimerPlayer() {
        return primerPlayer;
    }

    public String getSegundoPlayer() {
        return segundoPlayer;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblUsuarioLogeado;
    private javax.swing.JTextField txtSegundoPlayer;
    // End of variables declaration//GEN-END:variables
}
