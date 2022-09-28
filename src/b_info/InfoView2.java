package b_info;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoView2 {			// 수정하는 파일

	// 1. 멤버변수 선언
	JFrame f;
	// JLabel lbName, lbID, lbTel, lbGender, lbAge, lbHome;
	JTextField tfName, tfID, tfTel, tfGender, tfAge, tfHome;
	JTextArea ta;
	JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit;

	ArrayList<PersonVO> list = new ArrayList<PersonVO>();

	// 2. 멤버변수 객체 생성
	InfoView2() {
		f = new JFrame("DBTest");
		// lbName = new JLabel("Name");
		// lbID = new JLabel("ID");
		tfName = new JTextField(20);
		tfID = new JTextField(20);
		tfTel = new JTextField(20);
		tfGender = new JTextField(20);
		tfAge = new JTextField(20);
		tfHome = new JTextField(20);

		// CENTER 입력창
		ta = new JTextArea(40, 20);
		ImageIcon iconAdd = new ImageIcon("src\\b_info\\images\\1.png");
		Image imgAdd = iconAdd.getImage();
		Image changeImgAdd = imgAdd.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon changeIconAdd = new ImageIcon(changeImgAdd);
		bAdd = new JButton("Add", changeIconAdd);
		bAdd.setHorizontalTextPosition(JButton.CENTER); // 가로 가운데 정렬
		bAdd.setVerticalTextPosition(JButton.CENTER); // 세로 가운데 정렬
		bAdd.setRolloverIcon(new ImageIcon("src\\b_info\\images\\2.png"));
		bAdd.setPressedIcon(new ImageIcon("src\\b_info\\images\\3.png"));
		bShow = new JButton("Show");
		bSearch = new JButton("Search");
		bDelete = new JButton("Delete");
		bCancel = new JButton("Cancel");
		bExit = new JButton("Exit(alt + x)");
		bExit.setToolTipText("프로그램을 종료합니다");
		bExit.setMnemonic('x');

	}

	// 3. 화면 구성하고 출력
	/*
	 * 전체 프레임 BorderLayout 지정 - WEST : JPanel 붙이기(GridLayout(6,2)) - CENTER :
	 * TextArea - SOUTH : JPanel 붙이기(GridLayout(1,6))
	 */
	public void addLayout() {
		f.setLayout(new BorderLayout());

		JPanel pWest = new JPanel();
		pWest.setLayout(new GridLayout(6, 2));
		pWest.add(new JLabel("Name", JLabel.CENTER));
		pWest.add(tfName);
		pWest.add(new JLabel("ID", JLabel.CENTER));
		pWest.add(tfID);
		pWest.add(new JLabel("Tel", JLabel.CENTER));
		pWest.add(tfTel);
		pWest.add(new JLabel("Gender", JLabel.CENTER));
		pWest.add(tfGender);
		pWest.add(new JLabel("Age", JLabel.CENTER));
		pWest.add(tfAge);
		pWest.add(new JLabel("Home", JLabel.CENTER));
		pWest.add(tfHome);
		// for (Component jc : pWest.getComponents()) {
		// if ( jc instanceof JLabel ) {
		// JLabel label = (JLabel) jc;
		// label.setHorizontalAlignment(JLabel.CENTER);
		// }
		// }

		f.add(pWest, BorderLayout.WEST);
		pWest.setPreferredSize(new Dimension(300, 300));

		f.add(ta, BorderLayout.CENTER);

		JPanel pSouth = new JPanel();
		pSouth.setLayout(new GridLayout(1, 6));
		pSouth.add(bAdd);
		pSouth.add(bShow);
		pSouth.add(bSearch);
		pSouth.add(bDelete);
		pSouth.add(bCancel);
		pSouth.add(bExit);
		f.add(pSouth, BorderLayout.SOUTH);
		pSouth.setPreferredSize(new Dimension(150, 60));

		f.setBounds(100, 100, 800, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// 이벤트 처리 함수
	public void eventProc() {
		// Add 버튼이 눌렸을 때
		bAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputData();
				clearTextField();
				selectAll();
			}
		});

		tfID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getJuminInfo();
			}
		});

		tfID.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				getJuminInfo();
			}

			@Override
			public void focusGained(FocusEvent e) {				
			}
		});

		// Show 버튼이 눌렸을 때
		bShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll();
			}
		});

		// Search 버튼이 눌렸을 때
		bSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByTel();
			}
		});

		// 전화번호 텍스트필드에서 엔터 쳤을 때
		tfTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByTel();
			}
		});


		// Delete 버튼이 눌렸을 때
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteByTel();
				selectAll();
			}
		});
		bCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextField();
			}
		});
		bExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "이벤트 발생 Exit");
			}
		});}

	// 주민등록번호 입력 창에 엔터 쳤을 때

	public void getJuminInfo() {
		String jumin = tfID.getText();		// tfID에 입력된 문자열을 jumin 변수에 저장
		if (jumin.length() != 14) {			// 주민등록번호는 6자리-7자리 도합 14자리
			JOptionPane.showMessageDialog(null, "- 을 포함한 14자를 입력해 주세요");
			return;							// void 메서드에서의 return: 프로그램 종료
			// (1) 주민등록번호의 7번째 문자로 성별을 구하여 성별창에 출력
		} else {
			if (jumin.charAt(7) == '1' || jumin.charAt(7) == '3' || jumin.charAt(7) == '9') {
				tfGender.setText("남자");		// tfGender 텍스트 필드에 "남자" 출력
			} else if (jumin.charAt(7) == '2' || jumin.charAt(7) == '4' || jumin.charAt(7) == '0') {
				tfGender.setText("여자");		// tfGender 텍스트 필드에 "여자" 출력
			} else {
				JOptionPane.showMessageDialog(null, "성별 - 잘못된 입력");
			}

			// (2) 주민등록번호의 8번째 문자로 출신지를 구하여 출신지창에 출력
			char inputHome = jumin.charAt(8);
			switch (inputHome) { // 문자, 정수, 문자열
			case '0':				// char 자료형이므로 '' 필수
				tfHome.setText("서울");
				break;
			case '1':
				tfHome.setText("인천 / 부산");
				break;
			case '2':
				tfHome.setText("경기");
				break;
			case '9':
				tfHome.setText("제주");
				break;
			default:
				JOptionPane.showMessageDialog(null, "지역 - 잘못된 입력");
				break;
			}

			// (3) 주민등록번호에서 년도에 의해 나이를 구해서 나이 창에 출력
			int nyun = 0;
			if (jumin.charAt(7) == '1' || jumin.charAt(7) == '2') { 		// 1,2면 1900년대생
				nyun = 1900;
			} else if (jumin.charAt(7) == '3' || jumin.charAt(7) == '4') {	// 3,4면 2000년대생
				nyun = 2000;
			} else {
				JOptionPane.showMessageDialog(null, "나이 - 잘못된 입력");
			}

			String age = jumin.substring(0, 2);								// 19xx or 20xx의 xx값
			int convertAge = Integer.parseInt(age);							// 계산을 위해 int 형변환
			Calendar today = Calendar.getInstance();						// 현재 년도값을 받기 위해 Calendar 객체 생성
			int year = today.get(Calendar.YEAR);							// 현재 년도값
			tfAge.setText(Integer.toString(year - (nyun + convertAge) + 1));// 현재 년도 - 생년 + 1을 텍스트필드 Age에 출력

		}
	}
	void clearTextField() {
		ta.setText(null);
		tfName.setText(null);
		tfID.setText(null);
		tfTel.setText(null);
		tfGender.setText(null);
		tfAge.setText(null);
		tfHome.setText(null);
	} // clearTextField()

	/*
	 * 'ADD' 버튼이 눌렸을 때 텍스트필드에 입력한 사용자의값들을 PersonVO에 저장하기
	 */

	void inputData() {
		// (1) 각각의 텍스트필드의 입력값을 얻어 오기

		// (2) 1번의 값들을 PersonVO 필드에 저장(setter / constructor)

		PersonVO vo = new PersonVO(tfName.getText(), tfID.getText(), tfTel.getText(), tfGender.getText(), Integer.parseInt(tfAge.getText()), tfHome.getText());
		//					PersonVO vo = new PersonVO();
		//					vo.setName(tfName.getText());

		list.add(vo);
	} // inputData()


	/*
	 * 리스트에 저장된 정보를 모두 출력합니다 - textArea에
	 */
	void selectAll() {
		ta.setText("--------전체 목록--------\n\n");
		for (PersonVO vo: list) {
			ta.append(vo.toString()); 		// 기존에 있는 내용 뒤에 쓴다
		}
	} // selectAll()

	/*
	 * 함수명		: selectByTel
	 * 인자		: 없음
	 * 리턴값		: void
	 * 역할		: 
	 */
	void selectByTel() {
		// 입력한 전화번호 값을 얻어 오기
		String tel = tfTel.getText();
		// 입력받은 전화번호가 공백이라면 "전화번호를 입력하세요"라는 메시지 창을 출력
		if (tel.equals("")) {
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
			return;
		}
		// 리스트에 저장된 PersonVO의 전화번호와 비교하여 해당 전화번호가 있으면 그 내용을 각각의 텍스트필드에 출력
		for (PersonVO vo: list) {
			if (tel.equals(vo.getTel())) {
				tfName.setText(vo.getName());
				tfID.setText(vo.getId());
				tfTel.setText(vo.getTel());
				tfGender.setText(vo.getGender());
				tfAge.setText(Integer.toString(vo.getAge()));
				tfHome.setText(vo.getHome());
			}
		}
		
	} // selectByTel()
	
	void deleteByTel() {
		// 입력한 전화번호 값을 얻어 오기
		String tel = tfTel.getText();
		// 입력받은 전화번호가 공백이라면 "전화번호를 입력하세요"라는 메시지 창을 출력
		if (tel.equals("")) {
			JOptionPane.showMessageDialog(null, "전화번호를 입력하세요");
			return;
		}
		// 리스트에 저장된 PersonVO의 전화번호와 비교하여
		for (PersonVO vo: list) {
			if (tel.equals(vo.getTel())) {
				list.remove(vo);
				break;
			}
		}
		
		// 해당 전화번호가 있으면 그 해당하는 PersonVO를 리스트에서 삭제
		// (참고) 삭제하고 나서 break로 반복문 끝내기
	}
	
	void deleteData() {
		
	}

	public static void main(String[] args) {

		InfoView2 info = new InfoView2();
		info.addLayout();
		info.eventProc();

	} // main()

}
