/**
 * 
 */
let pass = false;

function checkForm(){
	if(check()){
		return true;
	}
	else{
		alert("cannot submit");
		return false;
	}
}

function check(){
	check = true;
	let stockName = document.getElementById('stocksName').value;
	let stockSymbol = document.getElementById('stocksSymbol').value;
	let stocksSector = document.getElementById('stocksSector').value;

	if(stockName ==''){
		check = false;
		alert("Enter a value for Stock Name");
	}
	
	if(stockSymbol ==''){
		check = false;
		alert("Enter a value for stock Symbol");
	}
	
	if(checkRadioButton() == false){
		check = false;
		alert("Enter a value for stock type");
	}
	
	return check;
}

function checkRadioButton(){
	let val;
	
	if(document.getElementById('stocksType').checked || document.getElementById('typeETF').checked || document.getElementById('typeCrypto').checked){
		val = true;
	}
	else{
		val = false;
	}
	
	
	return val;
}