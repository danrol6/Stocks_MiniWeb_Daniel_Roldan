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
<h1>Update Stock</h1>

<form class="formCSS" action="${pageContext.request.contextPath}/Stocks" name="addStock" method = "post" onsubmit="return checkForm()">
	Stock Name: <input id= "stocksName" type="text" name="stocksName" value ="${stock.stocksName}"><p/>
	Stock Symbol: <input id = "stocksSymbol" type="text" name="stocksSymbol" value ="${stock.stocksSymbol}"><p/>
	
	<input type = "radio" id="stocksType" name="stocksType" value = "Stock" ${stock.stocksType == 'Stock' ? 'checked' : '' }>Stock</input>
	<input type = "radio" id=typeETF name="stocksType" value = "ETF" ${stock.stocksType == 'ETF' ? 'checked' : ''}>ETF</input>
	<input type = "radio" id="typeCrypto" name="stocksType" value = "Crypto" ${stock.stocksType == 'Crypto' ? 'checked' : ''}>Crypto</input> <p/>
	
	<label>Stock Sector</label>
	<select name ="stocksSector" id ="stocksSector">
			<option value="healthcare" ${stock.stocksSector == 'healthcare' ? 'selected' : ''}>Healthcare</option>
			<option value="consumerGoods" ${stock.stocksSector == 'consumerGoods' ? 'selected' : ''}>Consumer Goods</option>
			<option value="hospitality" ${stock.stocksSector == 'hospitality' ? 'selected' : ''}>Hospitality</option>
			<option value="techMediaAndTelecom" ${stock.stocksSector == 'techMediaAndTelecom' ? 'selected' : ''}>Tech, Media and Telecom</option>
			<option value="business" ${stock.stocksSector == 'business' ? 'selected' : ''}>Business</option>
			<option value="energyAndWater" ${stock.stocksSector == 'energyAndWater' ? 'selected' : ''}>Energy and Water</option>
			<option value="finance" ${stock.stocksSector == 'finance' ? 'selected' : ''}>Finance</option>
			<option value="manufacturingAndMaterials" ${stock.stocksSector == 'manufacturingAndMaterials' ? 'selected' : ''}>Manufacturing and Materials</option>
			<option value="crypto" ${stock.stocksSector == 'crypto' ? 'selected' : ''}>Crypto</option>
	</select><p/>
	
	<textarea name= "stocksComments" id = "stocksComments">${stock.stocksComments}</textarea><p/>
	
	<input type = "hidden" name = "id" value = "${stock.id}"/><br/>
	<input type = "hidden" name = "action" value = "update"/>
	
    <input class= "submitButton" type="submit" value="Update">
    
</form>
</body>
</html>