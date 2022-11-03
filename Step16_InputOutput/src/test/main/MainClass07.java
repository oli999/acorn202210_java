package test.main;

import java.io.File;

public class MainClass07 {
	public static void main(String[] args) {
		// c:/ 를 Access 할수 있는 파일 객체 생성
		File f=new File("c:/");
		String[] names=f.list();
		//배열에 들어 있는 문자열 모두 출력하기 
		for(int i=0; i<names.length; i++) {
			String tmp=names[i];
			System.out.println(tmp);
		}
		
		System.out.println("-------------------");
		
		for(String tmp:names) {
			System.out.println(tmp);
		}
	}
}
