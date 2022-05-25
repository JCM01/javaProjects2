


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
	
public class ConexionMySQL {
		private static Scanner lector;
		private static Connection con;
		private static ResultSet rs;
		private static Statement sentencia= null;
		
	public static void main(String[] args) throws SQLException  {
		lector = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.println("Se ha cargado el Driver de MySQL");
		
	
		String cadenaConexion = "jdbc:mysql://localhost:3306/HITO2T";
		String user = "root";
		String pass = "curso";
		
		try {
			con = DriverManager.getConnection(cadenaConexion, user, pass);
			sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha establecido la conexión con la Base de datos");
		String opc = "";
		
		do {
			System.out.println("1. Generar nuevos triangulos");
			System.out.println("2. Mostrar todos los triángulos indicando su tipo");
			System.out.println("3. Contar equiláteros, isósceles y escalenos");
			System.out.println("4. Fin del programa.");
			System.out.println("¿Que opción eliges del 1 al 4?");
			opc = lector.nextLine();
			switch (opc) {
			case "1":
				opcion1();
				break;
			case "2":
				opcion2();
				break;
			case "3":
				opcion3();
				break;
			case "4":
				System.out.println("Fin del programa");
				try {
					rs.close();
					con.close();
				} catch (SQLException e) {
					System.out.println("No se ha podido cerrar la conexión con la BD");
					System.out.println(e.getMessage());
					return;
				}
				System.out.println("Se ha cerrado la base de datos");

				break;
			default:
				System.out.println("Opción incorrecta");
			}
		}while (!opc.equals("4"));
	}
		
	

private static void opcion1() {
		
	try {
		CallableStatement llamada = con.prepareCall("call crearTriangulos()");
		llamada.executeUpdate();
		llamada.close();
	} catch (SQLException e) {
		System.out.println("Error al crear los triangulos");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}
		
private static void opcion2() {
					
	try {
		sentencia = con.createStatement();
		rs = sentencia.executeQuery("SELECT *, tipoTriangulo(LADO1,LADO2,LADO3)AS TIPO FROM TRIANGULOS");
		while (rs.next()) {
			
			System.out.print("Triangulo con lados "+rs.getString("lado1")+" , "+rs.getString("lado2")+" y "+rs.getString("lado3")+". Clasificación del triangulo es: "+rs.getString("TIPO"));
			System.out.println("\n");
			System.out.println();// Retorno de carro
		}
	} catch (SQLException e1) {
		System.out.println("Error al mostrar los triangulos");
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}			
	private static void opcion3() {
		int contadorEqui=0;
		int contadorIso=0;
		int contadorEsc=0;
		
		try {
			sentencia = con.createStatement();
			rs = sentencia.executeQuery("SELECT *, tipoTriangulo(LADO1,LADO2,LADO3)AS TIPO FROM TRIANGULOS");
			while (rs.next()) {
				
				if (rs.getString("TIPO").equals("Equilatero")) {
					contadorEqui=contadorEqui+1;
				} else {
					
					if (rs.getString("TIPO").equals("Isosceles")) {
						contadorIso= contadorIso+1;
					} else {
						contadorEsc= contadorEsc+1;
					}
				}
			}
			
			System.out.println("La cantidad de triangulos equilateros = "+contadorEqui);
			System.out.println("La cantidad de triangulos isosceles = "+contadorIso);
			System.out.println("La cantidad de triangulos escalenos = "+contadorEsc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}




