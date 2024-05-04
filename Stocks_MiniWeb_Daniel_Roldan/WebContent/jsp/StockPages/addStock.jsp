<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Stock</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Stock.css">
<script src = "${pageContext.request.contextPath}/js/Stocks.js"></script>
</head>
<body>
 <jsp:include page="../partials/menu.jsp" />
<h1>Insert Stock</h1>

<form class="formCSS" action="${pageContext.request.contextPath}/Stocks" name="addStock" method = "post" onsubmit="return checkForm()">
	Stock Name: <input id= "stocksName" type="text" name="stocksName"><p/>
	Stock Symbol: <input id = "stocksSymbol" type="text" name="stocksSymbol"><p/>
	
	<input type = "radio" id="stocksType" value = "Stock" name="stocksType">
	<label for="typeStock">Stock</label>
	<input type = "radio" id="typeETF" value = "ETF" name="stocksType">
	<label for="typeETF">ETF</label>
	<input type = "radio" id="typeCrypto" value = "Crypto" name="stocksType">
	<label for="typeCrypto">Crypto</label><p/>
	
	<label>Stock Sector</label>
	<select name ="stocksSector" id ="stocksSector">
			<option value="healthcare">Healthcare</option>
			<option value="consumerGoods">Consumer Goods</option>
			<option value="hospitality">Hospitality</option>
			<option value="techMediaAndTelecom">Tech, Media and Telecom</option>
			<option value="business">Business</option>
			<option value="energyAndWater">Energy and Water</option>
			<option value="finance">Finance</option>
			<option value="manufacturingAndMaterials">Manufacturing and Materials</option>
			<option value="crypto">Crypto</option>
	</select><p/>
	
	<textarea name= "stocksComments" id = "stocksComments"></textarea><p/>
	
	<input type = "hidden" name = "action" value = "add"/>
	
    <input class= "submitButton" type="submit" value="submit">
    
</form>
</body>
</html>