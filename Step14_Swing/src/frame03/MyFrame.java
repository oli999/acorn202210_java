package frame03;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//격자로 배치하는 레이아웃
		setLayout(new GridLayout(2, 2));
		
		JButton btn1=new JButton("버튼1");
		add(btn1); //프레임에 btn1 추가 하기 
		
		JButton btn2=new JButton("버튼2");
		add(btn2);
      
		JButton btn3=new JButton("버튼3");
		add(btn3);
		
		JButton btn4=new JButton("버튼4");
		add(btn4);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임3");
	}
}












