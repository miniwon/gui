package d_calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalTest {
	
	// 1. 멤버변수 선언
	JFrame f;
	JTextField tf;
	JButton[] bNum;		// 0~9 숫자 표현 버튼[10]
	JButton[] bOp;		// +, -, *, / 연산자를 표현할 버튼들
	JButton bEqual;
	
	
	// 2. 객체 생성
	CalTest(){
		f = new JFrame("유치원 계산기");	// 창(프레임) 생성
		tf = new JTextField(20);		// 텍스트필드 생성
		
		bNum = new JButton[10];			// 
		bOp = new JButton[4];
		bEqual = new JButton();
		
		String[] option = new String[] {"+", "-", "*", "/"};
		
		for (int i = 0; i < bNum.length; i++) {	// 각 버튼에 번호 주기
			bNum[i] = new JButton(Integer.toString(i));
		}
		for (int i = 0; i < bOp.length; i++ ) {
			bOp[i] = new JButton(option[i]);
		}
		
//		bOp[0] = new JButton("+");
//		bOp[1] = new JButton("-");
//		bOp[2] = new JButton("*");
//		bOp[3] = new JButton("/");
		
		bEqual = new JButton("=");
		
	} // end of CalTest(){}
	
	// 3. 화면 구성 및 화면 출력
	void addLayout() {
		
		f.setLayout(new BorderLayout());
		
		JPanel pSouth = new JPanel();
		pSouth.setLayout(new GridLayout(5, 3));
		for(int i = 1 ; i < 10; i++) {
			pSouth.add(bNum[i]);
		}
		pSouth.add(bOp[0]);
		pSouth.add(bNum[0]);
		pSouth.add(bEqual);
		pSouth.add(bOp[1]);
		pSouth.add(bOp[2]);
		pSouth.add(bOp[3]);
		f.add(pSouth, BorderLayout.SOUTH);
		pSouth.setPreferredSize(new Dimension(400, 300));
		
		f.add(tf, BorderLayout.NORTH);
		tf.setPreferredSize(new Dimension(400, 50));
		
		f.setBounds(100, 100, 400, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	} // addLayout()
	
	// 계산
	int first;
	int second;
	String op;
	
	void eventProc() {
		

		
		// 숫자 버튼이 눌렸을 때
		for ( int i = 0; i < bNum.length; i++ ) {
			bNum[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// getSource(): 이벤트 발생 컴포넌트의 참조값을 얻어 오는 메서드
					JButton eBtn = (JButton)e.getSource();
					String su = eBtn.getText();
					tf.setText(su);
				}
			});
		}	// for
		
//		for (int i = 0; i < bNum.length; i++) {
//		bNum[i].addActionListener(new ActionListener() {
//			String s = Integer.toString(i);
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				tf.setText(s);		// i가 final이 아니라 불가능
//			}
//		});}
		
		// 연산자 버튼이 눌렸을 때
		for ( int i = 0; i < bOp.length; i++ ) {
			bOp[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton eBtn = (JButton)e.getSource();
					op = eBtn.getText();
					first = Integer.parseInt(tf.getText());
				}
			});
		}	// for
		
		
		// = 버튼이 눌렸을 때
		bEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				second = Integer.parseInt(tf.getText());
				switch (op) {
				case "+": first += second; break;
				case "-": first -= second; break;
				case "*": first *= second; break;
				case "/": first /= second; break;
				}
				tf.setText(Integer.toString(first));
			}
		});
		
		
		

		
		
		

		
	} // eventProc()
	
	public static void main(String[] args) {
		CalTest cal = new CalTest();
		cal.addLayout();
		cal.eventProc();
	}

}
