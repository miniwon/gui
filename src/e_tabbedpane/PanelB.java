package e_tabbedpane;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelB extends JPanel {

	JLabel bLa = new JLabel("판때기 B");
	JButton bBtn = new JButton("B 버튼");
	
	public PanelB () {
		setBackground(new Color(255, 255, 100));		// RGB(Red, Green, Blue)
		addLayout();
		eventProc();
	}
	void addLayout() {
		add(bLa);
		add(bBtn);
	}
	void eventProc() {
		
	}
}
