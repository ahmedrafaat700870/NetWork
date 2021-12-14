import java.net.*;
import java.util.*;
import java.io.*;
public class Server_ extends Thread {
    Socket socket ;
    DataInputStream input ;
    DataOutputStream output ;
    Scanner write = new Scanner (System.in);
    Server_ (Socket s) throws Exception {
        socket = s ;
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }
    @Override 
    public void run() {
        String [] data= new String[2];
        data[0] = "";
        data[1] = "";
        Boolean done = false ;
        try {
            do {
                String UserName = input.readUTF();
                String password = input.readUTF();
                if (UserName.equals(data[0]) && password.equals(data[1])) {
                    done = true ;
                }
                output.writeBoolean(done);
            } while(!done);
            System.out.println("Step One");
            input.close();
            output.close();
            socket.close();
        } catch(Exception e) {}
    }
}
