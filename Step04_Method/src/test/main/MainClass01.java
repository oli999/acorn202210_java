package test.main;

import test.mypac.MyObject;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 * MyObject 객체를 하나만 생성해서 그 객체가 가지고 있는
		 * walk(), getNumber(), getGreegting() 메소드를 차례로 호출해 보세요.
		 * 단, 메소드가 어떤 data 를 리턴하면 해당 데이터를 지역변수에 담으세요.
		 */
		 MyObject mo=new MyObject();
		 mo.walk();
		 int num=mo.getNumber();
		 String greet=mo.getGreeting();
	}
}
