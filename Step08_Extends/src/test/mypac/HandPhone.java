package test.mypac;

/*
 *  이미 존재하는 Phone 클래스를 extends(상속) 받아서 HandPhone 클래스 정의하기 
 */

public class HandPhone extends Phone{
	
	public HandPhone() {
		System.out.println("HandPhone 생성자 호출됨");
	}
	
	//메소드
	public void mobileCall() {
		System.out.println("이동중에 전화를 걸어요");
	}
	//사진 찍는 메소드
	public void takePicture() {
		System.out.println("30만 화소의 사진을 찍어요");
	}
}
