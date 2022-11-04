package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import test.mypac.Member;
import test.util.DBConnect;

public class MainClass08 {
	public static void main(String[] args) {
		//추가할 회원의 정보
		String name="주뎅이";
		String addr="봉천동";
		
		//추가할 회원의 정보를 HashMap 객체에 key : value 의 쌍으로 저장한 다음
		Map<String, Object> map=new HashMap<>();
		map.put("name", name);
		map.put("addr", addr);
		
		//insert() 메소드 호출하면서 Map 객체를 전달!
		insert(map);
	}
	
	//회원 한명의 정보를 추가하는 메소드 만들기
	public static void insert(Map<String, Object> m) {
		//Map 에 저장된 회원의 이름과 주소를 읽어와서 
		String name=(String)m.get("name");
		String addr=(String)m.get("addr");
		//insert 작업을 위해서 필요한 객체의 참조값을 담을 지역 변수 미리 만들기 
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			//sql 문 실행하기
	        pstmt.executeUpdate();
	        System.out.println("회원 정보를 추가했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
	}
}








