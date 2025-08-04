package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.BooksVo;
import chapter21_mini_project.model.CartVo;
import db.DBConn;
import db.GenericRepositoryInterface;

public class CartRepository extends DBConn
						implements GenericRepositoryInterface<CartVo>{
	
	@Override
	public int insert(CartVo cart) {
		int rows = 0;
		String sql = """
				insert into bname, user_name, qty
					values(?,?,?)
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, cart.getBname());
			pstmt.setString(2, cart.getUserName());
			pstmt.setInt(3, cart.getQty());
			
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
				select count(*) as count from cart
				""";
		try {
			getPreparedStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) rows=rs.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public List<CartVo> findAll() {
		List<CartVo> list = null;
		int rows = 0;
		String sql = """
				select row_number() over(order by bname) as rno,
					bname, user_name, qty
					from cart_item
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<CartVo>();
				while(rs.next()) {
				CartVo cart = new CartVo();
				cart.setBname(rs.getString(1));
				cart.setUserName(rs.getString(2));
				cart.setQty(rs.getInt(3));
				
				list.add(cart);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public CartVo find(String id) {
		CartVo cart = null;
		String sql = """
				select bname, user_name, qty
				from cart_item
				where bname = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cart = new CartVo();
				cart.setBname(rs.getString(1));
				cart.setUserName(rs.getString(2));
				cart.setQty(rs.getInt(3));
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
				update cart_item
					set qty
					where bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, cart.getQty());
			rows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public int remove(String id) {
		int rows = 0;
		String sql = """
				delete from cart_item
					where bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, id);
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rows;
	}
}
