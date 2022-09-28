package testHbg05_옵션주기도전전;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelChk extends JPanel {
	
	MainTest parent;

	// 1. 멤버변수 선언
	JButton[] bts;		// 반복문 사용을 위해 버튼을 배열로 선언
	String[] menu = new String[] {"후라이드싸이순살", "간장마늘싸이순살", "맘스양념싸이순살", "치파오싸이순살", "군옥수수뿌치싸이순살", "허니버터뿌치싸이순살"};
	int[] price = new int[] {16000, 17000, 17000, 18000, 18000, 18500};
	
//	ArrayList<MenuVO> list = new ArrayList<MenuVO>();

	// 2. 멤버변수 객체 생성(생성자 안에서)
	public PanelChk (MainTest mainTest) {
		parent = mainTest;

		// 버튼의 개수를 지정
		bts = new JButton[6];

		// 버튼 배열 안에 버튼 생성
		for ( int i = 0; i < bts.length; i++) {
			bts[i] = new JButton(menu[i]);
			bts[i].setHorizontalTextPosition(JButton.CENTER);
			bts[i].setVerticalTextPosition(JButton.BOTTOM);
		}

		// 이미지 삽입을 위해 .png 파일을 ImageIcon에 대입
		ImageIcon img1 = new ImageIcon("src/testHbgImgSource/1_후라이드싸이순살.png");
		ImageIcon img2 = new ImageIcon("src/testHbgImgSource/2_간장마늘싸이순살.png");
		ImageIcon img3 = new ImageIcon("src/testHbgImgSource/3_맘스양념싸이순살.png");
		ImageIcon img4 = new ImageIcon("src/testHbgImgSource/4_치파오싸이순살.png");
		ImageIcon img5 = new ImageIcon("src/testHbgImgSource/5_군옥수수뿌치싸이순살.png");
		ImageIcon img6 = new ImageIcon("src/testHbgImgSource/6_허니버터뿌치싸이순살.png");

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
		
		// 메뉴 버튼이 눌렸을 때
		for ( int i = 0; i < bts.length; i++ ) {
			String convert = Integer.toString(i);
			bts[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuVO menu = new MenuVO(bts[Integer.parseInt(convert)].getText(), price[Integer.parseInt(convert)]);
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
