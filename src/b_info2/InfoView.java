package b_info2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;


public class InfoView {

	// 1. 멤버변수 선언
	JFrame f;
//	JLabel lbName, lbID, lbTel, lbGender, lbAge, lbHome;
	JTextField tfName, tfID, tfTel, tfGender, tfAge, tfHome;
	JTextArea ta;
	JButton bAdd, bShow, bSearch, bDelete, bCancel, bExit;
	
	// 2. 멤버변수 객체 생성
	InfoView() {
		f = new JFrame("DBTest");
//		lbName = new JLabel("Name");
//		lbID = new JLabel("ID");
		tfName = new JTextField(20);
		tfID = new JTextField();
		tfTel = new JTextField();
		tfGender = new JTextField();
		tfAge = new JTextField();
		tfHome = new JTextField();
		ta = new JTextArea(50,50);
		bAdd = new JButton("Add");
		bShow = new JButton("Show");
		bSearch = new JButton("Search");
		bDelete = new JButton("Delete");
		bCancel = new JButton("Cancel");
		bExit = new JButton("Exit");
	}
	
	// 3. 화면 구성하고 출력
	/*
	 * 전체 프레임 BorderLayout 지정
	 * 		- WEST		: JPanel 붙이기(GridLayout(6,2))
	 * 		- CENTER	: TextArea
	 * 		- SOUTH		: JPanel 붙이기(GridLayout(1,6))
	 */
	public void addLayout() {

		f.setLayout(new BorderLayout());
		
		JPanel pWest = new JPanel();
		pWest.setLayout(new GridLayout(6,2));
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
//		for (Component jc : pWest.getComponents()) {
//		    if ( jc instanceof JLabel ) {
//		        JLabel label = (JLabel) jc;
//		        label.setHorizontalAlignment(JLabel.CENTER);
//		    }
//		}
		
		f.add(pWest, BorderLayout.WEST);
		pWest.setPreferredSize(new Dimension(300,300));
		
		f.add(ta, BorderLayout.CENTER);
		
		JPanel pSouth = new JPanel();
		pSouth.setLayout(new GridLayout(1,6));
		pSouth.add(bAdd);
		pSouth.add(bShow);
		pSouth.add(bSearch);
		pSouth.add(bDelete);
		pSouth.add(bCancel);
		pSouth.add(bExit);
		f.add(pSouth, BorderLayout.SOUTH);
		
		f.setBounds(100, 100, 800, 350);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static void main(String[] args) {
		
		InfoView info = new InfoView();
		info.addLayout();

		

	}

}
