package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass16 {
	public static void main(String[] args) {
		
		//필요한 참조값을 담을 지역 변수를 미리 만든다.
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			//파일에서 byte 를 읽어낼 객체 
			fis=new FileInputStream("c:/acorn202210/myFolder/bottle.png");
			//파일에 byte 를 출력할 객체 
			fos=new FileOutputStream("c:/acorn202210/myFolder/copied2.png");
			
			//byte[] 객체를 미리 준비한다.
			byte[] buffer=new byte[1024]; //한번에 1kilo byte 씩 읽어낼수 있는 byte 배열 
			
			while(true) {
				//byte[] 배열을 메소드의 인자로 전달해서 읽어들이고 몇개를 읽어들였는지 리턴 받는다.
				int readedByte=fis.read(buffer);
				if(readedByte==-1) {
					break;
				}
				//byte[] 배열의 0 번방에서 부터 읽은 만큼만 출력하기
				fos.write(buffer, 0, readedByte);
				fos.flush();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fos!=null)fos.close();
				if(fis!=null)fis.close();
			}catch(Exception e) {}
		}
	}
}







