<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Stock</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Stock.css">
</head>
<body>
 <jsp:include page="../partials/menu.jsp" />

<h1>Search Stock</h1>
	
<form class="formCSS" action="${pageContext.request.contextPath}/Stocks/List" name="addStock" method = "post" onsubmit="">

	<input type = "radio" value = "searchByName" name="searchBy">
	<label for="searchByName">Search by Name</label>
	<input type = "radio" value = "searchBySymbol" name="searchBy">
	<label for="searchBySymbol">Search by Symbol</label><p/>
	
	Search: <input id= "searchValue" type="text" name="searchValue"><p/>

	<input type = "hidden" name = "action" value = "search"/>
	
    <input class= "submitButton" type="submit" value="Search">   
    
</form>
</body>
</html>