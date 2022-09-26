package a_sample;

import java.awt.*;

import javax.swing.*;
/*
 *		자바의 GUI(화면)
 *		 - AWT: 1.2 이전
 *		 - Swing: 1.2 이후
 *				  대부분 클래스 앞에 J
 */

public class ATest {

	JFrame f;
	JButton btn, bCancel;
	JCheckBox cbJava, cbOracle;
	JRadioButton rbMale, rbFemale;
	JTextField tf;
	JTextArea ta;
	
	
	ATest () {
		f = new JFrame("나의 첫 창");
		btn = new JButton("클릭");
		bCancel = new JButton("취소");
		cbJava = new JCheckBox("자바", true);
		cbOracle = new JCheckBox("오라클");
		rbMale = new JRadioButton("남자");
		rbFemale = new JRadioButton("여자");
		ButtonGroup bts = new ButtonGroup();
		bts.add(rbMale);
		bts.add(rbFemale);
		tf = new JTextField(20);		// 1줄 입력
		ta = new JTextArea(40, 20);		// 2줄 입력
	}
	
	void addLayout() {
//		FlowLayout f1 = new FlowLayout();		// FlowLayout: 1줄에 배치
//		f.setLayout(new FlowLayout());
//		f.setLayout(new GridLayout(3, 3));		// GridLayout: 행, 열에 맞춰 배치
		f.setLayout(new BorderLayout());		// 동/서/남/북/가운데 배치
		
		// 붙이기 작업
		f.add(btn, BorderLayout.NORTH);
		f.add(bCancel, BorderLayout.SOUTH);
//		f.add(cbJava);
//		f.add(cbOracle);
		JPanel pEast = new JPanel();
		pEast.add(rbMale);
		pEast.add(rbFemale);
		f.add(pEast, BorderLayout.EAST);
		f.add(new JLabel("입력하세요"), BorderLayout.WEST);
//		f.add(tf, BorderLayout.EAST);
		f.add(ta, BorderLayout.CENTER);
		
		// 화면 출력
		f.setBounds(100, 100, 500, 350);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		ATest a = new ATest();
		a.addLayout();				// 윈도우창을 자바에서는 프레임이라고 부른다
		

	}

}
