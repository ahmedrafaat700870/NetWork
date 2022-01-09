import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClinetHendlerConntrols extends DataBase{
    public static String UserID;
    public static void checkLogin (Socket socket , DataInputStream input , DataOutputStream output ) throws Exception{
        Boolean done ;
        do {
            done = checkUserNameAndPassWord(input.readUTF(),input.readUTF()); // get Username && Password .
            output.writeBoolean(done);
            if (done) {
                output.writeUTF(UserID);
            }
        } while (true);
    }
    public static Boolean checkUserNameAndPassWord(String userName , String Pawword ) {
        // function check if User Name And Passwod in DataBase or not .
        // if find it then getID .
        Boolean connect = false ;
        for (int i = 0 ; i< dataUsers.length ; i++) {
            if (userName.equals(dataUsers[i][1]) && Pawword.equals(dataUsers[i][2])) {
                connect = true ;
                UserID = dataUsers[i][0];
                dataUsers[i][3] = "ONLine";
                System.out.println(DataBase.dataUsers[i][3]);
                DataBase x = new DataBase();
                System.out.println(x.dataUsers[i][3]);
                break;
            }
        }
        return connect;
    }
}
