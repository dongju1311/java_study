package chapter21_mini_project.Service;

import java.util.List;
import java.util.Scanner;

import com.bookmgm.model.BookVo;

import chapter21_mini_project.application.BookMarketApplication;
import chapter21_mini_project.model.BooksVo;
import chapter21_mini_project.model.CartVo;
import db.GenericRepositoryInterface;

public class BookService implements Service{
	Scanner scan;
	BookMarketApplication bma;
	GenericRepositoryInterface<BooksVo> repository1;
	GenericRepositoryInterface<CartVo> repository2;
	
	
	public BookService() {}
	
	public BookService(BookMarketApplication bma) {
		this.bma = bma;
	}
	
	public void menuGuestInfo() {
		System.out.println("1 성공!");
	}
	public void menuCartItemList() {
		System.out.println("2 성공!");
	}
	public void menuCartClear() {
		System.out.println("3 성공!");
	}
	public void menuCartAddItem() {
		if(getCount() != 0) {
			List<BookVo> library = repository1.findAll();
			System.out.println("-------------------------------------------------");
			library.forEach(book -> {
				System.out.print("[" + book.getBid() + "]\t");
				System.out.print(book.getTitle() + " - ");
				System.out.print(book.getAuthor() + ",\t");
				System.out.print(book.getIsbn() + ",\t");
				System.out.print(book.getPrice() + "\n");
			});			
			System.out.println("-------------------------------------------------");
		} else {
			System.out.println("🚫 등록된 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	}
	public void menuCartRemoveItemCount() {
		System.out.println("5 성공!");
	}
	public void menuCartRemoveItem() {
		if(getCount() != 0) {
			System.out.print("도서명> ");
			CartVo cart = repository2.find(bma.scan.next());
			if(cart != null) {
				repository2.remove(cart.getBname());
				System.out.println("도서가 삭제되었습니다.");
			} else {
				System.out.println("검색한 도서가 없습니다.");
			}
		} else {
			System.out.println("등록한 도서가 존재하지 않습니다.");
		}
		bma.showMenu();
	}
	public void menuCartBill() {
		System.out.println("7 성공!");
	}
	public void menuExit() {
		System.out.println("==== 시스템이 종료됩니다. ====");
		System.exit(0);
	}
	
	
	public int getCount() {
		return repository2.getCount();
	}
}
