package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
		//삭제할 회원의 번호라고 하자
		int num=4;
		delete(num);
	}
	
	//인자로 전달한 번호에 해당하는 회원 한명의 정보를 삭제하는 메소드
	public static void delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="DELETE FROM member"
					+ " WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩하기 
			pstmt.setInt(1, num);
			//sql 문 실행하기
	        pstmt.executeUpdate();
	        System.out.println("회원 정보를 삭제했습니다.");
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
