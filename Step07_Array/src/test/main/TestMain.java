package test.main;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		
		int point=1000;
		Scanner scan=new Scanner(System.in);	
		while(true) {
			//만일 point 가 0 이면
			if(point == 0) {
				break;//반복문 loop 탈출
			}
			System.out.println("Enter 를 치세요");
			//Enter 를 칠때까지 블로킹되는 메소드 호출
			scan.nextLine();
			//point 를 10 감소 시키면서 
			point -= 10;
			//원하는 작업 수행...
			System.out.println("수행중...");
			
		}
		
		System.out.println("main 메소드가 종료 됩니다.");
	}
}





