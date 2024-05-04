package com.DDR;

import java.util.ArrayList;

import com.DDR.beans.Stocks;
import com.DDR.dal.StocksDao;

public class StocksDemo {
	private static StocksDao dao = new StocksDao();
	
	public static void main(String[] args) {

		System.out.println("Displaying all stocks");
		ArrayList<Stocks> stocks = dao.findAll();
		displayStocks(stocks);
		
		System.out.println("\nFinding first stock");
		Stocks stock = dao.findById(1);
		System.out.println(stock);
		
		Stocks stock2 = new Stocks();
		stock2.setStocksName("Alphabet Class B");
		stock2.setStocksSymbol("GOOG");
		stock2.setStocksType("Stock");
		stock2.setStocksSector("Business");
		stock2.setStocksComments("");
		
		System.out.println("\nAdding a new stock...");
		//dao.save(stock2);
		
		System.out.println("\nUpdating stock...");
		//stock.setStocksName("Limelight Networks");
		//dao.update(stock);
		
		System.out.println("\nDeleting a record...");
		//dao.delete(3);
		
		System.out.println("\nSearching by stock name...");
		ArrayList<Stocks> searchByName = dao.findByName("class");
		displayStocks(searchByName);
		
		System.out.println("\nSearching by stock symbol...");
		Stocks searchBySymbol = dao.findBySymbol("UNP");
		System.out.println(searchBySymbol);
		
		System.out.println("\nDisplaying updated list...");
		stocks = dao.findAll();
		displayStocks(stocks);
		
	}
	
	private static void displayStocks(ArrayList<Stocks> stocks) {
		for (Stocks stock: stocks) {
			System.out.println(stock);
		}
	}

}
