package com.DDR.services;

import java.util.ArrayList;

import com.DDR.beans.Stocks;
import com.DDR.dal.StocksDao;

public class StocksService implements ServiceInterface<Stocks> {
	
	private static StocksDao dao;
	
	public StocksService() {
		dao = new StocksDao();
	}

	@Override
	public ArrayList<Stocks> findAll() {
		return dao.findAll();
	}

	@Override
	public Stocks findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void update(Stocks obj) {
		dao.update(obj);
		
	}

	@Override
	public Stocks save(Stocks obj) {
		return dao.save(obj);
	}

	@Override
	public void delete(int id) {
		
	}
	
	public ArrayList<Stocks> findByName(String name) {
		return dao.findByName(name);
	}
	
	public Stocks findBySymbol(String symbol) {
		return dao.findBySymbol(symbol);
	}

}
