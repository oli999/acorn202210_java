package test.main;

import test.util.MyUtil;

public class MainClass08 {
	public static void main(String[] args) {
		//상속 받은 BaseUtil 클래스에 정의된 static 메소드도 모두 사용가능 
		MyUtil.send();
		MyUtil.clear();
		MyUtil.light();
	}
}
