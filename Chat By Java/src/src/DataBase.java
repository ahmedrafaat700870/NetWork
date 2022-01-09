import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public  static String [][] dataUsers = new String[][]{
            {"0","Ahmed","123","Offline"}, // {UserID , UserName , UserPassword , UserCoonection}
            {"1","Ali","123","Offline"},
            {"2","Mohamed","123","Offline"},
            {"3","Mando","123","OnLine"},
    };
    public  static String [][] dataFrind = new String[][]{
            {"0","Ali","1"},// {UserID , Frind name , ChatID }
            {"0","Mohamed","2"},
            {"0","Mando","3"},
            {"1","Ahmed","1"},
            {"1","Mohamed","4"},
            {"1","Mando","5"},
            {"2","Ahmed","2"},
            {"2","Ali","4"},
            {"2","Mando","6"},
            {"4","Ahmed","3"},
            {"4","Ali","5"},
            {"4","Mohamed","6"},
    };

}
