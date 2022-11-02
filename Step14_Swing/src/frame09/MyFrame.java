package frame09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/*
 *  JTextField 객체의 메소드를 잘 활용해서 
 *  
 *  메세지를 입력하고 전송 버튼을 누르면 
 *  
 *  입력한 메세지가 알림창에 출력되도록 프로그래밍 해 보세요
 * 
 */

public class MyFrame extends JFrame implements ActionListener{
	//필드
	JTextField inputMsg;
	
	//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//흐르듯이 배치하는 레이아웃
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//문자열을 한줄 입력할수 있는 JTextField 객체를 생성해서 참조값을 필드에 담기 
		inputMsg=new JTextField(10);
		JButton sendBtn=new JButton("전송");
		
		add(inputMsg);
		add(sendBtn);
		
		//ActionListener 인터페이스를 구현한 MyFrame 객체를 액션 리스너로 등록을 한다. 
		sendBtn.addActionListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임9");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//1. JTextField 에 입력한 문자열을 읽어와서 
		String msg=inputMsg.getText();
		//2. 알림창에 출력하기 
		JOptionPane.showMessageDialog(this, msg);
	}
}























