package Login; 
import javax.swing.JOptionPane; 
public class LoginView extends javax.swing.JFrame { 
    public LoginView() { 
        initComponents(); 
    } 
    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents 
    private void initComponents() { 
        var jPanel1 = new javax.swing.JPanel(); 
        var jLabel1 = new javax.swing.JLabel(); 
        var jLabel2 = new javax.swing.JLabel(); 
        var tfusername = new javax.swing.JTextField(); 
        var jLabel3 = new javax.swing.JLabel(); 
        var tfpassword = new javax.swing.JPasswordField(); 
        var btnlogin = new javax.swing.JButton(); 
        var jButton2 = new javax.swing.JButton(); 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 
        setBackground(new java.awt.Color(0, 255, 0)); 
        jPanel1.setBackground(new java.awt.Color(153, 255, 153)); 
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N 
        jLabel1.setText("LOGIN"); 
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N 
        jLabel2.setText("UserName"); 
        tfusername.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N 
        tfusername.addActionListener(evt -> tfusernameActionPerformed(evt)); 
        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N 
        jLabel3.setText("PassWord"); 
        tfpassword.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N 
        tfpassword.addActionListener(evt -> tfpasswordActionPerformed(evt)); 
        btnlogin.setBackground(new java.awt.Color(0, 153, 51)); 
        btnlogin.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N 
        btnlogin.setText("Login"); 
        btnlogin.addActionListener(evt -> btnloginActionPerformed(evt)); 
        jButton2.setBackground(new java.awt.Color(0, 153, 0)); 
        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N 
        jButton2.setText("Register"); 
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt)); 
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1); 
        jPanel1.setLayout(jPanel1Layout); 
        jPanel1Layout.setHorizontalGroup( 
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) 
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup() 
                .addGap(30, 30, 30) 
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) 
                    .addComponent(jLabel2) 
                    .addComponent(jLabel3)) 
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE) 
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) 
                    .addComponent(tfusername, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE) 
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE) 
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false) 
                        .addGroup(jPanel1Layout.createSequentialGroup() 
                            .addComponent(btnlogin) 
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) 
                            .addComponent(jButton2)) 
                        .addComponent(tfpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))) 
                .addGap(40, 40, 40)) 
        ); 
        jPanel1Layout.setVerticalGroup( 
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) 
            .addGroup(jPanel1Layout.createSequentialGroup() 
                .addGap(26, 26, 26) 
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE) 
                .addGap(52, 52, 52) 
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE) 
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE) 
                    .addComponent(tfusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) 
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE) 
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE) 
                    .addComponent(tfpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) 
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) 
                .addGap(36, 36, 36) 
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE) 
                    .addComponent(btnlogin) 
                    .addComponent(jButton2)) 
                .addGap(43, 43, 43)) 
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
        setLocationRelativeTo(null); 
    }// </editor-fold>//GEN-END:initComponents 
    private void tfusernameActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here: 
    } 
    private void tfpasswordActionPerformed(java.awt.event.ActionEvent evt) { 
        // TODO add your handling code here: 
    } 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { 
        // button next signup 
        new SignUpViews().show(); 
        this.setVisible(false); 
    } 
    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) { 
        // btn login: 
        var username1 = tfusername.getText(); 
        var password1 = tfpassword.getText(); 
        password1 = Utilyti.getSecurityMD5(password1); 
        var us = UserModify.Login(username1, password1); 
        if (us == null) { 
            JOptionPane.showMessageDialog(this, "Account does not exist !!!"); 
        } else if (us.getActive() == 0) { 
            JOptionPane.showMessageDialog(this, "Account not activated !!!"); 
        } else { 
            switch (us.getRole_id()) { 
                case 2 -> new Server1().show(); 
                default -> new Client().show(); 
            } 
        } 
    } 
    public static void main(String args[]) { 
        java.awt.EventQueue.invokeLater(() -> new LoginView().setVisible(true)); 
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables 
    private javax.swing.JButton btnlogin; 
    private javax.swing.JButton jButton2; 
    private javax.swing.JLabel jLabel1; 
    private javax.swing.JLabel jLabel2; 
    private javax.swing.JLabel jLabel3; 
    private javax.swing.JPanel jPanel1; 
    private javax.swing.JPasswordField tfpassword; 
    private javax.swing.JTextField tfusername; 
    // End of variables declaration//GEN-END:variables 
}