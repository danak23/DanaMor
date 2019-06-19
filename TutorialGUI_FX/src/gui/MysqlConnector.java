package gui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Separate class for connection to Data base.
//Helps to configure if error yields from DB connection.
public class MysqlConnector {
	static Connection conn;
	public  MysqlConnector(){
	try 
	{
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    } catch (Exception ex) {/* handle the error*/}
    
    try 
    {
    	String ID=null;
        conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com/Jspgi5caWa?serverTimezone=IST","Jspgi5caWa","TCjRU55l7R");
        System.out.println("SQL connection succeed"); 
 	} catch (SQLException ex) 
 	    {/* handle any errors*/
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
        }
}
}
