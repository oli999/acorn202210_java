package test.main;

import test.mypac.Weapon;

public class MainClass06 {
	
	static Weapon w1=new Weapon() {
		@Override
		public void attack() {
			System.out.println("편하게 공격해요");
		}
	};
	
	public static void main(String[] args) {
		Weapon w2=new Weapon() {
			@Override
			public void attack() {
				System.out.println("아무나 공격!");
			}
		};
		
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("공격! 공격!");
			}
		});
		
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}	
}













