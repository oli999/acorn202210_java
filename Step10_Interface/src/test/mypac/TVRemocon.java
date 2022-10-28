package test.mypac;

public class TVRemocon implements Remocon{

	@Override
	public void up() {
		System.out.println("TV 볼륨을 올려요");
	}

	@Override
	public void down() {
		System.out.println("TV 볼륨을 내려요");
	}

}
