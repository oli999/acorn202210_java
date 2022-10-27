package test.main;

import test.auto.ElectricCar;
import test.auto.Engine;

public class MainClass07 {
	public static void main(String[] args) {
		//생성자의 인자로 Engine 객체를 전달하면서 ElectricCar 객체 생성하기 
		ElectricCar car1=new ElectricCar(new Engine());
		car1.drive();
		car1.charge();
	}
}
