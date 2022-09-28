package testHbg02;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSet extends JPanel {
	
	JLabel pHbg = new JLabel("확인용3");
	
	public PanelSet () {
		addLayout();
		eventProc();
		}
	void addLayout() {
		add(pHbg);
	}
	void eventProc() {
		
	}
}
