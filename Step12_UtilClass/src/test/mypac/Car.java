package test.mypac;

public class Car {
	//필드
	private String name;
	//생성자
	public Car(String name) {
		this.name=name;
	}
	//메소드
	public void drive() {
		System.out.println(this.name+" 이(가) 달려요!");
	}
}
