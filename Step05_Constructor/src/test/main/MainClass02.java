package test.main;

import test.mypac.Member;

public class MainClass02 {
	public static void main(String[] args) {
		//기본 생성자를 호출하면서 객체 생성하기
		Member m1=new Member();
		m1.num=2;
		m1.name="해골";
		m1.addr="행신동";
		
		//값을 3개 전달하는 생성자를 호출하면서 객체 생성하기 
		Member m2=new Member(1, "김구라", "노량진");
		
		m1.showInfo();
		m2.showInfo();
	}
}
