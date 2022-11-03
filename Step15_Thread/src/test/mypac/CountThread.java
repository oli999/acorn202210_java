package test.mypac;

public class CountThread extends Thread{
	
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
