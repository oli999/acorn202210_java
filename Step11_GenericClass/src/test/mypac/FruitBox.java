package test.mypac;
/*
 *  클래스 안에서 사용하는 특정 type 을 고정하지 않고 
 *  
 *  클래스를 사용하는 시점에 type 을 정할수 있게 할수 있다.
 *  
 *  - 아래 선언한 T 는 마음대로 스펠링이나 단어를 정할수 있다.
 *    보통 type 이라는 의미에서 T 라고 많이 정한다. 
 *  - T 를 포괄 클래스(Generic Class) 라고 한다. 
 */
public class FruitBox<T> {
	//필드
	private T item; //클래스를 사용하는 시점에 전달된 type 을 필드의 type 으로 사용하기 
	
	//필드에 값을 넣는 메소드 
	public void setItem(T item) {
		this.item=item;
	}
	
	//필드에 저장된 값을 리턴하는 메소드
	public T getItem() {
		return item;
	}	
}













