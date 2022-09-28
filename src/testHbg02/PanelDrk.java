package testHbg02;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDrk extends JPanel {
	
	JLabel pHbg = new JLabel("확인용5");
	
	public PanelDrk () {
		addLayout();
		eventProc();
		}
	void addLayout() {
		add(pHbg);
	}
	void eventProc() {
		
	}
}
