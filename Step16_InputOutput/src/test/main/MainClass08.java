package test.main;

import java.io.File;

public class MainClass08 {
	public static void main(String[] args) {
		File f=new File("c:/");
		//파일객체 목록(File[]) 을 얻어내기 
		File[] files=f.listFiles();
		
		for(File tmp:files) {
			if(tmp.isDirectory()) {
				//대괄호를 디렉토리명 양쪽에 출력하기 
				System.out.println("[ "+tmp.getName()+" ]");
			}else {
				//파일이면 파일명만 출력
				System.out.println(tmp.getName());
			}
		}
	}
}
