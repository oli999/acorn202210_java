package test.main;

import test.mypac.Bike;

public class MainClass08 {
	public static void main(String[] args) {
		String[] names={"김구라","해골","원숭이","주뎅이","덩어리"};
		
		for(String tmp:names) {
			System.out.println(tmp);
		}
		
		Bike[] bikes=new Bike[3]; // {null, null, null}
		//2. 
		bikes[0]=new Bike();
		bikes[1]=new Bike();
		bikes[2]=new Bike();
		
		for(Bike tmp:bikes) {
			tmp.ride();
		}
	}
}








