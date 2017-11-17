
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLLITE {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        Class.forName("org.sqlite.JDBC");
        String urlConection = "jdbc:sqlite:/Users/Entrar/Desktop/kata5.db";
        Connection connection = DriverManager.getConnection(urlConection);
        
        Statement statement = connection.createStatement();
        String query = "Select * from PEOPLE";
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
        }
        
    }
    
}
