package chapter21_mini_project.Service;

import java.util.List;

import chapter21_mini_project.application.BookMarketSystem;
import chapter21_mini_project.model.BookVo;
import chapter21_mini_project.model.CartVo;
import chapter21_mini_project.model.MemberVo;
import chapter21_mini_project.repository.BookMarketRepositoryInterface;
import chapter21_mini_project.repository.MemberRepositoryImpl;

public class BookMarketServiceImpl implements BookMarketService{
	
	BookMarketSystem bms;
	BookMarketRepositoryInterface<MemberVo> memberRepository;	
	BookMarketRepositoryInterface<BookVo> bookRepository;	
	BookMarketRepositoryInterface<CartVo> cartRepository;	
	String mid;
	String bid;
	String cid;
	
	public BookMarketServiceImpl(BookMarketSystem bms) {
		this.bms = bms;
		memberRepository = new MemberRepositoryImpl();
	}
	@Override
	public void menuGuestAdd() {
		MemberVo member = new MemberVo();
		System.out.print("회원명> ");
		member.setName(bms.scan.next());
		
		System.out.print("주소> ");
		bms.scan.nextLine();
		member.setAddress(bms.scan.next());
		
		System.out.print("연락처> ");
		bms.scan.nextLine();
		member.setPhone(bms.scan.next());
		
		memberRepository.insert(member);
		this.mid = memberRepository.findId();
	}
	@Override
	public void menuGuestInfo() {
		MemberVo member = memberRepository.find(mid);
		if(member != null) {
			System.out.println("--------------------------------------------------");
			System.out.println("현재 고객정보: ");
			System.out.print("이름: " + member.getName() + "\t");
			System.out.print("연락처: " + member.getPhone() + "\n");
			System.out.println("--------------------------------------------------");
		} else {
			System.out.println("등록된 회원 정보가 없습니다.");
		}
		bms.selectMenu();
	}
	public void menuCartItemList() {
		List<CartVo> cartItem = cartRepository.findAll();
		if(cartItem.isEmpty()) {
			System.out.println("장바구니가 비어있습니다.");
		}
		System.out.println("장바구니 상품 목록: ");
		System.out.println("--------------------------------------------------");
		System.out.print("도서ID" + "\t\t" + "수량");
		
		
		System.out.println("--------------------------------------------------");
	}
	public void menuCartClear() {
		
	}
	public void menuCartAddItem() {
		BookVo book = bookRepository.find(bid);
		if(book != null) {
			System.out.println("--------------------------------------------------");
			System.out.print(book.getIsbn()+"\t");
			System.out.print(book.getTitle() + "\t");
			System.out.print(book.getAuthor() + "\t");
			System.out.print(book.getPrice() + "\t");
			System.out.print(book.getBdate() + "\n");
			System.out.println("--------------------------------------------------");
		} else {
			System.out.println("등록된 책 정보가 없습니다.");
		}
	}
	public void menuCartRemoveItemCount() {
		
	}
	public void menuCartRemoveItem() {
		
	}
	public void menuCartBill() {
		
	}
	public void menuExit() {
		System.out.println("-- 북마켓을 종료합니다 --");
		memberRepository.close();
		cartRepository.close();
		bookRepository.close();
		System.exit(0);
	}
}
