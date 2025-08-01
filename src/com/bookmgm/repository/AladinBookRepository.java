package com.bookmgm.repository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bookmgm.model.BookVo;

import db.DBConn;
import db.GenericRepositoryInterface;

public class AladinBookRepository extends DBConn implements GenericRepositoryInterface<BookVo>{
	
	
	public AladinBookRepository() {
		super();
		System.out.println("** 알라딘 도서관 생성 완료**");
	}
	
	@Override
	public int insert(BookVo book) {
		int rows = 0;
		String sql = """
				insert into book_aladin(title, author, price, bdate)
					values(?,?,?,now())
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			rows = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public List<BookVo> findAll() {
		List<BookVo> list = new ArrayList<BookVo>();
		String sql = """
				select row_number() over() as rno,
					bid, title, author, price, bdate
					from book_aladin
				""";
		try {
			getPreparedStatement(sql);
			rs =pstmt.executeQuery();
			while(rs.next()) {
			BookVo book = new BookVo();
			book.setRno(rs.getInt(1));
			book.setTitle(rs.getString(2));
			book.setAuthor(rs.getString(3));
			book.setPrice(rs.getInt(4));
			book.setBdate(rs.getString(5));
			list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//	@Override
//	public Book select(String id) {
//		Book book = null;
//			for(Book b:library) {
//				if(b.getId().equals(id)) {
//					book=b;
//					break;
//				}
//		}
//		return book;
//	}
	
	@Override
	public int update(BookVo book) {
		int rows = 0;
		String sql = """
				update book_aladin
				set author = ?, price =?
				where bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, book.getAuthor());
			pstmt.setInt(2, book.getPrice());
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
				delete from book_aladin
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
	
	
	@Override
	public int getCount() {
		int rows = 0;
		String sql = """
				select count(*) from book_aladin
				""";
		try {
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) rows = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public BookVo find(String bid) {
		BookVo book = null;
		String sql = """
				select bid, title, author, price, bdate
				from book_aladin
				where bid = ?
				""";
		try {
			getPreparedStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new BookVo();
				book.setBid(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getInt(4));
				book.setBdate(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
}


