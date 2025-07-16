package chapter12;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		HashMap<String, String> map2 = new HashMap<String,String>();
		map.put("name", "홍길동");
		map.put("age", "10");
		map.put("scan", new Scanner(System.in));
		

	}

}
