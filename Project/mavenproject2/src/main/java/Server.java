
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends javax.swing.JFrame {
    public Server() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Start_Connection = new javax.swing.JButton();
        Show = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListData = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Start_Connection.setText("Start Connection");
        Start_Connection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Start_ConnectionMouseClicked(evt);
            }
        });

        Show.setText("Show Data");
        Show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShowMouseClicked(evt);
            }
        });

        ListData.setColumns(20);
        ListData.setRows(5);
        ListData.setEnabled(false);
        jScrollPane1.setViewportView(ListData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(Start_Connection)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Show)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Start_Connection)
                    .addComponent(Show))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private static ArrayList<String>List = new ArrayList<>();
    public static void setList(String str) {
        List.add(str);
    }
    public static ArrayList<String> getList() {
        return List;
    }
    public static File file ;
    public static String Path = "H:\\colog\\NetWork\\Project\\file.txt";
    private void ShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowMouseClicked
        try {
            ShowData();
        } catch (Exception e) {}
    }//GEN-LAST:event_ShowMouseClicked

    private void Start_ConnectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Start_ConnectionMouseClicked
        // TODO add your handling code here:
        try {
            //List.clear();
            //My_File = new FileWriter(Path);
            server_run() ;
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Start_ConnectionMouseClicked
    public ArrayList<String>MyList = new ArrayList<>();    
    void server_run () throws Exception {
        ServerSocket s = new ServerSocket(4000);
        //do {
            Socket server = s.accept();
            Server_ t1 = new Server_(server);
            t1.start();
        //} while (true);
    }
    public void ShowData() throws Exception {
        file = new File("H:\\colog\\NetWork\\Project\\file.txt");
        Scanner get = new Scanner (file);
        String str = ListData.getText();
        while(get.hasNextLine()) {
            ListData.setText("");
            ListData.setText(str+ "\n" + get.nextLine());
            str = ListData.getText();
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }
    public void setListData(String data) {
        ListData.setText(data);
    }
    public static javax.swing.JTextArea ListDataDemo ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ListData;
    private javax.swing.JButton Show;
    private javax.swing.JButton Start_Connection;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

