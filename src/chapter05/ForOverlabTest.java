package chapter05;
/*
 * 중첩 for문
 */
public class ForOverlabTest {

	public static void main(String[] args) {
		// 2단 ~ 5단
		System.out.println("-----구구단------");
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=9; j++) {
				System.out.print(j + "×" + i + "=" + (j*i) + "\t");
			}
			System.out.println();
		}

	}

}
