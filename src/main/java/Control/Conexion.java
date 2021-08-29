package Control;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion {
	public static Connection getConexion() throws ClassNotFoundException{
		
		
		try {
			
			 Class.forName("com.mysql.jdbc.Driver");
			 String url, userName, password;
	            /*
	            en algunas ocaciones el tipo de driver ya tiene precargado el puerto de 
	            comunicacion y es por ello que nos manda el error del driver
	            url = "jdbc:mysql://localhost/registro5sis2a";
	            */
	            url = "jdbc:mysql://localhost/medicos";
	            userName="root";
	            password="3541Cr0104A";
	            return (Connection) DriverManager.getConnection(url, userName, password);
	            
	          //  System.out.println("Conexion Exitosa");
	            
		}catch(SQLException e){
			System.out.println("Error al conectar la base de datos");
			System.out.println(e.getMessage());
		}
		return null;
	}

}
