package testHbg04_계산전까지;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelHbg extends JPanel {
	
	MainTest parent;

	// 1. 멤버변수 선언
	JButton[] btsHbg;		// 반복문 사용을 위해 버튼을 배열로 선언
	String[] menuHbg = new String[] {"싸이버거", "휠렛버거", "할라피뇨통살버거", "화이트갈릭버거", "불고기버거", "갈릭바베큐치킨버거"};
	int[] priceHbg = new int[] {5000, 5000, 6000, 6000, 7000, 7500};
	
//	ArrayList<MenuVO> list = new ArrayList<MenuVO>();

	// 2. 멤버변수 객체 생성(생성자 안에서)
	public PanelHbg (MainTest mainTest) {
		parent = mainTest;

		// 버튼의 개수를 지정
		btsHbg = new JButton[6];

		// 버튼 배열 안에 버튼 생성
		for ( int i = 0; i < btsHbg.length; i++) {
			btsHbg[i] = new JButton(menuHbg[i]);
			btsHbg[i].setHorizontalTextPosition(JButton.CENTER);
			btsHbg[i].setVerticalTextPosition(JButton.BOTTOM);
		}

		// 이미지 삽입을 위해 .png 파일을 ImageIcon에 대입
		ImageIcon img1 = new ImageIcon("src/testHbgImgSource/1_싸이버거.png");
		ImageIcon img2 = new ImageIcon("src/testHbgImgSource/2_휠렛버거.png");
		ImageIcon img3 = new ImageIcon("src/testHbgImgSource/3_할라피뇨통살버거.png");
		ImageIcon img4 = new ImageIcon("src/testHbgImgSource/4_화이트갈릭버거.png");
		ImageIcon img5 = new ImageIcon("src/testHbgImgSource/5_불고기버거.png");
		ImageIcon img6 = new ImageIcon("src/testHbgImgSource/6_갈릭바베큐치킨버거.png");

		// 버튼에 이미지 삽입
		btsHbg[0].setIcon(img1);
		btsHbg[1].setIcon(img2);
		btsHbg[2].setIcon(img3);
		btsHbg[3].setIcon(img4);
		btsHbg[4].setIcon(img5);
		btsHbg[5].setIcon(img6);

		// 메서드 실행
		addLayout();
		eventProc();
	} // PanelHbg() 생성자 함수

	// 3. 화면 구성 및 출력
	void addLayout() {
		// 패널의 화면 구성
		setLayout(new GridLayout(2, 3, 10, 10));

		// 버튼 삽입
		for ( int i = 0; i < btsHbg.length; i++) {
			add(btsHbg[i]);
		}
	} // addLayout()
	void eventProc() {
		
		// 메뉴 버튼이 눌렸을 때
		for ( int i = 0; i < btsHbg.length; i++ ) {
			String convert = Integer.toString(i);
			btsHbg[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuVO menu = new MenuVO(btsHbg[Integer.parseInt(convert)].getText(), priceHbg[Integer.parseInt(convert)]);
					parent.list.add(menu);
					selectAll();
				}
			});

		} // for문
	} // eventProc()
	// 장바구니 출력을 위한 데이터 저장
	void selectAll() { 
		parent.shoppingcartMenuTA.setText("---------------선택한 메뉴---------------\n");
		parent.shoppingcartPriceTA.setText("----------가격----------\n");
		for (MenuVO vo: parent.list) {
			parent.shoppingcartMenuTA.append(vo.getMenu()+"\n");
			parent.shoppingcartPriceTA.append(Integer.toString(vo.getPrice())+"\n");
		}

		
		
	} // selectAll()

}
