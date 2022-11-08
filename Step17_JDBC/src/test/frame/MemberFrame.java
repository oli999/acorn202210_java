package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener{
   //필드
   JTextField inputName, inputAddr;
   DefaultTableModel model;
   JTable table;
   
   //생성자
   public MemberFrame() {
      //레이아웃 메니저 설정 
      setLayout(new BorderLayout());
      
      JLabel label1=new JLabel("이름");
      inputName=new JTextField(10);
      
      JLabel label2=new JLabel("주소");
      inputAddr=new JTextField(10);
      
      JButton saveBtn=new JButton("저장");
      saveBtn.setActionCommand("save");
      
      JButton deleteBtn=new JButton("삭제");
      deleteBtn.setActionCommand("delete");
      
      //페널에 UI 를 배치하고    
      JPanel panel=new JPanel();
      panel.add(label1);
      panel.add(inputName);
      panel.add(label2);
      panel.add(inputAddr);
      panel.add(saveBtn);
      panel.add(deleteBtn);
      //페널째로 프레임의 북쪽에 배치 
      add(panel, BorderLayout.NORTH);      
      
      //표형식으로 정보를 출력하기 위한 JTable
      table=new JTable();
      //칼럼명을 String[] 에 순서대로 준비
      String[] colNames= {"번호", "이름", "주소"};
      //테이블에 연결할 모델객체(테이블에 출력할 데이터를 가지고 있는 객체)
      model=new DefaultTableModel(colNames, 0); 
      //모델을 테이블에 연결한다.
      table.setModel(model);
      //스크롤이 가능 하도록 테이블을 JScrollPane 에 감싼다.
      JScrollPane scroll=new JScrollPane(table);
      //JScrollPane  을 프레임의 가운데에 배치하기 
      add(scroll, BorderLayout.CENTER);
      
      //버튼에 리스너 등록 
      saveBtn.addActionListener(this);
      deleteBtn.addActionListener(this);
      
      displayMember();
   }
   
   //테이블에 회원 목록을 출력하는 메소드
   public void displayMember() {
      /*
      //sample 데이터 
      Object[] row1= {1, "김구라", "노량진"};
      Object[] row2= {2, "해골", "행신동"};
      Object[] row3= {3, "원숭이", "동물원"};
      //sample 데이터를 DefaultTableModel 객체에 추가 하기 
      model.addRow(row1);
      model.addRow(row2);
      model.addRow(row3);
      */
      
      //MemberDao 객체의 .getList() 메소드가 리턴해주는 데이터를 활용해서 회원목록을 출력해 보세요.
      
      model.setRowCount(0); //테이블에 출력된 데이터 reset 
      
      List<MemberDto> list=new MemberDao().getList();
      
      //반복문 돌면서 순서대로 MemberDto 객체를 참조해서 
      for(MemberDto tmp:list) {
         //Object 배열로 만든 다음 
         Object[] row= {tmp.getNum(), tmp.getName(), tmp.getAddr()};
         //모델에 추가
         model.addRow(row);
      }
   }
   
   public static void main(String[] args) {
      MemberFrame f=new MemberFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setBounds(100, 100, 800, 500);
      f.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String command=e.getActionCommand();
      if(command.equals("save")) {
         //입력한 이름과 주소를 읽어와서
         String name=inputName.getText();
         String addr=inputAddr.getText();
         //MemberDto 객체에 담고
         MemberDto dto=new MemberDto();
         dto.setName(name);
         dto.setAddr(addr);
         //MemberDao 객체를 이용해서 DB 에 저장하기 
         boolean isSuccess=new MemberDao().insert(dto);
         if(isSuccess) {
            JOptionPane.showMessageDialog(this, name+" 의 정보를 추가 했습니다.");
            displayMember();
         }else {
            JOptionPane.showMessageDialog(this, "Oops! 실패 했습니다");
         }
      }else if(command.equals("delete")) {
         //1. JTable 의 선택된 row 의 인덱스를 읽어와서 (table 활용)
         int rowIndex=table.getSelectedRow();
         if(rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "삭제할 row 를 선택하세요!");
            return;
         }
         //2. DefaultTableModel 에서 해당 인덱스의 table row 에서 삭제할 회원의 번호를 읽어와서(model 활용)
         int num =(int)model.getValueAt(rowIndex, 0);
         //3. MemberDao 객체를 이용해서 DB 에서 삭제하고
         new MemberDao().delete(num);
         //4. 새로 고침하기 
         displayMember();
      }
      
   }
}














