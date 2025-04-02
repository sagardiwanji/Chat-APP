package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends javax.swing.JFrame {

    static Socket clientSocket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;

    public Client() {
        initComponents();
        this.getRootPane().setDefaultButton(btsend);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtchat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtmes = new javax.swing.JTextArea();
        btsend = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("tam");

        txtchat.setEditable(false);
        txtchat.setColumns(20);
        txtchat.setRows(5);
        jScrollPane1.setViewportView(txtchat);

        txtmes.setColumns(20);
        txtmes.setRows(5);
        jScrollPane2.setViewportView(txtmes);

        btsend.setText("SEND");
        btsend.addActionListener(evt -> btsendActionPerformed());

        var jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(btsend, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btsend, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                    .addGap(0, 4, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        var layout = new javax.swing.GroupLayout(getContentPane());
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
    }

    private void btsendActionPerformed() {
        try {
            outputStream.writeUTF(txtmes.getText().trim());
            txtchat.append("\n tam: " + txtmes.getText().trim());
            txtmes.setText("");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new Client().setVisible(true));

        try (var socket = new Socket("127.0.0.1", 4444);
             var dis = new DataInputStream(socket.getInputStream());
             var dos = new DataOutputStream(socket.getOutputStream())) {

            clientSocket = socket;
            inputStream = dis;
            outputStream = dos;

            String message = "";
            while (!"end".equals(message)) {
                message = inputStream.readUTF();
                txtchat.append("\n thinh: " + message.trim());
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static javax.swing.JButton btsend;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea txtchat;
    private static javax.swing.JTextArea txtmes;
}
