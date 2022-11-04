package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.mypac.Member;
import test.util.DBConnect;

public class MainClass07 {
	public static void main(String[] args) {
		//추가할 회원의 정보
		String name="주뎅이";
		String addr="봉천동";
		
		//추가할 회원의 정보를 Member 객체에 담고
		Member mem=new Member();
		//객체의 필드가 public 공개 필드 이기 때문에 대입연산자로 직접 참조해서 필드에 값을 대입할수 있다.
		mem.name=name;
		mem.addr=addr;
		//insert() 메소드 호출하면서 Member 객체 전달하기 
		insert(mem);
	}
	
	//회원 한명의 정보를 추가하는 메소드 만들기
	public static void insert(Member m) {
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
			pstmt.setString(1, m.name);
			pstmt.setString(2, m.addr);
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








