package com.DDR.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dal.DaoInterface;
import com.DDR.beans.Stocks;
import com.utilities.DbCon;

public class StocksDao implements DaoInterface<Stocks> {
	
	private static String TABLE = "DDR_Stocks";

	@Override
	public ArrayList<Stocks> findAll() {
		Connection con = DbCon.getConnection();
		ArrayList<Stocks> stocks = new ArrayList<>();
		
		try {
			String sql = "select * from "+ TABLE;
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Stocks stock = new Stocks();
				stock.setId(rs.getInt(1));
				stock.setStocksName(rs.getString(2));
				stock.setStocksSymbol(rs.getString(3));
				stock.setStocksType(rs.getString(4));
				stock.setStocksSector(rs.getString(5));
				stock.setStocksComments(rs.getString(6));
								
				stocks.add(stock);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return stocks;
	}

	@Override
	public Stocks findById(int id) {
		Connection con = DbCon.getConnection();
		Stocks stock = new Stocks();
		
		try {
			String sql = "select * from "+ TABLE + " where Stocks_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				stock.setId(rs.getInt(1));
				stock.setStocksName(rs.getString(2));
				stock.setStocksSymbol(rs.getString(3));
				stock.setStocksType(rs.getString(4));
				stock.setStocksSector(rs.getString(5));
				stock.setStocksComments(rs.getString(6));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return stock;
	}

	@Override
	public void update(Stocks obj) {
		Connection con = DbCon.getConnection();
		
		try {
			
			String qry = "update " + TABLE + " set Stocks_name =?, stocks_symbol=?, stocks_type=?, stocks_sector=?, stocks_comments=? where stocks_id =?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, obj.getStocksName());
			ps.setString(2, obj.getStocksSymbol());
			ps.setString(3, obj.getStocksType());
			ps.setString(4, obj.getStocksSector());
			ps.setString(5, obj.getStocksComments());
			ps.setInt(6, obj.getId());
			
			ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		
	}

	@Override
	public Stocks save(Stocks obj) {
		Connection con = DbCon.getConnection();
		
		try {
			
			String qry = "insert into " + TABLE + " (Stocks_name, stocks_symbol, stocks_type, stocks_sector, stocks_comments) "
					+ "values (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, obj.getStocksName());
			ps.setString(2, obj.getStocksSymbol());
			ps.setString(3, obj.getStocksType());
			ps.setString(4, obj.getStocksSector());
			ps.setString(5, obj.getStocksComments());
			
			ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		
		return obj;
	}

	@Override
	public void delete(int id) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "Delete from " + TABLE + " where stocks_id =?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		
	}
	
	public ArrayList<Stocks> findByName(String name) {
		Connection con = DbCon.getConnection();
		ArrayList<Stocks> stocks = new ArrayList<>();
		
		name = "%" + name.toLowerCase() +"%";
		
		try {
			String sql = "select * from "+ TABLE + " where lower(Stocks_name) like ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Stocks stock = new Stocks();
				stock.setId(rs.getInt(1));
				stock.setStocksName(rs.getString(2));
				stock.setStocksSymbol(rs.getString(3));
				stock.setStocksType(rs.getString(4));
				stock.setStocksSector(rs.getString(5));
				stock.setStocksComments(rs.getString(6));
				
				stocks.add(stock);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return stocks;
	}
	
	public Stocks findBySymbol(String symbol) {
		Connection con = DbCon.getConnection();
		Stocks stock = new Stocks();
		
		try {
			String sql = "select * from "+ TABLE + " where Stocks_symbol =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, symbol);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				stock.setId(rs.getInt(1));
				stock.setStocksName(rs.getString(2));
				stock.setStocksSymbol(rs.getString(3));
				stock.setStocksType(rs.getString(4));
				stock.setStocksSector(rs.getString(5));
				stock.setStocksComments(rs.getString(6));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return stock;
	}

}
