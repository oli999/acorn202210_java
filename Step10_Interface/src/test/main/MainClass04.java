package test.main;

import test.mypac.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		useDrill(new Drill() {
			@Override
			public void hole() {
				System.out.println("바닥에 구멍을 뚤어요");
			}
		});
		
		useDrill(()->{
			System.out.println("천장에 구멍을 뚤어요");
		});
	
		
	}
	//1개의 추상메소드로 구성되어 있는 Drill 객체를 인자로 전달받는 메소드
	public static void useDrill(Drill d) {
		d.hole();
	}
}








