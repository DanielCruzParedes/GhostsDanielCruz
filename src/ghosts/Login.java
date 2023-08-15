/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ghosts;

import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class Login extends javax.swing.JFrame {
    Player player;
    public int contadorFantasmasBuenos1;
    public int contadorFantasmasMalos1;
    public int contadorFantasmasBuenos2;
    public int contadorFantasmasMalos2;
    public String usuarioLogeado;
    public String segundoPlayer;
    
    /**
     * Creates new form Login
     */
    public Login(Player player) {
        initComponents();
        setLocationRelativeTo(this);
        this.player=player;
        player.modo="AZAR";
        setResizable(false);
    }
    
    
    public Player getControlador() {
        return player;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnlogin = new javax.swing.JButton();
        btnlogin1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuarioTextField = new javax.swing.JTextField();
        contrasenaPasswordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnlogin.setBackground(new java.awt.Color(51, 0, 0));
        btnlogin.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(102, 102, 102));
        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        jPanel1.add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 207, 68));

        btnlogin1.setBackground(new java.awt.Color(51, 0, 0));
        btnlogin1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btnlogin1.setForeground(new java.awt.Color(102, 102, 102));
        btnlogin1.setText("Regresar");
        btnlogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogin1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnlogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 170, 68));

        jLabel1.setFont(new java.awt.Font("Papyrus", 3, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Usuario: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 130, -1));

        jLabel3.setFont(new java.awt.Font("Papyrus", 3, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Contraseña:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 170, -1));

        usuarioTextField.setBackground(new java.awt.Color(0, 0, 0));
        usuarioTextField.setForeground(new java.awt.Color(204, 204, 204));
        usuarioTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(usuarioTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 190, 40));

        contrasenaPasswordField.setBackground(new java.awt.Color(0, 0, 0));
        contrasenaPasswordField.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(contrasenaPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 147, 190, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/fondologin.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 400));

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
    
    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed

          String usuario = usuarioTextField.getText();
        String contrasena = new String(contrasenaPasswordField.getPassword());
        Usuarios aux = player.buscarUsuario(usuario,0);
        
        if(usuarioTextField.getText().isEmpty() || contrasenaPasswordField.getPassword().length<1){
            JOptionPane.showMessageDialog(null, "Ingrese usuario y contraseña.");
        }else{
        if (aux != null) {
            if (aux.getContrasena().equals(contrasena)) {
                player.usuarioLogeado=usuario;
                player.dificultad="NORMAL";
                player.modo="AZAR";
                JOptionPane.showMessageDialog(null, "Bienvenido!");
                MenuPrincipal menuprincipal = new MenuPrincipal(this, player);
                menuprincipal.setVisible(true);
                setUsuarioLogeado();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
        }
        }
        
        usuarioTextField.setText("");
        contrasenaPasswordField.setText("");
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnlogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogin1ActionPerformed
        MenuDeInicio menudeinicio = new MenuDeInicio(this, player);
        menudeinicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnlogin1ActionPerformed

    private void usuarioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioTextFieldActionPerformed
    
    public void setUsuarioLogeado(){
        player.usuarioLogeado=usuarioTextField.getText();
        
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnlogin1;
    private javax.swing.JPasswordField contrasenaPasswordField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField usuarioTextField;
    // End of variables declaration//GEN-END:variables
}
