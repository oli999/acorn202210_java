package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
	public static void main(String[] args) {
		//콘솔창과 연결된 객체의 참조값 
		PrintStream ps=System.out;
		//학습을 위해서 PrintStream  객체를 부모type OutputStream 으로 받아보기
		//OutputStream 도 1byte 처리 스트림이다. (한글 처리 불가)
		OutputStream os=ps;
		
		try {
			os.write(97);
			os.write(98);
			os.write(99);
			os.flush(); //방출
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}










