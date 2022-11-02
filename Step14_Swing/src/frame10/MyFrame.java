package frame10;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//흐르듯이 배치하는 레이아웃
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JTextField inputMsg=new JTextField(10);
		JLabel label=new JLabel("레이블...");
	
		add(inputMsg);
		add(label);
		
		//키보드를 눌렀을때 호출될 메소드를 가지고 있는 KeyListener 인터페이스 type 객체 
		KeyListener listener=new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("keyTyped()");
			}
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed()");
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased()");
				//눌러진 키의 코드값 읽어오기
				int code=e.getKeyCode();
				System.out.println("code:"+code);
				//만일 엔터를 눌렀다면
				if(code == KeyEvent.VK_ENTER) { // code == 10
					//입력한 문자열을 읽어와서 
					String msg=inputMsg.getText();
					//Label 에 출력하기
					label.setText(msg);
				}
				
			}
			
		};
		
		inputMsg.addKeyListener(listener);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임10");
	}
}












