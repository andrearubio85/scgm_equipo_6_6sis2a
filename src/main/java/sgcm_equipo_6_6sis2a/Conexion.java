package sgcm_equipo_6_6sis2a;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Conexion
 */
@WebServlet("/Conexion")
public class Conexion extends HttpServlet {
	private Connection con;
    private Statement set;
    private ResultSet rs;
    
    public void init(ServletConfig cfg) throws ServletException{
        //el constructor nos va ayudar a conectarnos con l bd
        
        String url = "jdbc:mysql://localhost/medicos";
                    //tipodriver:gestorbd:puerto//IP/nombrebd
                    
        String userName = "root";
        String password = "3541Cr0104A";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            /*
            en algunas ocaciones el tipo de driver ya tiene precargado el puerto de 
            comunicacion y es por ello que nos manda el error del driver
            url = "jdbc:mysql://localhost/registro5sis2a";
            */
            url = "jdbc:mysql://localhost/medicos";
            con = DriverManager.getConnection(url, userName, password);
            set = con.createStatement();
            
            System.out.println("Conexion Exitosa");
        
        }catch(Exception e){
            
            System.out.println("Conexion no Exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
