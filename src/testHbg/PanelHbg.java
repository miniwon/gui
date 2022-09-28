package testHbg;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHbg extends JPanel {
	
	JLabel a = new JLabel("확인용");
	
	public PanelHbg () {
		addLayout();
		eventProc();
		}
	void addLayout() {
		add(a);
	}
	void eventProc() {
		
	}
}
