package sgcm_equipo_6_6sis2a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registro_paciente
 */
@WebServlet("/Registro_paciente")
public class Registro_paciente extends HttpServlet {

       Conexion op = new Conexion();
     
    /**
     * @see HttpServlet#HttpServlet()
     */
	 protected void processRequest(HttpServletRequest request, 
	            HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            
	            //vamos a obtener los parametros
	            String nom, appat, apmat, fechanac, curp;
	            int tel;
	            
	            nom = request.getParameter("nombre_pac");
	            appat = request.getParameter("appat_pac");
	            apmat = request.getParameter("apmat_pac");
	            tel = Integer.parseInt(request.getParameter("tel_pac"));
	            fechanac = request.getParameter("fechanac_pac");
	            curp = request.getParameter(curp);
	            
	            try{
	                //vamos a intentar insertar los datos
	                //si es cadena "valor1", si numerico 'valor2' o valor2
	                
	                String q = "insert into MPaciente "
	                        + "(nombre_pac, appat_pac, apmat_pac, fechanac_pac, tel_pac, CURP) "
	                        + "values "
	                        + "('"+nom+"', '"+appat+"', '"+apmat+"', "+tel+", '"+fechanac+"', "+curp+"')";
	                
	                
	                set.executeUpdate(q);
	                System.out.println("Registro Paciente");
	            
	            
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Novena- Health & Care Medical</title>");  
	            out.println("<link rel='stylesheet' href='web.css'/>");
	            out.println("</head>");
	            out.println("<body>"
	                    + "El nombre es: " + nom
	                    + "<br>"
	                    + "El apellido paterno es: " + appat
	                    + "<br>"
	                    + "El apellido materno es: " + apmat
	                    + "<br>"
	                    + "Telefono: " + tel
	                    + "<br>"
	                    + "Fecha de nacimiento: " + fechanac
	                    + "<br>"
	                    + "Fecha de nacimiento: " + curp
	                    + "<br>");
	            out.println("<h1>Registro Exitoso</h1>"
	                    + "<a href='index.html' >Regresar al Menu Principal</a>"
	                    + "<br>"
	                    + "<a href='Consultar' > Consultar Tabla General de Usuarios </a>");
	            out.println("</body>");
	            out.println("</html>");
	            
	            }catch(Exception e){
	                System.out.println("Error al registrar en la tabla");
	                System.out.println(e.getMessage());
	                System.out.println(e.getStackTrace());
	                
	                out.println("<!DOCTYPE html>");
	                out.println("<html>");
	                out.println("<head>");
	                out.println("<title>Servlet Regitro</title>");      
	                out.println("<link rel='stylesheet' href='web.css'/>");
	                out.println("</head>");
	                out.println("<body>"
	                        + "<br>");
	                out.println("<h1>Registro No fue exitoso</h1>"
	                    + "<a href='inicio.html' >Regresar al Menu Principal</a>"
	                        + "<br>");
	                out.println("</body>");
	                out.println("</html>");
	            
	            }
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
