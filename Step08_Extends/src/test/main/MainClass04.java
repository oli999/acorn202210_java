package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass04 {
	public static void main(String[] args) {
		//HandPhone 객체를 생성해서 그 참조값을 Object type p3 지역변수에 담는다.
		Object p3=new HandPhone();
		//Object type 변수에 담긴 값을 Phone type 변수에 담기 
		Phone p2=(Phone)p3;  //casting 연산자를 이용하면 가능하다 
		HandPhone p1=(HandPhone)p3; //casting 연산자를 이용하면 가능하다 
	}
}
