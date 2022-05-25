<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>

<sql:setDataSource var="dataSource" driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost/supermercado" user="root" password="curso" />

<sql:query dataSource="${dataSource}" var="resultado">
	            SELECT * from CLIENTE;
</sql:query>

</head>
<body>
	<h1>Listado de clientes</h1>

	<table>
		<tr>
			<th>CIA</th>
			<th>CONTACTO</th>
			<th>CARGO</th>
			<th>TLF</th>
			<th>PAIS</th>
		</tr>

		<c:forEach var="fila" items="${resultado.rows}">
			<tr>
				<td><c:out value="${fila.cia}" /></td>
				<td><c:out value="${fila.contacto}" /></td>
				<td><c:out value="${fila.cargo}" /></td>
				<td><c:out value="${fila.tlf}" /></td>
				<td><c:out value="${fila.pais}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
