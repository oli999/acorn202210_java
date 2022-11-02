package frame11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	//필드
	JTextField tf_num1, tf_num2;
	JLabel label_result;
	
	
	//default  생성자
	public MyFrame() {
		//프레임의 레이아웃 법칙 설정하기 
		setLayout(new BorderLayout());
		
		//JPanel
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.YELLOW);
		//Panel 을 북쪽에 배치하기 
		add(topPanel, BorderLayout.NORTH);
		
		//JTextField 객체를 만들에서 JPanel 에 추가하기 
		tf_num1=new JTextField(10);
		topPanel.add(tf_num1);
		//기능 버튼 객체를 만들어서 JPanel 에 추가하기
		JButton plusBtn=new JButton("+");
		JButton minusBtn=new JButton("-");
		JButton multiBtn=new JButton("*");
		JButton divideBtn=new JButton("/");
		topPanel.add(plusBtn);
		topPanel.add(minusBtn);
		topPanel.add(multiBtn);
		topPanel.add(divideBtn);
		//두번째 JTextField  만들어서 페널에 추가 하기 
		tf_num2=new JTextField(10);
		topPanel.add(tf_num2);
		//JLabel
		JLabel label1=new JLabel("=");
		label_result=new JLabel("0");
		//페널에 레이블 추가하기
		topPanel.add(label1);
		topPanel.add(label_result);
		
		//버튼에 리스너 등록하기
		plusBtn.addActionListener(this);
		minusBtn.addActionListener(this);
		multiBtn.addActionListener(this);
		divideBtn.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		//MyFrame 클래스를 이용해서 객체 생성하고 참조값을 지역변수 frame 에 담기 
		MyFrame frame=new MyFrame();
		//프레임의 제목 설정
		frame.setTitle("계산기");
		//프레임을 닫으면 자동으로 프로세스가 종료 되도록 한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			//1. 입력한 문자열을 읽어와서 숫자로 바꿔준다.
			double num1=Double.parseDouble(tf_num1.getText());
			double num2=Double.parseDouble(tf_num2.getText());
			//2. 어떤 버튼을 눌렀는지 알아내서 적절한 연산을 해서 결과를 얻어낸다.
			String command=e.getActionCommand(); // "+" "-" "*" "/" 
			//연산의 결과를 담을 지역변수를 미리 만들어 놓는다.
			double result=0;
			if(command.equals("+")) {
				result=num1+num2;
			}else if(command.equals("-")) {
				result=num1-num2;
			}else if(command.equals("*")) {
				result=num1*num2;
			}else if(command.equals("/")) {
				result=num1/num2;
			}
			//3. 연산의 결과를 출력한다.
			//연산의 결과를 문자열로 만든다.
			String resultNum=Double.toString(result);
			label_result.setText(resultNum);
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(this, "숫자 형식으로 입력해 주세요.");
			tf_num1.setText("");
			tf_num2.setText("");
		}
	}
}


















