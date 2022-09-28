package testHbg04_계산전까지;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSet extends JPanel {
	
	MainTest parent;

	// 1. 멤버변수 선언
	JButton[] btsChk;		// 반복문 사용을 위해 버튼을 배열로 선언
	String[] menuChk = new String[] {"콩룡키즈세트", "싱글떡강정세트", "싱글통다리세트", "커플떡강정세트", "커플통다리세트", "커플치킨세트"};
	int[] priceChk = new int[] {26000, 27000, 21000, 28000, 28000, 13500};
	
//	ArrayList<MenuVO> list = new ArrayList<MenuVO>();

	// 2. 멤버변수 객체 생성(생성자 안에서)
	public PanelSet (MainTest mainTest) {
		parent = mainTest;

		// 버튼의 개수를 지정
		btsChk = new JButton[6];

		// 버튼 배열 안에 버튼 생성
		for ( int i = 0; i < btsChk.length; i++) {
			btsChk[i] = new JButton(menuChk[i]);
			btsChk[i].setHorizontalTextPosition(JButton.CENTER);
			btsChk[i].setVerticalTextPosition(JButton.BOTTOM);
		}

		// 이미지 삽입을 위해 .png 파일을 ImageIcon에 대입
		ImageIcon img1 = new ImageIcon("src/testHbgImgSource/1_후라이드싸이순살.png");
		ImageIcon img2 = new ImageIcon("src/testHbgImgSource/2_간장마늘싸이순살.png");
		ImageIcon img3 = new ImageIcon("src/testHbgImgSource/3_맘스양념싸이순살.png");
		ImageIcon img4 = new ImageIcon("src/testHbgImgSource/4_치파오싸이순살.png");
		ImageIcon img5 = new ImageIcon("src/testHbgImgSource/5_군옥수수뿌치싸이순살.png");
		ImageIcon img6 = new ImageIcon("src/testHbgImgSource/6_허니버터뿌치싸이순살.png");

		// 버튼에 이미지 삽입
		btsChk[0].setIcon(img1);
		btsChk[1].setIcon(img2);
		btsChk[2].setIcon(img3);
		btsChk[3].setIcon(img4);
		btsChk[4].setIcon(img5);
		btsChk[5].setIcon(img6);

		// 메서드 실행
		addLayout();
		eventProc();
	} // PanelHbg() 생성자 함수

	// 3. 화면 구성 및 출력
	void addLayout() {
		// 패널의 화면 구성
		setLayout(new GridLayout(2, 3, 10, 10));

		// 버튼 삽입
		for ( int i = 0; i < btsChk.length; i++) {
			add(btsChk[i]);
		}
	} // addLayout()
	void eventProc() {
		
		// 메뉴 버튼이 눌렸을 때
		for ( int i = 0; i < btsChk.length; i++ ) {
			String convert = Integer.toString(i);
			btsChk[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuVO menu = new MenuVO(btsChk[Integer.parseInt(convert)].getText(), priceChk[Integer.parseInt(convert)]);
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
