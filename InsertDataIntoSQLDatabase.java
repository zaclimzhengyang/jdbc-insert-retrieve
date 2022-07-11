import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataIntoSQLDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// insert url of database / schema that user wants to connect to
		// insert username, by default root, and password
		String url = "jdbc:mysql://localhost:3306/<schema_name>";
		String username = "<username>";
		String password = "<password>";

		// must implement try, catch, or else throws SQLException
		try {
			// use getConnection method to connect to database / schema
			// declare SQL command
			// PreparedStatement to handle parametric SQL statement
			// finally execute SQL command
			// ? serves as parameter holders
			Connection connection = DriverManager.getConnection(url, username, password);
//			System.out.println("Connected to the database successfully.");
			String sql = "insert into officers (staff_id, name, work_unit, create_by, create_dt, active_status) "
					+ "values (?, ?, ?,?,?, ?)";	
			PreparedStatement statement = connection.prepareStatement(sql);
			// note column number starts from 1
			statement.setString(1, "10001");
			statement.setString(2, "Jeff");
			statement.setString(3, "HQ");
			statement.setString(4, "Engineer");
			statement.setString(5, "2022-07-21 23:16:13");
			statement.setString(6, "null");
			// executeUpdate returns the number of rows affected by the execution of the SQL statement
			int rows = statement.executeUpdate();
			System.out.println(rows);
//			if(rows>0) {
//				System.out.println("A row has been inserted.");
//			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Whoops, error!");
			e.printStackTrace();
		}
	}

}
