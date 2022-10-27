package test.main;

import test.mypac.SmartPhone;

public class MainClass05 {
	public static void main(String[] args) {
		SmartPhone p1=new SmartPhone();
		p1.call(); // Phone 의 기능
		p1.mobileCall(); // HandPhone 의 기능
		p1.takePicture(); // HandPhone 의 기능
		p1.doInternet(); // SmartPhone 의 기능
	}
}
