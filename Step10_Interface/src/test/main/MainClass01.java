package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		//인터페이스도 data type 역활이 가능하다 
		Remocon r1=null;
		
		//Remocon r2=new Remocon(); //인터페이스 단독으로 객체생성 불가(생성자 없음)
		
		//Remocon 인터페이스를 구현(implements) 한 클래스를 이용해서 Remocon type 의 참조값 얻어내기 
		Remocon r2=new MyRemocon();
		r2.up();
		r2.down();
		//인터페이스의 필드 참조 ( static final )
		String result=Remocon.COMPANY;
	}
}










