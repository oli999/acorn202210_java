package test.main;

import test.mypac.Rect;

public class MainClass06 {
	public static void main(String[] args) {
		//폭과 높이가 10, 20 인 사각형 객체
		Rect r1=new Rect();
		r1.width=10;
		r1.height=20;
		r1.showArea();
		
		//폭과 높이가 5, 10 인 사각형 객체 
		Rect r2=new Rect();
		r2.width=5;
		r2.height=10;
		r2.showArea();
	}
}
