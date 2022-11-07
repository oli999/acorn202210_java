package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 *  Data Access Object 만들어 보기
 *  
 *  - DB 에 insert, update, delete, select 작업을 대신해 주는 객체를 생성할 클래스 설계하기 
 */
public class MemberDao {
	
	//회원 한명의 정보를 저장하고 작업의 성공 여부를 리턴해주는 메소드 
	public boolean insert(MemberDto dto) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		//수정된 row 의 갯수를 담을 지역변수를 미리 만들고 초기값 0 대입하기 
		int rowCount=0;
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩하기 
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			//sql 문 실행하고 변화된(추가,수정,삭제) row 의 갯수를 리턴받기 
	        rowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}	
		//변화된 rowCount 값을 확인해서 작업의 성공 여부를 리턴해 준다. 
		if(rowCount>0) {
        	return true;
        }else {
        	return false;
        }
	}
	//회원 한명의 정보를 수정하고 작업의 성공 여부를 리턴해주는 메소드
	public boolean update(MemberDto dto) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		//수정된 row 의 갯수를 담을 지역변수를 미리 만들고 초기값 0 대입하기 
		int rowCount=0;
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="UPDATE member"
					+ " SET name=?, addr=?"
					+ " WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩하기 
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			//sql 문 실행하고 변화된(추가,수정,삭제) row 의 갯수를 리턴받기 
	        rowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}	
		//변화된 rowCount 값을 확인해서 작업의 성공 여부를 리턴해 준다. 
		if(rowCount>0) {
        	return true;
        }else {
        	return false;
        }
	}
	//회원 한명의 정보를 삭제하고 작업의 성공 여부를 리턴해주는 메소드
	public boolean delete(int num) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		//수정된 row 의 갯수를 담을 지역변수를 미리 만들고 초기값 0 대입하기 
		int rowCount=0;
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
			//sql 문 실행하고 변화된(추가,수정,삭제) row 의 갯수를 리턴받기 
	        rowCount=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}	
		//변화된 rowCount 값을 확인해서 작업의 성공 여부를 리턴해 준다. 
		return rowCount>0 ? true:false;
	}
	
	//전체 회원의 목록을 리턴해주는 메소드
	public List<MemberDto> getList(){
		
		//회원 전체 목록을 담을 ArrayList 객체를 생성해서 참조값을 List 인터페이스 type 으로 담기
		List<MemberDto> list=new ArrayList<>();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="SELECT num, name, addr"
					+ " FROM member"
					+ " ORDER BY num ASC";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//? 에 값 바인딩
			rs=pstmt.executeQuery();
			while(rs.next()) {
				//커서가 위치한 곳의 회원정보를 MemberDto 객체에 담기
				MemberDto dto=new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				//회원 한명의 정보가 담긴 MemberDto 객체의 참조값을 ArrayList 객체에 누적 시키기
				list.add(dto);
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
		//모든 회원의 정보가 누적된 ArrayList 객체의 참조값 리턴해 주기 
		return list;
	}
	//인자로 전달된 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드 
	//번호에 해당하는 회원의 정보가 없으면 null 을 리턴 
	public MemberDto getData(int num) {
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






















