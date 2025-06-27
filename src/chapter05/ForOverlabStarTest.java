package chapter05;
/*
 [시작]
 *
 **
 ***
 ****
 *****
 [종료] 
 */
public class ForOverlabStarTest {

	public static void main(String[] args) {
	
		for(int i=1; i<=10; i++) { //행
			for(int j=1; j<=10; j++) { //열
				if(i>=j) System.out.print("🍕");
			}
			System.out.println();
		}
	}

}
