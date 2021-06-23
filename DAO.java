//DAO (Data Accessible Object)

import java.sql.*;

class DAO
{
	public static Connection createConnection()
	{
		Connection con = null;

		try
		{
			//step1
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//step2
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sanjana");
		}
		catch(Exception e)
		{}

		return con;
	}
}