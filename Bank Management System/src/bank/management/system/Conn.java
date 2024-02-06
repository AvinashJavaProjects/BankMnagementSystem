package bank.management.system;
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try{
            //registering the drivers
            //Class.forName(com.mysql.cj.jadbc.Drivers); 
            //creating connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Avi-1234");
            //creating statement
            s = c.createStatement();
        } catch(Exception e){
            
        }
    }

}
