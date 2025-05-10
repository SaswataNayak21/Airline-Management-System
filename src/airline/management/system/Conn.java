package airline.management.system;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //Step - 1 is to register the driver to th JDBC jar file
            c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "saswatanayak");//step - 2 create the connection string 
            s = c.createStatement();//step - 3 create the statement
                    
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
