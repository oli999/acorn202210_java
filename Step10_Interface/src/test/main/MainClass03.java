package test.main;

import test.mypac.Remocon;

public class MainClass03 {
	// anonymous inner class 를 이용해서 interface type 의 참조값을 얻어내기
	// static 메소드 안에서 사용해야 되기 때문에 static 필드로 만들어 준다. 
	static Remocon r1=new Remocon() {
		@Override
		public void up() {
			System.out.println("온도를 올려요");
		}
		
		@Override
		public void down() {
			System.out.println("온도를 내려요");
		}
	};
	
	public static void main(String[] args) {
		useRemocon(r1);
		// anonymous local inner class 를 이용해서 interface type 의 참조값을 얻어내기
		Remocon r2=new Remocon() {
			@Override
			public void up() {
				System.out.println("속도를 올려요");
			}
			@Override
			public void down() {
				System.out.println("속도를 내려요");
			}
		};
		useRemocon(r2);
		//메소드 호출하면서 Remocon type 을 즉석에서 얻어내서 전달하기 
		useRemocon(new Remocon() {	
			@Override
			public void up() {
				System.out.println("고도를 올려요");
			}
			
			@Override
			public void down() {
				System.out.println("고도를 내려요");
			}
		});
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
















