package test.main;

import test.mypac.Apple;
import test.mypac.Banana;
import test.mypac.FruitBox;

public class MainClass01 {
	public static void main(String[] args) {
		/*
		 *  객체 생성시 Generic 클래스는 생략 가능!
		 *  참조값을 필드나 변수에 받을때만 type 을 정확히 지정하면 됩니다. 
		 */
		FruitBox<Apple> box1 = new FruitBox<>();
		//setItem() 메소드 호출하면서 Apple type 전달하기
		box1.setItem(new Apple());
		//getItem() 메소드 호출해서 Apple type 리턴 받기 
		Apple a=box1.getItem();
		
		
		// 위의 테스트를 Banana 클래스로 해 보세요
		FruitBox<Banana> box2=new FruitBox<>();
		box2.setItem(new Banana());
		Banana b=box2.getItem();
	}
}











