import java.net.*;
import java.net.Socket;
import java.io.*;
import java.util.Scanner;
// test https://www.google.com
public class Server {
    public static void main(String[] args) throws Exception {
        Scanner write = new Scanner (System.in);
        System.out.println("Enter URL ? ");
        String url = write.nextLine();
        ConnetToInterNet(url);
    }
    public static void ConnetToInterNet(String url) throws Exception{
        BufferedReader br = null ;
        URL my_URL = new URL(url);
        URLConnection connect = my_URL.openConnection();
        InputStreamReader isr = new InputStreamReader(connect.getInputStream());
        br = new BufferedReader(isr);
        saveDataInHtmlFile(br);
        br.close();
        System.exit(1);
    }
    public static void saveDataInHtmlFile(BufferedReader input) throws Exception {
        FileWriter file = new FileWriter("H:\\colog\\NetWork\\Taskes\\File.html");
        while (input.readLine() != null) {
            try {
            file.write(input.readLine());
             } catch (Exception e) {
              System.out.println(e);
             }
        }
        file.close();
    }
}
