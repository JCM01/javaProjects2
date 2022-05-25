package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		description = "Servlet que nos dice hola", 
		urlPatterns = { "/Perico" }, 
		initParams = { 
				@WebInitParam(name = "Autor", value = "Amelia"), 
				@WebInitParam(name = "Fecha", value = "nov-2021")
		})
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String autor;
	private String fecha;
       
    public HolaMundo() {
        super();
        System.out.println("1. Construir");        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		response.setContentType("text/html");
		String n = request.getParameter("nombre");
		
		HttpSession sesion=request.getSession(true);

		salida.append("<!DOCTYPE html>");
		salida.append("<html>");
		salida.append("<head>");
		salida.append("<meta charset='UTF-8'>");
		salida.append("<title>Web dinámica</title>");
		salida.append("</head>");
		salida.append("<body>");
		salida.append("Hola "+n);
		salida.append("<h1>¿Qué pasa contigo?</h1>");
		
		salida.append("<a href='VerCokies?nombre="+n+
				"'>Ver Cookies</a>");
		
		salida.append("<h1>Autor: "+autor+"</h1>");
		salida.append("<h1>Fecha: "+fecha+"</h1>");
		salida.append("<h1>Identificador de sesión: "+
				sesion.getId()+"</h1>");
		salida.append("</body>");
		salida.append("</html>");
		System.out.println("4. doGet atiende la petición");
		
		String metodo=request.getMethod();
		System.out.println("Método del requerimiento: "+metodo);
		String direccion=request.getRequestURI();
		System.out.println("Dirección: "+direccion);
		String protocolo=request.getProtocol();
		System.out.println("Protocolo: "+protocolo);
		
		Enumeration<String> nombres=request.getHeaderNames();
		while (nombres.hasMoreElements()) 	{
			String nom=(String) nombres.nextElement();
			System.out.println(nom+": "+request.getHeader(nom));
		}
		
		
		Cookie cookie1=new Cookie("Cookie1","Cookie-Una");
		Cookie cookie2=new Cookie("Cookie2","Cookie-Dos");
		
		cookie1.setMaxAge(3600); // Una hora
		cookie2.setMaxAge(3600);
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		System.out.println("Se han guardado las dos cookies");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("3. Service analiza la petición y llama a doGet o doPost");
        super.service(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		autor = config.getInitParameter("Autor");
		fecha = config.getInitParameter("Fecha");		
		System.out.println("2. Inicializar");
	}
}
