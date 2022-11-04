package test.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 *  1. JTextField에 문자열을 입력하고 추가 버튼을 누르면
 *  입력한 문자열이 myFolder/memo.txt파일에 append 되도록 해보세요.
 * 
 *  2. 불러오기 버튼을 누르면 myFolder/memo.txt 파일에 있는 모든 문자열을
 *  JTextArea에 출력하도록 해보세요.
 */
public class QuizMain extends JFrame implements ActionListener {
   JTextField inputMsg;
   JTextArea ta;

   public QuizMain(String title) {
      super(title);
      setBounds(100, 100, 500, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new FlowLayout(FlowLayout.CENTER));
      //다른 메소드에서 사용할수 있도록 UI 의 참조값을 객체의 필드에 저장하기 
      inputMsg = new JTextField(10);
      ta = new JTextArea();
      JButton addBtn = new JButton("추가");
      JButton callBtn = new JButton("불러오기");

      add(inputMsg);
      add(addBtn);
      add(callBtn);
      add(ta);
      //버튼을 눌렀을때 호출되는 메소드를 가지고 있는 객체 등록 
      addBtn.addActionListener(this);
      callBtn.addActionListener(this);
      //JTextArea 를 출력 전용으로 사용하겠다는 의미 
      ta.setEditable(false);
      setVisible(true);
   }

   public static void main(String[] args) {
      new QuizMain("QuizMain");
   }
   
   //ActionListener 인터페이스를 구현했기 때문에 재정의한 메소드  
   @Override
   public void actionPerformed(ActionEvent e) {
	 
      File memoFile = new File("c:\\acorn202210\\myFolder\\memo.txt");
      //필요한 객체를 담을 지역 변수를 미리 만들기 
      FileReader fr = null;
      BufferedReader br = null;
      FileWriter pw=null;
      try {
         String command = e.getActionCommand();
         if(command.equals("추가")) {
        	//입력한 문자열을 읽어온다. 
            String msg = inputMsg.getText();
            //memo.txt 파일에 출력하기 
            pw = new FileWriter(memoFile, true);
            pw.write(msg+"\r\n");
            pw.flush();
         } else if(command.equals("불러오기")) {
            fr = new FileReader(memoFile);
            br = new BufferedReader(fr);
            //JTextArea 에 이미 출력된 내용을 일단 삭제하고 
            ta.setText("");
            while (true) {//반복문 돌면서 
            	//문자열을 한줄씩 읽어들인다.
            	String line = br.readLine();
            	if (line == null) {//더이상 읽을 문자열이 없으면
            		break;//반복문 탈출
            	}
            	//읽은 문자열 한줄을 개행기호와 함께 JTextArea 객체에 출력하기 
            	ta.append(line+"\r\n"); 
            }
         }
      } catch (Exception e1) {
         e1.printStackTrace();
      } finally {
         // exception이 발생하건 안하건 실행할 수 있는 공간에서 마무리작업을 해준다.
         try {
            // 혹시 모를 null 로 넘어오는 상황을 위해 대비
            // 닫는 작업은 열린 순서의 역순으로 하면 좋다.
            if(br != null) br.close();
            if(fr != null) fr.close();
            if(pw != null) pw.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
   }
}