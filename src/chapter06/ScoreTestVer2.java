package chapter06;

import java.util.Scanner;

/*
 * 학생 한명의 국어, 영어, 수학 점수를 입력받아 출력하는 로직
 */
public class ScoreTestVer2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = null;
		int[] scoreList = new int[4];
		String[] subjectList = {"스쿼트", "데드리프트", "벤치프레스"};
		
		// 1. 데이터 입력
		System.out.print("회원명> ");
		name = scan.next();
		
		int tot = 0;
		int avg = 0;
		for(int i = 0; i<scoreList.length; i++) {
			if(i < scoreList.length-1) {
			System.out.print(subjectList[i] + " 무게> ");
			scoreList[i] = scan.nextInt();
			tot += scoreList[i];
			avg /= tot/subjectList.length;
			} else {
				scoreList[scoreList.length-1] = tot;
				i = scoreList.length; // break;
				
			}
		}
		//2. 데이터 출력 : 회원명, 스쿼트, 데드리프트, 벤치프레스
		System.out.println("회원명\t스쿼트\t데드리프트\t벤치프레스\t합계");
		System.out.print(name + "\t");
			for(int score : scoreList) {
				System.out.print(score+"\t");
		}

	}

}
