package Login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import chat.Modify;
public class Server1 extends javax.swing.JFrame {

    static ServerSocket serverSocket;
    static Socket serverClientSocket;
    static DataInputStream serverInputStream;
    static DataOutputStream serverOutputStream;

    public Server1() {
        initComponents();
        this.getRootPane().setDefaultButton(btsend);
    }

    @SuppressWarnings("unchecked")
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
        btsend.addActionListener(evt -> btsendActionPerformed());

        txtmes1.setColumns(20);
        txtmes1.setRows(5);
        jScrollPane3.setViewportView(txtmes1);

        var jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
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
        itSaveAs.addActionListener(evt -> itSaveAsActionPerformed());
        jMenu1.add(itSaveAs);

        itOpen.setText("Open");
        itOpen.addActionListener(evt -> itOpenActionPerformed());
        jMenu1.add(itOpen);

        it.add(jMenu1);

        jMenu2.setText("Edit");
        it.add(jMenu2);

        setJMenuBar(it);

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
            serverOutputStream.writeUTF(txtmes1.getText().trim());
            txtchat.append("\n thinh: " + txtmes1.getText().trim());
            txtmes1.setText("");
        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void itSaveAsActionPerformed() {
        var jfc = new JFileChooser();
        var text = new FileNameExtensionFilter("text", "all");
        jfc.setFileFilter(text);
        jfc.setMultiSelectionEnabled(false);
        int x = jfc.showDialog(this, "Save");
        if (x == JFileChooser.APPROVE_OPTION) {
            Modify.saveAs(jfc.getSelectedFile().getPath(), txtchat.getText());
        }
    }

    private void itOpenActionPerformed() {
        var jfc = new JFileChooser();
        var text = new FileNameExtensionFilter("text", "txt", "text");
        jfc.setFileFilter(text);
        jfc.setMultiSelectionEnabled(false);

        int x = jfc.showDialog(this, "Open");
        if (x == JFileChooser.APPROVE_OPTION) {
            txtchat.setText(Modify.openFile(jfc.getSelectedFile().getPath()));
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new Server1().setVisible(true));

        try (var server = new ServerSocket(4444);
             var socket = server.accept();
             var dis = new DataInputStream(socket.getInputStream());
             var dos = new DataOutputStream(socket.getOutputStream())) {

            serverSocket = server;
            serverClientSocket = socket;
            serverInputStream = dis;
            serverOutputStream = dos;

            String message = "";
            while (!"end".equals(message)) {
                message = serverInputStream.readUTF();
                txtchat.append("\n Client: " + message.trim());
            }
        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
}
