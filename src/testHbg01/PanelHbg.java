package testHbg01;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelHbg extends JPanel {
	
	// 1. 멤버변수 선언
	JButton bt1, bt2, bt3, bt4, bt5, bt6; 	// 메뉴 6개 넣을 버튼 6개
	String[] hbg = new String[] {"싸이버거", "휠렛버거", "할라피뇨통살버거", "화이트갈릭버거", "불고기버거", "갈릭바베큐치킨버거"};
	int[] price = new int[] {};
	
	// 2. 멤버변수 객체 생성(생성자 안에서)
	public PanelHbg () {
		
		// 이미지 삽입을 위해 .png 파일을 ImageIcon에 대입
		ImageIcon img1 = new ImageIcon("src/testHbgImgSource/1_싸이버거.png");
		ImageIcon img2 = new ImageIcon("src/testHbgImgSource/2_휠렛버거.png");
		ImageIcon img3 = new ImageIcon("src/testHbgImgSource/3_할라피뇨통살버거.png");
		ImageIcon img4 = new ImageIcon("src/testHbgImgSource/4_화이트갈릭버거.png");
		ImageIcon img5 = new ImageIcon("src/testHbgImgSource/5_불고기버거.png");
		ImageIcon img6 = new ImageIcon("src/testHbgImgSource/6_갈릭바베큐치킨버거.png");
		
		bt1 = new JButton("싸이버거", img1);
		bt1.setHorizontalTextPosition(JButton.CENTER);
		bt1.setVerticalTextPosition(JButton.BOTTOM);
		bt2 = new JButton("휠렛버거", img2);
		bt2.setHorizontalTextPosition(JButton.CENTER);
		bt2.setVerticalTextPosition(JButton.BOTTOM);
		bt3 = new JButton("할라피뇨통살버거", img3);
		bt3.setHorizontalTextPosition(JButton.CENTER);
		bt3.setVerticalTextPosition(JButton.BOTTOM);
		bt4 = new JButton("화이트갈릭버거", img4);
		bt4.setHorizontalTextPosition(JButton.CENTER);
		bt4.setVerticalTextPosition(JButton.BOTTOM);
		bt5 = new JButton("불고기버거", img5);
		bt5.setHorizontalTextPosition(JButton.CENTER);
		bt5.setVerticalTextPosition(JButton.BOTTOM);
		bt6 = new JButton("갈릭바베큐치킨버거", img6);
		bt6.setHorizontalTextPosition(JButton.CENTER);
		bt6.setVerticalTextPosition(JButton.BOTTOM);
		
		addLayout();
		eventProc();
		} // PanelHbg() 생성자 함수
	
	// 3. 화면 구성 및 출력
	void addLayout() {
		
		setLayout(new GridLayout(2, 3, 10, 10));
		add(bt1);
		add(bt2);
		add(bt3);
		add(bt4);
		add(bt5);
		add(bt6);
	
	} // addLayout()
	void eventProc() {
		
	}
}
