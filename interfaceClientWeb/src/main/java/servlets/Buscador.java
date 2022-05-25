package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Buscador")
public class Buscador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteRMI cliente;
	
	public Buscador() {
        super();
        cliente = new ClienteRMI();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
				
		String valor = request.getParameter("valor");
		String por = request.getParameter("por");
		
		response.setContentType("text/html");
		salida.append("<!DOCTYPE html>");
		salida.append("<html>");
		salida.append("<head>");
		salida.append("<meta charset='UTF-8'>");
		salida.append("<title>Web dinámica</title>");
		salida.append("</head>");
		salida.append("<body>");
		salida.append("<h1>¿Qué pasa contigo?</h1>");
		salida.append(cliente.filtrar("Banda", "Queen"));
		salida.append("</body>");
		salida.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
