<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stocks</title>
<link rel="stylesheet" href="../css/Stock.css">
</head>
<body>
 <jsp:include page="../partials/menu.jsp" />
	
	<table class="alternate" id="stocksTable">
	<thead>
	<tr>
	<th>Name</th>
	<th>Symbol</th>
	<th>Type</th>
	<th>Sector</th>
	<th>Comment</th>
	</tr>
	</thead>
	<tbody>
	
 <c:forEach var="stocks" items="${stocks}">
 			
		   <tr>
		      <td>
				<c:out value = "${stocks.stocksName}"/>
			  </td>
			  <td>
				<c:out value = "${stocks.stocksSymbol}"/>
			  </td>
			  <td>
			  	<c:out value = "${stocks.stocksType}"/>
			  </td>
			  <td>
			  	<c:out value = "${stocks.stocksSector}"/>
			  </td>
			  <td>
			  	<c:out value = "${stocks.stocksComments}"/>
			  </td>
			  <td class="noBorder">
			    
				<a class="greenButton button" href="${pageContext.request.contextPath}/Stocks/List?id=${stocks.id}">Edit</a>
			  </td>
		   </tr>
		   
	</c:forEach>
	</tbody>
	</table>
	
</body>
</html>