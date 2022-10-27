package test.main;

import test.mypac.HandPhone;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 *  Phone 클래스를 상속받은 HandPhone 클래스로 객체를 생성해서 
		 *  그 참조값을 p1 이라는 이름의 지역변수에 담기
		 */
		HandPhone p1=new HandPhone();
		/*
		 *  HandPhone 클래스의 생성자를 호출해서 객체를 생성했더니
		 *  Phone 클래스의 생성자도 호출되는걸 알수가 있다.
		 *  
		 *  따라서 HandPhone 객체도 생성되고 Phone 객체도 같이 생성 되었다는걸 유추할수 있다. 
		 *  
		 *  Phone 객체와 HandPhone 객체가 생성되어서 같은 사물함에 들어간다. 
		 *  
		 *  즉, 하나의 참조값으로 Phone 의 기능, HandPhone 의 기능을 모두 사용할수 있다. 
		 *  
		 */
		p1.call();
		p1.mobileCall();
		p1.takePicture();
		
	}
}










