package chapter21_mini_project.repository;

import java.util.ArrayList;
import java.util.List;

import chapter21_mini_project.model.BooksVo;
import db.DBConn;
import db.GenericRepositoryInterface;

public class BookRepository extends DBConn
				implements GenericRepositoryInterface<BooksVo>{
	
	@Override
	public int insert(BooksVo book) {
		int rows = 0;
		String sql = """
				insert into bname, price, author, binfo, department, bdate
				 valuse(?,?,?,?,now());
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getBname());
			pstmt.setInt(2, book.getPrice());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getBinfo());
			pstmt.setString(5, book.getDepartment());
			
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
				select count(*) as count from books
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
	public List<BooksVo> findAll() {
		List<BooksVo> list = null;
		int rows = 0;
		String sql = """
				select row_number() over(order by bid) as rno,
				bid, bname, price, author, binfo, department, bdate
				from books
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null ) {
				list = new ArrayList<BooksVo>();
				while(rs.next()) {
					BooksVo book = new BooksVo();
					book.setRno(rs.getInt(1));
					book.setBid(rs.getString(2));
					book.setBname(rs.getString(3));
					book.setPrice(rs.getInt(4));
					book.setAuthor(rs.getString(5));
					book.setBinfo(rs.getString(6));
					book.setDepartment(rs.getString(7));
					book.setBdate(rs.getString(8));
					list.add(book);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public BooksVo find(String bid) {
		BooksVo book = null;
		String sql = """
				select bid, bname, price, author, binfo, department, bdate
				from books
				where bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new BooksVo();
				book.setBid(rs.getString(1));
				book.setBname(rs.getString(2));
				book.setPrice(rs.getInt(3));
				book.setAuthor(rs.getString(4));
				book.setBinfo(rs.getString(5));
				book.setDepartment(rs.getString(6));
				book.setBdate(rs.getString(7));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public int update(BooksVo book) {
		int rows = 0;
		String sql = """
				update books
					set price = ?, author = ?
					where bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setInt(1, book.getPrice());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getBid());
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
				delete from books
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
