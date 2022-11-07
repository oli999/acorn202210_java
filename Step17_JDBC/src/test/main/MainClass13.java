package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass13 {
	public static void main(String[] args) {
		//메소드를 호출해서 인자로 전달한 번호에 해당하는 회원 정보를 얻어오기
		MemberDto dto=getData(1);
		if(dto == null) {
			System.out.println("해당 회원은 존재하지 않습니다.");
		}else {
			System.out.println("번호:"+dto.getNum()+" 이름:"+dto.getName()+" 주소:"+dto.getAddr());
		}
	}
	
	//인자로 전달된 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드 
	//번호에 해당하는 회원의 정보가 없으면 null 을 리턴 
	public static MemberDto getData(int num) {
		//MemberDto 객체의 참조값을 담을 지역변수 미리 만들기 
		MemberDto dto=null;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="SELECT num, name, addr"
					+ " FROM member"
					+ " WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//? 에 값 바인딩
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			//만일 cursor 를 한칸 내릴수 있다면(select 된 row 가 있다면)
			if(rs.next()) {
				//MemberDto 객체를 생성해서 참조값을 미리 만들어진 지역변수 dto 에 담기 
				dto=new MemberDto();
				//cursor 가 위치한 곳의 회원정보를 MemberDto 객체에 담기 
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		//회원 한명의 정보를 담고 있는 MemberDto 객체 리턴해주기 
		return dto;		
	}
}
