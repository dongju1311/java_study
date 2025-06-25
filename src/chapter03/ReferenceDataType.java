package chapter03;

import java.lang.String;  // java.lang에 있는 클래스는 자주 사용하는거기 때문에 꼭 안넣어도 실행가능
import java.lang.System;
import java.util.Scanner; // Scanner는 lang에 없으므로 import로 추가해야 실행가능

public class ReferenceDataType {

	public static void main(String[] args) {
		// 참조 데이터 타입 정의 : 배열, 클래스, 인터페이스 ...
		String name = new String("홍길동");
		Scanner scan = new Scanner(System.in);
		
		//!!!! 중요!!
		//String 클래스는 기본형으로도 사용이 가능함
		String name2 = "홍길동";
		
System.out.println(name);
System.out.println(scan);
System.out.println(name2);
System.out.println(name == name2);
	}

}
