package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.BookVo;
import db.DBConn;
import db.GenericRepositoryInterface;

public class BookRepositoryImpl extends DBConn
				implements GenericRepositoryInterface<BookVo>{
	
	@Override
	public int insert(BookVo book) {
		int rows = 0;
		String sql = """
				insert into book_market_books(
				title, author, price, isbn, bdate)
				values(?,?,?,?,now())
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setInt(4, book.getIsbn());
			
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
				select count(*) as count from book_market_books
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
	public List<BookVo> findAll() {
		List<BookVo> list = new ArrayList<BookVo>();
		String sql = """
				select row_number() over(order by bid) as rno,
				bid, title, author, price, isbn, bdate
				from book_market_books
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				list = new ArrayList<BookVo>();
				while(rs.next()) {
					BookVo book = new BookVo();
					book.setRno(rs.getInt(1));
					book.setTitle(rs.getString(2));
					book.setAuthor(rs.getString(3));
					book.setPrice(rs.getInt(4));
					book.setIsbn(rs.getInt(5));
					book.setBdate(rs.getString(6));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public BookVo find(String bid) {
		BookVo book = null;
		String sql = """
				select bid, title, author, price, isbn, bdate
				from book_market_books
				where bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1,bid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new BookVo();
				book.setBid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setIsbn(rs.getInt(5));
				book.setBdate(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public int update(BookVo book) {
		int rows = 0;
		String sql = """
				update book_market_books
				set author = ?, price = ?
				where bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getAuthor());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3,book.getBid());
			
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public int remove(String bid) {
		int rows = 0;
		String sql = """
				delete from book_market_books
					where bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}
