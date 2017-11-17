
package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLLITE {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
        
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
        
        query =	"CREATE	TABLE IF NOT EXISTS MAIL2 ('Id' INTEGER PRIMARY KEY AUTOINCREMENT , 'Mail' TEXT NOT NULL);";
        statement.execute(query);
       
        // Bucle actualizacion de datos
        
        String fileString = "/Users/Entrar/Desktop/emails.txt";
        
        BufferedReader reader = new BufferedReader(new FileReader(new File (fileString)));
        String mail;
        
        while ((mail = reader.readLine()) != null){
            if(!mail.contains("@")) continue;
            query = "INSERT INTO MAIL2 (mail) VALUES ('" + mail +"')";
            statement.executeUpdate(query);
        }
        
        rs.close();
        statement.close();
        connection.close();
        
    }
    
}
