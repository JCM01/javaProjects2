package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VerCokies")
public class VerCokies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VerCokies() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		response.setContentType("text/html");
		
		Cookie[] cookies=request.getCookies();
		
		salida.append("<!DOCTYPE html>");
		salida.append("<html>");
		salida.append("<head>");
		salida.append("<meta charset='UTF-8'>");
		salida.append("<title>Web dinámica</title>");
		salida.append("</head>");
		salida.append("<body>");

		salida.append("<h1>¿Qué pasa contigo?</h1>");

		Cookie cookie;
		String texto="";
		
		for (int i=0; i<cookies.length; i++)	{
			cookie=cookies[i];
			texto=cookie.getName()+": ";
			texto=texto+cookie.getValue();
			salida.append("<p>"+texto+"</p>");
		}

		salida.append("</body>");
		salida.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
