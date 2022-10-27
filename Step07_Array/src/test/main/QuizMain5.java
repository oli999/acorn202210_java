package test.main;

import java.util.Random;

public class QuizMain5 {
	
	public static void main(String[] args) {
		
		/*
		 *  3 개가 모두 같게 나왔다면 10 점
		 *  2 개만 같으면 5점
		 */
		
		String[] items={"cherry", "apple", "banana", "melon", "7"};
		//랜덤한 숫자를 얻어내기 위한 객체 
		Random ran=new Random();
		
		// for 문 안에서 얻어낸 랜덤한 숫자 3개를 저장할 배열 객체 생성
		int[] nums=new int[3];
		
		for(int i=0; i<3; i++) {
			// 0~4 사이의 랜덤한 숫자를 하나 얻어내서 
			int ranNum=ran.nextInt(5);
			// 배열의 인덱스로 활용해서 문자열 출력하기
			System.out.print(items[ranNum]);
			if(i < 2) {
				System.out.print(" | ");
			}
			//배열에 얻어낸 랜덤한 숫자를 저장하기
			nums[i]=ranNum;
		}
		//개행
		System.out.println();
		
		//3 개가 모두 같은지 여부
		boolean isAllEqual = nums[0] == nums[1] && nums[1] == nums[2];
		//2 개가 같은지 여부 
		boolean isTwoEqual = nums[0]==nums[1] || nums[1]==nums[2] || nums[0]==nums[2];
		/*
		 * 점수는 10 , 5, 0
		 */
		if(isAllEqual) {
			System.out.println("10점 입니다.");
		}else if(isTwoEqual) {
			System.out.println("5점 입니다.");
		}else {
			System.out.println("0점 입니다.");
		}
	
	}
}











