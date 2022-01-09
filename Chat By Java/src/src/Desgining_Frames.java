import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Desgining_Frames extends Drowing {
    public static DataBase data = new DataBase();
    public static Conntrols con = new Conntrols();
    public static Socket socket;
    public static DataInputStream input;
    public static DataOutputStream output;
    public static JFrame MainFram = GlobalJfrm(500, 400);
    public static JFrame HomeFram;

    public static void ReamovFram(JFrame f) {
        f.dispose();
    }

    public static void MainFrmaes() throws Exception {
        JButton MainButton = GlobalButton("LogIn", 150, 300);
        JLabel LoginHeader = MainLabel("LogIn", 100, 50, 150, 20, "serif", 20);
        JLabel UsernameLanbel = MainLabel("User Name", 100, 30, 20, 100, "serif", 12);
        JLabel passwordLabel = MainLabel("Password", 100, 30, 20, 200, "serif", 12);
        JTextField UserName = MinaTextField(200, 30, 150, 100, "serif", 12);
        JPasswordField Password = MainPassowrdField(200, 30, 150, 200, "serif", 12);
        MainFram.add(MainButton);
        MainFram.add(LoginHeader);
        MainFram.add(UsernameLanbel);
        MainFram.add(passwordLabel);
        MainFram.add(UserName);
        MainFram.add(Password);
        MainButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con.clickLogin(UserName, Password, socket, input, output);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    ;

    public static void HomwFrames(String userId) throws Exception {
        HomeFram = GlobalJfrm(1000, 800);
        HomeFram.setLayout(null);
        HomeFram.setVisible(true);
        MenuBar m = MainMenu();
        JPanel HomePanel = MainPanel(1000, 600, 500, 400);
        HomeFram.add(HomePanel);
        HomeFram.setMenuBar(m);
        m.getMenu(0).getItem(0).addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Acount_Clicked();
            }
        });
        m.getMenu(0).getItem(1).addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EXIT_Clicked();
            }
        });
        m.getMenu(1).getItem(0).addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnLine_Clicked(userId);
            }
        });
        m.getMenu(1).getItem(1).addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frind_Clicked(userId);
            }
        });
    }

    public static void Acount_Clicked() {
        JOptionPane.showMessageDialog(null, "Count Data", "Data", JOptionPane.ERROR_MESSAGE);
    }

    ;

    public static void EXIT_Clicked() {
        System.exit(1);
    }

    ;

    public static void OnLine_Clicked(String userID) {
        int counter = 0;
        JList li = MainList(400, 500, 500, 150);
        HomeFram.add(MainLabel("OnLine Friend", 200, 50, 400, 50, "serif", 20));
        String[] userFrind;
        for (int i = 0; i < data.dataUsers.length; i++) {
            userFrind = data.dataUsers[i];
            JButton l;
            if (userFrind[0].equals(userID)) {
                if (checkOnLine(userFrind[0])) {
                    l = GlobalButton(data.dataUsers[Integer.parseInt(frindOnLineID)][1], 100, 150 + counter);
                    l.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            li.removeAll();
                            HomeFram.add(li);
                            ChatID = getChatID(userID, l.getText());
                            if (ChatID != "-1") {
                                try {
                                    readFile(ChatID, li);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                JTextField text = MinaTextField(200, 30, 100, 400, "serif", 12);
                                JButton btn = GlobalButton("Send", 100, 500);
                                HomeFram.add(text);
                                HomeFram.add(btn);
                                btn.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // write in file .
                                        if (!text.getText().equals(""))
                                        {
                                            try {
                                                WriteinFile(text.getText(),ChatID);
                                                readFile(ChatID, li);
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    }
                                });

                            }
                        }
                    });
                    HomeFram.add(l);
                    counter += 70;
                }
            }
        }
    };
    public static String frindOnLineID;
    public static String ChatID;

    public static void Frind_Clicked(String userID) {
        int counter = 0;
        JList li = MainList(400, 500, 500, 150);
        HomeFram.add(MainLabel("OffLine Friend Friend", 200, 50, 400, 50, "serif", 20));
        String[] userFrind;
        for (int i = 0; i < data.dataFrind.length; i++) {
            userFrind = data.dataFrind[i];
            JButton l;
            if (userFrind[0].equals(userID)) {
                if (AllFriend(userID)) {
                    l = GlobalButton(data.dataUsers[Integer.parseInt(frindOnLineID)][1], 100, 150 + counter);
                    l.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            li.removeAll();
                            HomeFram.add(li);
                            ChatID = getChatID(userID, l.getText());
                            if (ChatID != "-1") {
                                try {
                                    readFile(ChatID, li);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                JTextField text = MinaTextField(200, 30, 100, 400, "serif", 12);
                                JButton btn = GlobalButton("Send", 100, 500);
                                HomeFram.add(text);
                                HomeFram.add(btn);
                                btn.addActionListener(new AbstractAction() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // write in file .
                                        if (!text.getText().equals(""))
                                        {
                                            try {
                                                WriteinFile(text.getText(),ChatID);
                                                readFile(ChatID, li);
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    }
                                });

                            }
                        }
                    });
                    HomeFram.add(l);
                    counter += 70;
                }
            }
        }
    }

    ;

    public static boolean checkOnLine(String id) {
        String getdata[];
        for (int i = 0; i < data.dataUsers.length; i++) {
            getdata = data.dataUsers[i];
            if (getdata[3].equals("OnLine")) {
                frindOnLineID = getdata[0];
                return true;
            }
        }
        return false;
    }
    public static int count = 0;
    public static boolean AllFriend(String id) {
        String getdata[];
        getdata = data.dataUsers[count];
        if (!getdata[0].equals(frindOnLineID))
        {
            frindOnLineID = getdata[0];
            count++;
            return true;
        }
        count++;
        return false;
    }


    public static String getChatID(String id, String frindName) {
        String getdata[];
        System.out.println(id + "   " + frindName);
        for (int i = 0; i < data.dataFrind.length; i++) {
            getdata = data.dataFrind[i];
            if (getdata[0].equals(id)) {
                if (getdata[1].equals(frindName)) {
                    return getdata[2];
                }
            }
        }
        return "-1";
    }

    public static void readFile(String FileID, JList list) throws Exception {
        list.removeAll();
        String path = "H:\\colog\\projetNetWork\\Chat_Files\\" + FileID + ".txt";
        File myObj = new File(path);
        Scanner myReader = new Scanner(myObj);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            list.add(MainLabelChat(data, 300, 40, 0, 0 + counter, "serif", 10));
            counter += 50;
            System.out.println(data);
        }
        myReader.close();
    }

    public static void WriteinFile(String newLine, String FileID) throws Exception{
        // write in file .
        String path = "H:\\colog\\projetNetWork\\Chat_Files\\" + FileID + ".txt";
        File log = new File(path);
        try{
            if(!log.exists()){
                System.out.println("We had to make a new file.");
                log.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(log, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(newLine + "\n");
            bufferedWriter.close();
        } catch(IOException e) {
            System.out.println("COULD NOT LOG!!");
        }
    }
}
