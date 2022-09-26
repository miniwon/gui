package a_sample;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BTest extends JFrame {

	JButton btn;
	
	BTest() {
		super("나의 두 번째 창");
		btn = new JButton("확인2");
	}
	
	void addLayout() {
		
		add(btn);
		
		setBounds(100, 100, 500, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		BTest b = new BTest();
		b.addLayout();
		
		
	}

}
// ATest는 객체를 생성하여 사용
// BTest는 상속을 받아서 내 것처럼 사용