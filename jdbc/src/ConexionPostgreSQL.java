
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionPostgreSQL {

	public static void main(String[] args) {
		connectDatabase();
	}

	public static void connectDatabase() {
		try {

			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
			}

			Connection connection = null;

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HITO2T", "openpg", "openpgpwd");

			boolean valid = connection.isValid(50000);
			System.out.println(valid ? "TEST OK" : "TEST FAIL");

			try {
				
				Statement stmt = null;
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM \"calificacion\"");
				while (rs.next()) {
					
					
					int sumaNotas = 0;
					
					Array calificaciones = rs.getArray("calificaciones");
					Integer notas[] = (Integer[]) calificaciones.getArray();
					System.out.println(rs.getString("alumno"));

					for (int n : notas) {
						sumaNotas = sumaNotas + n;

					}
					System.out.println("La media de las notas son: " + sumaNotas/notas.length);
				}

			} catch (SQLException e1) {
				System.out.println("Error al realizar el listado de productos");
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (java.sql.SQLException sqle) {
			System.out.println("Error: " + sqle);
		}
	}

}