package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainClass09 {
	public static void main(String[] args) {
		Set<String> names=new HashSet<>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		names.add("주뎅이");
		names.add("덩어리");
		
		//반복자(Iterator) 객체 얻어내기 (저장된 item 을 일렬로 세웠다고 생각하면됨)
		Iterator<String> it=names.iterator();
		//cursor 다음에 item 이 있는 동안에만 반복문을 돌면서 
		while(it.hasNext()) {
			//cursor 를 다음칸으로 이동해서 커서가 위치한 곳의 item 을 읽어오기 
			String item=it.next();
			System.out.println(item);
		}
		//특정 item(데이터, 참조값) 존재 여부 알아내기
		boolean isContain=names.contains("김구라");
		//저장된 item 의 갯수
		int size=names.size();
		//특정 item 삭제 
		names.remove("해골");
		//모든 아이템 삭제
		names.clear();
		
	}
}











