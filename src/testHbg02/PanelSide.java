package testHbg02;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSide extends JPanel {

	JLabel pSide = new JLabel("확인용4");
	
	PanelSide () {
		addLayout();
		eventProc();
	}
	void addLayout() {
		add(pSide);
	}
	void eventProc() {
		
	}
	
}
