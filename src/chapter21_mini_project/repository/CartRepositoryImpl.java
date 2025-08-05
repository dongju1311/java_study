package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.BookVo;
import chapter21_mini_project.model.CartVo;
import db.DBConn;
import db.GenericRepositoryInterface;

public class CartRepositoryImpl extends DBConn
						implements GenericRepositoryInterface<CartVo>{
	
	@Override
	public int insert(CartVo cart) {
		int rows = 0;
		String sql = """
				insert into book_market_cart(
				qty, cdate)
				values(?, now())
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, cart.getQty());
			pstmt.setString(2, cart.getCdate());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public int getCount() {
		int rows = 0;
		String sql = """
				select count(*) as count from book_market_cart
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) rows = rs.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public List<CartVo> findAll() {
		List<CartVo> list = new ArrayList<CartVo>();
		String sql = """
				select row_number() over(order by bid) as rno,
				cid, qty, mid, bid, cdate
				from book_market_cart
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<CartVo>();
				while(rs.next()) {
					CartVo cart = new CartVo();
					cart.setRno(rs.getInt(1));
					cart.setCid(rs.getString(2));
					cart.setQty(rs.getInt(3));
					cart.setMid(rs.getString(5));
					cart.setBid(rs.getString(6));
					cart.setCdate(rs.getString(6));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public CartVo find(String cid) {
		CartVo cart = null;
		String sql = """
				select cid, qty, mid, bid, cdate
				from book_market_cart
				where cid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,cid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cart = new CartVo();
				cart.setBid(rs.getString(1));
				cart.setQty(rs.getInt(2));
				cart.setMid(rs.getString(3));
				cart.setBid(rs.getString(4));
				cart.setCdate(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
	@Override
	public int update(CartVo cart) {
		int rows = 0;
		String sql = """
				update book_market_cart
				set qty = ?
				where cid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, cart.getQty());
			pstmt.setString(2, cart.getCid());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public int remove(String cid) {
		int rows = 0;
		String sql = """
				delete from book_market_cart
					where bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, cid);
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}
