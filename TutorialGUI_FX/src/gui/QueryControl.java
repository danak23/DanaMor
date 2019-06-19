package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//Class to retrive information from data base with sql queries.
public class QueryControl {
	static ArrayList<String> customerDetails=new ArrayList<String>();
	public static void newTableInfo(String name,String surname,String email,String tel,String password,String userName)
	{
	try 
	{
		int permissionClient=2; //Costumer permissions only code.
		Statement stmt = MysqlConnector.conn.createStatement();
		int rs=stmt.executeUpdate("INSERT INTO customer(permission_id,user_name,password,first_name,last_name,email,phone_number)"
				+"VALUES ('"+permissionClient+"','"+userName+"','"+password+"','"+name+"','"+surname+"','"+email+"','"+tel+"');");
	//	permissionClient++;//Update client permission.
		//Customer permission=1 Manager Permission=2 Employee permission=3.
	} catch (SQLException e) {e.getMessage();}
	}
	public static void login(String name,String password)
	{
		try 
		{
			Statement stmt = MysqlConnector.conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT user_name,password FROM customer WHERE user_name='"+name+"';");
			rs.next();
			String Uname=rs.getString(1);
			System.out.println(Uname);
			//Not unique check password
			String Password=rs.getString(2);
			if(!(Password.equals(password)))
			{
				throw new Exception();
			}
			rs.close();
		} catch (SQLException e) {//pop up window for wrong input 
			System.out.print("user!!!!!");}
		catch(Exception e) {
			System.out.print("password doesnt match!!");
		}
		}
	public static ArrayList<String> CustomerCard(String name)
	{
		int i;
		try 
		{
			Statement stmt = MysqlConnector.conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT userId,first_name,last_name,email,phone_number \r\n" + 
					"FROM `customer`\r\n" + 
					"WHERE first_name='"+name+"';");
			rs.next();
			for(i=1;i<6;i++)
			{
				customerDetails.add(rs.getString(i));
			}
			rs.close();
		} catch (SQLException e) {//pop up window for wrong input 
			System.out.print("user!!!!!");}
		return customerDetails;
	}
	public  static String getCustomerId()
	{
		return customerDetails.get(0);
	}
		public static ArrayList<String> purchaseHistory(String id)
		{
			ArrayList<String> PurchaseHistory=new ArrayList<String>();
			ArrayList<String> PurchaseHistoryTotal=new ArrayList<String>();
			try 
			{
				Statement stmt = MysqlConnector.conn.createStatement();
				ResultSet rs=stmt.executeQuery("SELECT DISTINCT city_name,purchase_type,purchase_date \r\n" + 
						"FROM citypurchases,customer \r\n" + 
						"WHERE citypurchases.user_id='"+getCustomerId()+"';");
				while(rs.next())
				{
					for(int i=1;i<4;i++)
					{
						PurchaseHistory.add(rs.getString(i));
					}
					PurchaseHistoryTotal.addAll(PurchaseHistory);
					PurchaseHistory.removeAll(PurchaseHistory);
				}
				rs.close();
			} catch (SQLException e) {//pop up window for wrong input 
				System.out.print("user!!!!!");}
			return PurchaseHistoryTotal;
		}
		public static void newTableInfoPayment(String creditNum,String expDate,String cvv)
		{
		try 
		{
			Statement stmt = MysqlConnector.conn.createStatement();
			stmt.executeUpdate("INSERT INTO PaymentForm( `credit_id`, `Exp. date`, `cvv`)"
					+"VALUES ('"+creditNum+"','"+expDate+"','"+cvv+"');");			
		} catch (SQLException e) {e.printStackTrace();}
		}
	}

