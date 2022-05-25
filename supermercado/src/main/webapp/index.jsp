<%@ page import="com.supermercado.LogicaBD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.supermercado.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prueba JSP</title>
</head>
<body>

	<%
		ArrayList<String> nombres = new ArrayList<String>();
		nombres.add("Lucas");
		nombres.add("Rosa");
		nombres.add("Miguel");
		nombres.add("Armando");
		nombres.add("Sol");
		pageContext.setAttribute("lista", nombres);
	%>





<c:set var="azar" value="${Math.random()}" />
	<p>Generado número al azar: ${azar}</p>
	
	<c:if test="${azar>0.5}">
		<h1>Vas a tener un buen día</h1>
	</c:if>
	<c:if test="${azar<=0.5}">
		<h1>Vas a tener un mal día</h1>
	</c:if>
	
	<c:forEach var="i" begin="1" end="15" step="2">
    	<p>Item <c:out value="${i}" /></p>
	</c:forEach>
	
	
	

<%
	List<Producto> lista = LogicaBD.listaProductos();
	pageContext.setAttribute("productos", "lista");
%>
<h1><%=Math.PI %></h1>
<h1><%=session.getId() %></h1>


<ul>
<%
	for (Producto p : lista) {
%>
<li>
<%=p.getNombre() %>
</li>
<%
	}
%>

	<c:forEach items="${lista}" var="n">
		<p><c:out value="${n}" /></p>
	</c:forEach>

</ul>
</body>
</html>

