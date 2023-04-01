
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	private static Connection con = null;
	
	public static Connection getConn() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sundar","root","Sundar0129Sowmiya");
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
}
