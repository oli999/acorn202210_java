package test.main;

import java.io.File;

public class MainClass10 {
	public static void main(String[] args) {
		File f1=new File("c:/acorn202210/myFolder/folder1");
		//폴더 만들기
		f1.mkdir();
		
		for(int i=0; i<1000; i++) {
			File tmp=new File("c:/acorn202210/myFolder/folder"+i);
			//tmp.mkdir(); //폴더 만들기
			tmp.delete(); //폴더 삭제하기 
		}
	}
}
