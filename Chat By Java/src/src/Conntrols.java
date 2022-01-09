import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
public class Conntrols extends DataBase{
    public static String UserID ;
    public static Desgining_Frames frames ;
    public static void clickLogin(JTextField UserName , JPasswordField Password, Socket socket , DataInputStream input , DataOutputStream output) throws Exception {
        String Error ;
        // check if TextField is Impty
        if (UserName.getText().equals("") || Password.getText().equals("")) {
            Error = "Enter All Fieldes !";
        } else
        {
            Error = "Done";
        }
        if (!Error.equals("Done")) {
            JOptionPane.showMessageDialog(null,Error,"Error",JOptionPane.ERROR_MESSAGE);
        } else {
            // start Connection
            socket = new Socket(InetAddress.getLocalHost(),4000);
            StartCoonectionLogIn(socket,input,output,UserName,Password);
        }
    }
    public static void StartCoonectionLogIn (Socket s , DataInputStream input , DataOutputStream output ,JTextField username , JPasswordField password) throws Exception{
        input = new DataInputStream(s.getInputStream());
        output = new DataOutputStream(s.getOutputStream());
        output.writeUTF(username.getText());
        output.writeUTF(password.getText());
        if (input.readBoolean()) {
            // then username && password is in dataBase .
            // then Strat Drwing next From .
            UserID = input.readUTF();

            frames.ReamovFram(frames.MainFram);
            frames.HomwFrames(UserID);
        } else {
            JOptionPane.showMessageDialog(null,"User Name Or Password not True !","Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
