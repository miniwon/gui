package c_sample;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 *  화면(JFrame)에 '확인' 버튼 하나 출력
 *  가운데에 작게 나오게
 *  
 */

public class EventTest2 {
	
	// 1. 변수 선언
	JFrame f;
	JButton yes;

	// 2. 변수 객체 생성
	EventTest2() {
		f = new JFrame("EventTest2");
		yes = new JButton("확인2");
		
	// (2) 핸들러 객체 생성(핸들러도 클래스니까)
//		MyHandler hdlr = new MyHandler();
	
	// (3) 이벤트가 발생할 컴포넌트와 연결
		yes.addActionListener(new MyHandler());
	}
	
	// (1) 이벤트 핸들러 만들기
	//		핸들러 - 이벤트 처리 클래스
	class MyHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "이벤트 발생2");
		}
	}
	
	// 3. 화면 구성하고 출력
	public void addLayout() {
		f.setLayout(new FlowLayout());
		f.add(yes);
		
		f.setBounds(100, 100, 500, 500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		EventTest2 event = new EventTest2();
		event.addLayout();

	}

}
