package testHbg02;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelHbg extends JPanel {
	
	// 1. 멤버변수 선언
	JButton[] bts;		// 반복문 사용을 위해 버튼을 배열로 선언
	String[] menu = new String[] {"싸이버거", "휠렛버거", "할라피뇨통살버거", "화이트갈릭버거", "불고기버거", "갈릭바베큐치킨버거"};
	int[] price = new int[] {1000, 2000, 3000, 4000, 5000, 6000};
	
	// 2. 멤버변수 객체 생성(생성자 안에서)
	public PanelHbg () {
		
		// 버튼의 개수를 지정
		bts = new JButton[6];
		
		// 버튼 배열 안에 버튼 생성
		for ( int i = 0; i < bts.length; i++) {
			bts[i] = new JButton(menu[i]);
			bts[i].setHorizontalTextPosition(JButton.CENTER);
			bts[i].setVerticalTextPosition(JButton.BOTTOM);
		}
		
		// 이미지 삽입을 위해 .png 파일을 ImageIcon에 대입
		ImageIcon img1 = new ImageIcon("src/testHbgImgSource/1_싸이버거.png");
		ImageIcon img2 = new ImageIcon("src/testHbgImgSource/2_휠렛버거.png");
		ImageIcon img3 = new ImageIcon("src/testHbgImgSource/3_할라피뇨통살버거.png");
		ImageIcon img4 = new ImageIcon("src/testHbgImgSource/4_화이트갈릭버거.png");
		ImageIcon img5 = new ImageIcon("src/testHbgImgSource/5_불고기버거.png");
		ImageIcon img6 = new ImageIcon("src/testHbgImgSource/6_갈릭바베큐치킨버거.png");
		
		// 버튼에 이미지 삽입
		bts[0].setIcon(img1);
		bts[1].setIcon(img2);
		bts[2].setIcon(img3);
		bts[3].setIcon(img4);
		bts[4].setIcon(img5);
		bts[5].setIcon(img6);
		
		// 메서드 실행
		addLayout();
		eventProc();
		} // PanelHbg() 생성자 함수
	
	// 3. 화면 구성 및 출력
	void addLayout() {
		// 패널의 화면 구성
		setLayout(new GridLayout(2, 3, 10, 10));
		
		// 버튼 삽입
		for ( int i = 0; i < bts.length; i++) {
			add(bts[i]);
		}
	} // addLayout()
	void eventProc() {
		
		
	}
}
