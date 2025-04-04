package chat; 
import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.concurrent.Executors; 
import java.util.concurrent.ExecutorService; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.JFileChooser; 
import javax.swing.filechooser.FileNameExtensionFilter; 
public class Server1 extends javax.swing.JFrame { 
    static ServerSocket serverSocket; 
    static Socket socket; 
    static DataInputStream dis; 
    static DataOutputStream dos; 
    public Server1() { 
        initComponents(); 
        this.getRootPane().setDefaultButton(btsend); 
    } 
    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents 
    private void initComponents() { 
        jPanel1 = new javax.swing.JPanel(); 
        jScrollPane1 = new javax.swing.JScrollPane(); 
        txtchat = new javax.swing.JTextArea(); 
        btsend = new javax.swing.JButton(); 
        jScrollPane3 = new javax.swing.JScrollPane(); 
        txtmes1 = new javax.swing.JTextArea(); 
        it = new javax.swing.JMenuBar(); 
        jMenu1 = new javax.swing.JMenu(); 
        itSaveAs = new javax.swing.JMenuItem(); 
        itOpen = new javax.swing.JMenuItem(); 
        jMenu2 = new javax.swing.JMenu(); 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 
        setTitle("thinh"); 
        txtchat.setEditable(false); 
        txtchat.setColumns(20); 
        txtchat.setRows(5); 
        jScrollPane1.setViewportView(txtchat); 
        btsend.setText("SEND"); 
        btsend.addActionListener(new java.awt.event.ActionListener() { 
            public void actionPerformed(java.awt.event.ActionEvent evt) { 
                btsendActionPerformed(evt); 
            } 
        }); 
        txtmes1.setColumns(20); 
        txtmes1.setRows(5); 
        jScrollPane3.setViewportView(txtmes1); 
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1); 
        jPanel1.setLayout(jPanel1Layout); 
        jPanel1Layout.setHorizontalGroup( 
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) 
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING) 
            .addGroup(jPanel1Layout.createSequentialGroup() 
                .addContainerGap() 
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE) 
                .addGap(33, 33, 33) 
                .addComponent(btsend, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE) 
                .addGap(16, 16, 16)) 
        ); 
        jPanel1Layout.setVerticalGroup( 
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) 
            .addGroup(jPanel1Layout.createSequentialGroup() 
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE) 
                .addGap(18, 18, 18) 
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false) 
                    .addComponent(btsend, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE) 
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)) 
                .addContainerGap(18, Short.MAX_VALUE)) 
        ); 
        jMenu1.setText("File"); 
        itSaveAs.setText("Save As"); 
        itSaveAs.addActionListener(new java.awt.event.ActionListener() { 
            public void actionPerformed(java.awt.event.ActionEvent evt) { 
                itSaveAsActionPerformed(evt); 
            } 
        }); 
        jMenu1.add(itSaveAs); 
        itOpen.setText("Open"); 
        itOpen.addActionListener(new java.awt.event.ActionListener() { 
            public void actionPerformed(java.awt.event.ActionEvent evt) { 
                itOpenActionPerformed(evt); 
            } 
        }); 
        jMenu1.add(itOpen); 
        it.add(jMenu1); 
        jMenu2.setText("Edit"); 
        it.add(jMenu2); 
        setJMenuBar(it); 
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
    private void btsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsendActionPerformed 
        try { 
            //button send: 
            dos.writeUTF(txtmes1.getText().trim()); 
            txtchat.append("\n thinh : " + txtmes1.getText().trim()); 
            txtmes1.setText(""); 
        } catch (IOException ex) { 
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    }//GEN-LAST:event_btsendActionPerformed 
    private void itSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itSaveAsActionPerformed 
        // save as: 
        JFileChooser jfc = new JFileChooser(); 
        FileNameExtensionFilter text = new FileNameExtensionFilter("text", "all"); 
        jfc.setFileFilter(text); 
        jfc.setMultiSelectionEnabled(false); 
        int x = jfc.showDialog(this, "Save"); 
        if(x == JFileChooser.APPROVE_OPTION){ 
            Modify.saveAs(jfc.getSelectedFile().getPath(), txtchat.getText()); 
        } 
    }//GEN-LAST:event_itSaveAsActionPerformed 
    private void itOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itOpenActionPerformed 
        // TODO add your handling code here: 
        JFileChooser jfc = new JFileChooser(); 
        FileNameExtensionFilter text = new FileNameExtensionFilter("text","txt","text"); 
        jfc.setFileFilter(text); 
        jfc.setMultiSelectionEnabled(false); 
        int x = jfc.showDialog(this,"Open"); 
        if(x == JFileChooser.APPROVE_OPTION){ 
            txtchat.setText(Modify.openFile(jfc.getSelectedFile().getPath())); 
        } 
    }//GEN-LAST:event_itOpenActionPerformed 
    public static void main(String args[]) { 
        java.awt.EventQueue.invokeLater(() -> new Server1().setVisible(true)); 
        ExecutorService executorService = Executors.newCachedThreadPool(); 
        try (ServerSocket serverSocket = new ServerSocket(4444)) { 
            System.out.println("Server is listening on port 4444"); 
            while (true) { 
                Socket socket = serverSocket.accept(); 
                executorService.submit(() -> handleClient(socket)); 
            } 
        } catch (IOException ex) { 
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 
    private static void handleClient(Socket socket) {
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream()); // assign to static field!

            btsend.setEnabled(true); // enable SEND button only when connected

            String msg = "";
            while (!msg.equals("end")) {
                msg = dis.readUTF();
                txtchat.append("\n tam : " + msg.trim());
            }
        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables 
    private static javax.swing.JButton btsend; 
    private javax.swing.JMenuBar it; 
    private javax.swing.JMenuItem itOpen; 
    private javax.swing.JMenuItem itSaveAs; 
    private javax.swing.JMenu jMenu1; 
    private javax.swing.JMenu jMenu2; 
    private javax.swing.JPanel jPanel1; 
    private javax.swing.JScrollPane jScrollPane1; 
    private javax.swing.JScrollPane jScrollPane3; 
    private static javax.swing.JTextArea txtchat; 
    private static javax.swing.JTextArea txtmes1; 
    // End of variables declaration//GEN-END:variables 
}