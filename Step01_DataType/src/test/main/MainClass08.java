package test.main;

public class MainClass08 {
	public static void main(String[] args) {
		String str="abcde12345";
		int result=str.length();
		char result2=str.charAt(4);
		/*
		 *  String 객체의 메소드를 활용해서 
		 *  str 변수 안에 있는 문자를 모두 대문자(UpperCase)로 변환해서
		 *  str2 라는 이름의 변수에 담아 보세요.
		 */
		String str2=str.toUpperCase();
		
		String greet="Hello! mimi, Bye! mimi";
		//위의 문자열에서 mimi 라는 문자열을 mama 라는 문자열로 교체 해서 결과를 greet2 에 담아 보세요
		//단, String 객체의 메소드를 활용해서 
		String greet2=greet.replace("mimi", "mama");
		
		String message="My name is Kimgura";
		/*
		 *  1. 위의 문자열이 My 라는 문자열로 시작 하는지 여부(true or false)를  isStart 라는 변수에 담아 보세요
		 *  
		 *  2. 위의 문자열에서  i 가 문자열의 몇번째 인덱스에 위치하고 있는지를 index 라는 변수에 담아 보세요.
		 */
		boolean isStart=message.startsWith("My");
		int index=message.indexOf("i");
	}
}















