import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
 
public class JDBCExample {
	private static final String SQL = "BEGIN TRANSACTION; INSERT INTO test.hotel_supplier(name) values ('test'); INSERT INTO test2.supplier_source (dept, supplier_id) VALUES ('test dept', currval('hotel_supplier_id_seq')); COMMIT;";


  
	public static void main(String[] argv) {
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 			e.printStackTrace();
			return;
		}
 		Connection connection = null;
		Statement stmt = null;
		try {
			connection = DriverManager.getConnection( "<JDBC connection string>", "<user name>", "<password>");
			connection.setAutoCommit(true);
			stmt = connection.createStatement();
			System.out.println("Update Count:"+ stmt.executeUpdate(SQL));

 
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}finally{
			//Close connection, ststement
		}
	}
 
}
