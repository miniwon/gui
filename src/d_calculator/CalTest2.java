package d_calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalTest2 {

	// 1. 멤버변수 선언
	JFrame f;
	JTextField tf;
	JButton[] bNum;		// 0~9 숫자 표현 버튼[10]
	JButton[] bOp;		// +, -, *, / 연산자를 표현할 버튼들
	JButton bEqual;


	// 2. 객체 생성
	CalTest2(){
		f = new JFrame("초등학교 계산기");	// 창(프레임) 생성
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
	String input = "";
	int intFirst = 0;
	int intSecond = 0;
	String op = null;
	void eventProc() {


		// 숫자 버튼이 눌렸을 때
		for ( int i = 0; i < bNum.length; i++ ) {
			bNum[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// getSource(): 이벤트 발생 컴포넌트의 참조값을 얻어 오는 메서드
					JButton eBtn = (JButton)e.getSource();
					String su = eBtn.getText();
					//tf.setText(su);
					//input += tf.getText();
					input += su;
					tf.setText(input);
				}
			});
		}	// for


		// 연산자 버튼이 눌렸을 때
		for ( int i = 0; i < bOp.length; i++ ) {
			bOp[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton eBtn = (JButton)e.getSource();
					op = eBtn.getText();
					if( intFirst == 0) { intFirst = Integer.valueOf(input); }
					input = "";
					tf.setText("");
				}
			});
		}	// for


		// = 버튼이 눌렸을 때
		bEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intSecond = Integer.parseInt(input);
				switch (op) {
				case "+": intFirst += intSecond; break;
				case "-": intFirst -= intSecond; break;
				case "*": intFirst *= intSecond; break;
				case "/": intFirst /= intSecond; break;
				}
				tf.setText(Integer.toString(intFirst));


			}
		});









	} // eventProc()

	public static void main(String[] args) {
		CalTest2 cal = new CalTest2();
		cal.addLayout();
		cal.eventProc();
	}

}
