import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveResultFromSQLDatabase {

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
			// statement to handle parametric SQL statement
			// finally execute SQL command
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql = "SELECT * FROM officers";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			// to get first 10 results
			int count = 0;
			while(result.next() && count<10) {
				// can use either column number or column name
				// note column number starts from 1
				// getString method to convert database object to String type
				String staffId = result.getString(1);
				String name = result.getString("name");
				String workUnit = result.getString(3);
				String createBy = result.getString(4);
				String createDt = result.getString("create_dt");
				String activeStatus = result.getString(6);
				count++;
				System.out.println(staffId + " " + name + " " + workUnit + " " + activeStatus + " " + createBy + " " + createDt + " " + activeStatus);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Whoops, error!");
			e.printStackTrace();
		}
	}

}

