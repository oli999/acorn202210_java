package test.mypac;

public class MyRemocon implements Remocon{

	@Override
	public void up() {
		System.out.println("체널을 올려요");
	}

	@Override
	public void down() {
		System.out.println("체널을 내려요");
	}

}
