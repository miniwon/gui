package e_tabbedpane;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class PanelC extends JPanel {
	
	JLabel cLa = new JLabel("판때기 C");
	JButton cBtn = new JButton("C 버튼");

	public PanelC () {
		setBackground(new Color(255,50,10));		// RGB(Red, Green, Blue)
		addLayout();
		eventProc();
	}
	void addLayout() {
		add(cLa);
		add(cBtn);
		
	}
	void eventProc() {
		
	}
}
