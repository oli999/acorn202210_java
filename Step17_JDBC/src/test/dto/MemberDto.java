package test.dto;

public class MemberDto {
	//회원 한명의 정보를 저장할 필드(보통 테이블의 칼럼명과 일치 시킨다)
	private int num;
	private String name;
	private String addr;
	
	//디폴트 생성자 
	public MemberDto() {}

	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	
	
	
}






