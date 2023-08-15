package ghosts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;

public final class AlrededorTablero extends javax.swing.JFrame {

    Login login;
    Player player;

    public AlrededorTablero(Login login, Player player) {
        this.login = login;
        this.player = player;
        initComponents();
        this.setLocationRelativeTo(this);
        setVisible(true);
        setResizable(false);
        setTitle("Ghosts - En Partida");
        tablero.setLayout(new GridLayout(1, 1));
        tablero.setMinimumSize(new Dimension(500, 1000));
        tablero.add(new GhostGame(login, player,lblTurno, taPlayer1, taPlayer2, this));
        switch (player.dificultad) {
            case "NORMAL":
                player.contadorFantasmasBuenos1 = 4;
                player.contadorFantasmasBuenos2 = 4;
                player.contadorFantasmasMalos1 = 4;
                player.contadorFantasmasMalos2 = 4;
                break;
            case "EXPERTO":
                player.contadorFantasmasBuenos1 = 2;
                player.contadorFantasmasBuenos2 = 2;
                player.contadorFantasmasMalos1 = 2;
                player.contadorFantasmasMalos2 = 2;
                break;
            case "GENIO":
                player.contadorFantasmasBuenos1 = 1;
                player.contadorFantasmasBuenos2 = 1;
                player.contadorFantasmasMalos1 = 1;
                player.contadorFantasmasMalos2 = 1;
                break;
            default:
                break;
         }
        
        taPlayer1.setEditable(false);
        taPlayer2.setEditable(false);
        lblPlayer1.setText(player.usuarioLogeado);
        lblPlayer2.setText(player.segundoPlayer);
        lblTurno.setText(player.usuarioLogeado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tablero = new javax.swing.JPanel();
        lblPlayer1 = new javax.swing.JLabel();
        lblPlayer2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taPlayer1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taPlayer2 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnRendirse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1720, 980));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablero.setBackground(new java.awt.Color(204, 255, 255));
        tablero.setPreferredSize(new java.awt.Dimension(780, 780));

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );

        jPanel1.add(tablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 0, -1, -1));

        lblPlayer1.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        lblPlayer1.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayer1.setText("player1");
        jPanel1.add(lblPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        lblPlayer2.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        lblPlayer2.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayer2.setText("player2");
        jPanel1.add(lblPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 170, -1, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fantasmas Restantes de");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        taPlayer1.setColumns(20);
        taPlayer1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        taPlayer1.setRows(5);
        jScrollPane3.setViewportView(taPlayer1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 260, 150));

        taPlayer2.setColumns(20);
        taPlayer2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        taPlayer2.setRows(5);
        jScrollPane2.setViewportView(taPlayer2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 250, 250, 150));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fantasmas Restantes de");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 120, -1, 40));

        lblTurno.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        lblTurno.setForeground(new java.awt.Color(255, 255, 255));
        lblTurno.setText("player");
        jPanel1.add(lblTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 640, -1, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Turno de:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 640, -1, 40));

        btnRendirse.setBackground(new java.awt.Color(149, 64, 35));
        btnRendirse.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        btnRendirse.setForeground(new java.awt.Color(0, 0, 0));
        btnRendirse.setText("Rendirse");
        btnRendirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRendirseActionPerformed(evt);
            }
        });
        jPanel1.add(btnRendirse, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 700, 210, 70));

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

    private void btnRendirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRendirseActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea rendirse?", "", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            if (player.turno == 1) {

                JOptionPane.showMessageDialog(null, player.segundoPlayer + " HA GANADO!");
                player.buscarUsuario(player.segundoPlayer, 0).setPuntos(3);
                player.buscarUsuario(player.segundoPlayer, 0).setLogs(player.segundoPlayer +" ha ganado ya que "+player.usuarioLogeado+" se ha retirado.");
                this.dispose();
                
            }
            if (player.turno == 2) {
                player.logs = player.usuarioLogeado + " HA GANADO YA QUE " + player.segundoPlayer + " SE HA RETIRADO DEL JUEGO -\n" + player.logs;
                JOptionPane.showMessageDialog(null, player.usuarioLogeado + " HA GANADO!");
                player.buscarUsuario(player.usuarioLogeado, 0).setPuntos(3);
                player.buscarUsuario(player.usuarioLogeado, 0).setLogs(player.usuarioLogeado +" ha ganado ya que "+player.segundoPlayer+" se ha retirado.");
                this.dispose();
                this.dispose();
            }
            MenuPrincipal mp = new MenuPrincipal(login, player);
            mp.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnRendirseActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRendirse;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblPlayer2;
    private javax.swing.JLabel lblTurno;
    public javax.swing.JTextArea taPlayer1;
    public javax.swing.JTextArea taPlayer2;
    private javax.swing.JPanel tablero;
    // End of variables declaration//GEN-END:variables
}
