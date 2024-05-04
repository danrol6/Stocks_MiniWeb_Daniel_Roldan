package com.DDR.beans;

public class Stocks {
	private Integer id;
	private String stocksName;
	private String stocksSymbol;
	private String stocksType;
	private String stocksSector;
	private String stocksComments;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStocksName() {
		return stocksName;
	}
	public void setStocksName(String stocksName) {
		this.stocksName = stocksName;
	}
	public String getStocksSymbol() {
		return stocksSymbol;
	}
	public void setStocksSymbol(String stocksSymbol) {
		this.stocksSymbol = stocksSymbol;
	}
	public String getStocksType() {
		return stocksType;
	}
	public void setStocksType(String stocksType) {
		this.stocksType = stocksType;
	}
	public String getStocksSector() {
		return stocksSector;
	}
	public void setStocksSector(String stocksSector) {
		this.stocksSector = stocksSector;
	}
	public String getStocksComments() {
		return stocksComments;
	}
	public void setStocksComments(String stocksComments) {
		this.stocksComments = stocksComments;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stocks [id=");
		builder.append(id);
		builder.append(", stocksName=");
		builder.append(stocksName);
		builder.append(", stocksSymbol=");
		builder.append(stocksSymbol);
		builder.append(", stocksType=");
		builder.append(stocksType);
		builder.append(", stocksSector=");
		builder.append(stocksSector);
		builder.append(", stocksComments=");
		builder.append(stocksComments);
		builder.append("]");
		return builder.toString();
	}

}
