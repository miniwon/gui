package testHbg02;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainTest {

	// 1. 멤버변수 선언
	JFrame f;					// 창
	JTextArea shoppingcart;		// 장바구니
	JTextField sum;				// 합계액
	JButton payment;			// 결제 버튼
	
	// 패널들
	PanelHbg panelHbg;
	PanelChk panelChk;
	PanelSet panelSet;
	PanelSide panelSide;
	PanelDrk panelDrk;
	
	
	// 2. 멤버변수 객체 생성
	MainTest() {
		f = new JFrame("맘스터치 키오스크");
		shoppingcart = new JTextArea("----------주문 목록----------", 0, 36);
//		shoppingcart = new JTextArea(70, 35);
		sum = new JTextField("주문한 메뉴의 개수: \t" + "총 결제 금액: ");
		payment = new JButton("결제하기");
		
		panelHbg = new PanelHbg();
		panelChk = new PanelChk();
		panelSet = new PanelSet();
		panelSide = new PanelSide();
		panelDrk = new PanelDrk();
	} // MainTest()
	
	// 3. 화면 구성 및 출력
	public void addLayout() {
		// 전체 화면 구성은 BorderLayout()
		f.setLayout(new BorderLayout());
		
		// 탭 항목 추가 + 탭 배치
		JTabbedPane tab = new JTabbedPane();
		tab.addTab("버거", panelHbg);
		tab.addTab("치킨", panelChk);
		tab.addTab("맘스세트", panelSet);
		tab.addTab("사이드", panelSide);
		tab.addTab("음료", panelDrk);
		tab.setPreferredSize(new Dimension(500, 600));
		f.add(tab, BorderLayout.NORTH);			// 상단에 탭 배치
		
		
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BorderLayout());
		pCenter.add(shoppingcart, BorderLayout.WEST);
		pCenter.add(payment, BorderLayout.EAST);
		
		f.add(pCenter, BorderLayout.CENTER);
		
		f.add(sum, BorderLayout.SOUTH);
		
		// 창 크기와 기본 세팅
		f.setBounds(100, 100, 500, 900);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	} // addLayout()
	
	// 4. 이벤트 처리 함수
	public void eventProc() {
		
		// 결제 버튼을 눌렀을 때
		payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "결제하시겠습니까?", "결제 확인", JOptionPane.YES_NO_OPTION);
			}
		});
		
	} // eventProc()

	
	public static void main(String[] args) {
		
		MainTest main = new MainTest();
		main.addLayout();
		main.eventProc();
		

	} // main()

} // MainTest {}
