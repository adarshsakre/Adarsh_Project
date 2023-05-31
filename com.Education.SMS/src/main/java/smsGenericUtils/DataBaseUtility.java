package smsGenericUtils;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataBaseUtility {
	
	static Driver driver;
	static java.sql.Connection Connection;
	static ResultSet result;
	/**
	 * This method will Perform the mysql database connection
	 * @throws SQLException
	 */
	public void connectDB() throws SQLException
	{
		try
		{
			com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver((java.sql.Driver) driver);
			Connection=DriverManager.getConnection(IpathConstants.mySQLUrl,IpathConstants.mysqlUsername,IpathConstants.mysqlPassword);
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will close the mysql database
	 */
	public void closeDB()
	{
		try
		{
			Connection.close();
			
		} catch (Exception e)
		{
			
		}
	}
	/**
	 * This method will execute the query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException
	{
		result=Connection.createStatement().executeQuery(query);
		return result;
	}
	/**
	 * This method will execute the query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public int executeUpdate(String query) throws SQLException
	{
		int result=Connection.createStatement().executeUpdate(query);
		return result;
	}
	/**
	 * This method will execute query based on query and it will verify the data
	 * @param query
	 * @param columnindex
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public boolean  executeQueryAndVerify(String query,int columnindex,String expectedData) throws SQLException
	{
		boolean flag=false;
		result=Connection.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnindex).equals(expectedData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expectedData+"==>Data is verified in the data base table");
			return flag;
		}
		else
		{
			System.out.println(expectedData+"==>Data is not verified in the database");
			return flag;
		}
	}
	

}
