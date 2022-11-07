package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass14 {
	public static void main(String[] args) {
		//추가할 회원의 정보라고 가정 
		String name="원숭이";
		String addr="동물원";
		
		/*
		 *  MemberDao 객체를 생성해서 참조값을 dao 라는 지역 변수에 담기
		 */
		MemberDao dao=new MemberDao();
		
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		boolean isSuccess=dao.insert(dto);
		
		if(isSuccess) {
			System.out.println(name+" 의 정보를 추가 했습니다.");
		}else {
			System.out.println("회원정보 추가 실패!");
		}
	}
}










