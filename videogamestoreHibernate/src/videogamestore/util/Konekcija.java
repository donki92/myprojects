package videogamestore.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Konekcija 
{
    private static Connection kon=null;
    public static Connection poveziSe() throws SQLException
    {
        if(kon==null) kon = DriverManager.getConnection
        ("jdbc:mysql://localhost/trafika", "root", "spomenka");
        return kon;
    } 
    private Konekcija() {
    }   
}
