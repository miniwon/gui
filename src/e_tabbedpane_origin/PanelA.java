package e_tabbedpane_origin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelA extends JPanel {
	
	JLabel aLa = new JLabel("판때기 A");
	JButton aBtn = new JButton("A 버튼");
	JLabel welcome = new JLabel("");
	JPanel pNorth = new JPanel();

	public PanelA () {
		setBackground(new Color(0, 100, 255));		// RGB(Red, Green, Blue)
		addLayout();
		eventProc();
	}
	void addLayout() {
		
		setLayout(new BorderLayout());
		pNorth.add(aLa);
		pNorth.add(aBtn);
		
		add(pNorth, BorderLayout.NORTH);
		add(welcome, BorderLayout.CENTER);
		
	}
	void eventProc() {
		aBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputWelcome();
				
				
			}
		});
		
	}
	
	void outputWelcome() {
		aLa.setText("");
		welcome.setText("Welcome");
	}
}
