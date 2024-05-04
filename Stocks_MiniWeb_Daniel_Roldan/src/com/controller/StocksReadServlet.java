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
 * Servlet implementation class StocksReadServlet
 */
public class StocksReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StocksReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");

		HttpSession session = request.getSession();
		StocksService service = new StocksService();
		
		String action = request.getParameter("action");
		
		if(action!=null && action.equals("search")) {
				String searchValue = request.getParameter("searchValue");
				
				if(request.getParameter("searchBy").equals("searchByLastName")) {
					ArrayList<Stocks> stocks = service.findByName(searchValue);
				
//					for(Stocks stock: stocks) {
//						System.out.println(stock);
//					}
					
					//session.setAttribute("stocks", stocks);
					//request.getRequestDispatcher("../jsp/StockPages/DisplayStocks.jsp").forward(request, response);
				}
				else if (request.getParameter("searchBy").equals("searchBySymbol")) {
					ArrayList<Stocks> stocks = new ArrayList<>();
					Stocks stock = service.findBySymbol(searchValue);

					//System.out.println(stock);
					
					stocks.add(stock);
					
					session.setAttribute("stocks", stocks);
					request.getRequestDispatcher("../jsp/StockPages/DisplayStocks.jsp").forward(request, response);
				}
			//}

		}else if(idString != null) {
			Integer id= Integer.parseInt(idString);

			service = new StocksService();
			
			Stocks stock = service.findById(id);
			//session = request.getSession();
			session.setAttribute("stock", stock);
			
			request.getRequestDispatcher("../jsp/StockPages/UpdateStock.jsp").forward(request, response);
		}
		else {
			ArrayList<Stocks> stocks = service.findAll();
//			for(Stocks stock: stocks) {
//				System.out.println(stock);
//			}
			
			session.setAttribute("stocks", stocks);
			request.getRequestDispatcher("../jsp/StockPages/DisplayStocks.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
