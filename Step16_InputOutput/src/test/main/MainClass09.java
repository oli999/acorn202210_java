package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass09 {
	public static void main(String[] args) {
		//이미 존재하거나 혹은 만들 예정인 파일을 제어할수 있는 File 객체 생성 
		File f1=new File("c:/acorn202210/myFolder/gura.txt");
		try {
			//만일 해당 파일이 존재하지 않으면
			if(!f1.exists()) {
				f1.createNewFile();
				System.out.println("gura.txt 파일을 만들었습니다.");
			}else {
				f1.delete();
				System.out.println("gura.txt 파일을 삭제 했습니다.");
			}
			
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}





