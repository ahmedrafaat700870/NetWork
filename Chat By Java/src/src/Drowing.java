import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Drowing  {
    // Start Functon Drowing Section //
    public static JFrame GlobalJfrm (int x , int y ) {
        JFrame j = new JFrame();
        j.setSize(x,y);
        j.setLayout(null);
        j.setVisible(true);
        return j ;
    }
    public static JButton GlobalButton (String name,int x, int y) {
        JButton b = new JButton(name);
        b.setLocation(x,y);
        b.setSize(100,40);
        return b ;
    }
    public static JButton SendData (String name,int x, int y) {
        JButton b = new JButton(name);
        b.setLocation(x,y);
        b.setSize(100,40);
        return b ;
    }
    public static JLabel MainLabel (String text , int x ,int y ,int LocatioX ,int LocatioY ,String FontName , int FontSize) {
        JLabel l = new JLabel(text);
        l.setLocation(LocatioX,LocatioY);
        l.setSize(x,y);
        l.setFont(new Font(FontName,Font.BOLD,FontSize));
        l.setBackground(Color.darkGray);
        l.setForeground(Color.black);
        l.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        l.setVerticalAlignment(SwingConstants.CENTER);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        return l ;
    }
    public static JLabel MainLabelChat (String text , int x ,int y ,int LocatioX ,int LocatioY ,String FontName , int FontSize) {
        JLabel l = new JLabel(text);
        l.setLocation(LocatioX,LocatioY);
        l.setSize(x,y);
        l.setFont(new Font(FontName,Font.BOLD,FontSize));
        l.setForeground(Color.black);
        l.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        l.setVerticalAlignment(SwingConstants.CENTER);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setBackground(Color.DARK_GRAY);
        l.setAutoscrolls(true);
        return l ;
    }
    public static JTextField MinaTextField ( int x ,int y ,int LocatioX ,int LocatioY ,String FontName , int FontSize)
    {
        JTextField t = new JTextField();
        t.setLocation(LocatioX,LocatioY);
        t.setSize(x,y);
        t.setFont(new Font(FontName,Font.BOLD,FontSize));
        t.setBackground(Color.white);
        t.setForeground(Color.black);
        //t.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        // t.setVerticalAlignment(SwingConstants.CENTER);
        t.setHorizontalAlignment(SwingConstants.CENTER);
        return t ;
    }
    public static JPasswordField MainPassowrdField (int x ,int y ,int LocatioX ,int LocatioY ,String FontName , int FontSize)
    {
        JPasswordField t = new JPasswordField();
        t.setLocation(LocatioX,LocatioY);
        t.setSize(x,y);
        t.setFont(new Font(FontName,Font.BOLD,FontSize));
        t.setBackground(Color.white);
        t.setForeground(Color.black);
        t.setHorizontalAlignment(SwingConstants.CENTER);
        return t ;
    }
    public static JPanel MainPanel (int x , int y , int LocationX , int LocationY ) {
        JPanel p = new JPanel();
        p.setSize(x,y);
        p.setLocation(LocationX,LocationY);
        return p;
    }
    public static JPanel chat (int x , int y , int LocationX , int LocationY ) {
        JPanel p = new JPanel();
        p.setSize(x,y);
        p.setBackground(Color.white);
        p.setLocation(LocationX,LocationY);
        p.setAutoscrolls(true);
        return p;
    }
    public static MenuBar MainMenu ()
    {
        MenuBar M = new MenuBar();
        Menu acount = new Menu("Acount");
        MenuItem i1 = MainMenuItemes("acount");
        MenuItem i2 =MainMenuItemes("EXIT");
        acount.add(i1);
        acount.add(i2);
        M.add(acount);
        Menu chat = new Menu("Chating");
        MenuItem i3 = MainMenuItemes("OnLine");
        MenuItem i4 = MainMenuItemes("All Frind");
        chat.add(i3);
        chat.add(i4);
        M.add(chat);
        return M;
    }
    public static MenuItem MainMenuItemes (String name)
    {
        MenuItem m = new MenuItem(name);
        return m ;
    }
    public static JList MainList (int x ,int y , int LocationX ,int LocationY)
    {
        JList l = new JList<>();
        l.setSize(x,y);
        l.setLocation(LocationX,LocationY);
        l.setAutoscrolls(true);
        return l;
    }
    // End Function Drowing Section //
}
