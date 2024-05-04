package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DDR.beans.Stocks;
import com.DDR.services.StocksService;

/**
 * Servlet implementation class StockWriteServlet
 */
public class StockWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StockWriteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String stockName = request.getParameter("stocksName");
		String stockSymbol = request.getParameter("stocksSymbol");
		String stockType = request.getParameter("stocksType");
		String stockSector = request.getParameter("stocksSector");
		String stockComment = request.getParameter("stocksComments");
		
//		System.out.println(stockName + " " + stockSymbol);
//		System.out.println(stockType + " " + stockSector);
//		System.out.println(stockComment);
		
		Stocks stock = new Stocks();
		stock.setStocksName(stockName);
		stock.setStocksSymbol(stockSymbol);
		stock.setStocksType(stockType);
		stock.setStocksSector(stockSector);
		stock.setStocksComments(stockComment);
		System.out.println(stock);
		
		String action = request.getParameter("action");
		
		StocksService service = new StocksService();
		
		if (action.equals("add")) {
			service.save(stock);
			System.out.println("Added!");
			
			request.getRequestDispatcher("Stocks/List").forward(request, response);
		} else if (action.equals("update")) {
			stock.setId(Integer.parseInt(request.getParameter("id")));
			System.out.println("Update " + stock);
			service.update(stock);
			
			session = request.getSession();
			session.setAttribute("message", "Stock updated.");
			request.getRequestDispatcher("Stocks/List").forward(request, response);
			
		} 
		
	}

}
