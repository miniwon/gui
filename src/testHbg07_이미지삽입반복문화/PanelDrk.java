package testHbg07_이미지삽입반복문화;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelDrk extends JPanel {
	
	MainTest parent;

	// 1. 멤버변수 선언
	JButton[] bts;		// 반복문 사용을 위해 버튼을 배열로 선언
	String[] menu = new String[] {"콜라", "사이다", "레몬에이드", "청포도에이드", "아메리카노", "오렌지주스"};
	int[] price = new int[] {2500, 2500, 3500, 3500, 4000, 4500};
	
//	ArrayList<MenuVO> list = new ArrayList<MenuVO>();

	// 2. 멤버변수 객체 생성(생성자 안에서)
	public PanelDrk (MainTest mainTest) {
		parent = mainTest;

		// 버튼의 개수를 지정
		bts = new JButton[6];

		// 버튼 배열 안에 버튼 생성
		for ( int i = 0; i < bts.length; i++) {
			bts[i] = new JButton(menu[i]);
			bts[i].setHorizontalTextPosition(JButton.CENTER);
			bts[i].setVerticalTextPosition(JButton.BOTTOM);
			bts[i].setIcon(new ImageIcon("testImg/drkImg/"+ i +".png"));	// 이미지 삽입
		}

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
