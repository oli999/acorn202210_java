package test.mypac;
/*
 *  새로운 스레드 만드는 방법2
 *  
 *  1. Runnable 인터페이스를 구현한 클래스를 정의한다.
 *  2. run() 메소드를 강제 오버라이드 한다.
 *  3. Thread 클래스로 객체를 생성하면서 해당클래스로 만든 객체를 생성자의 인자로 전달한다.
 *  4. Thread 클래스로 만든 객체의 start() 메소드를 호출해서 스레드를 시작 시킨다.
 */
public class CountRunnable implements Runnable{

	@Override
	public void run() {
		//카운트 값을 저장할 지역변수 만들고 초기 값 대입
		int count=10;
		while(true) {
			System.out.println("현재 카운트:"+count);
			if(count==0) {//만일 count 가 0 이면
				break; //반복문 탈출(반복문 탈출하면 run() 메소드가 리턴되기 때문에 스레드가 종료된다)
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count--;
		}		
	}

}
