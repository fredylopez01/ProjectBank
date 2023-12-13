package co.edu.uptc.view.body.user;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import co.edu.uptc.view.body.user.lateral.LateralMenu;

public class PanelUser extends JPanel {
	private static final long serialVersionUID = 1L;
	private LateralMenu lateral;
	private PanelCenterUser panelCenter;
	
	public PanelUser(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new BorderLayout());
		
		lateral = new LateralMenu(listener);
		add(lateral, BorderLayout.WEST);
		
		panelCenter = new PanelCenterUser(listener);
		JScrollPane scroll = new JScrollPane(panelCenter);
		add(scroll, BorderLayout.CENTER);
	}
	
	public void loadDatesProfile(ArrayList<String> dates) {
		lateral.loadDatesProfile(dates);
	}
	
	public void updateRemant(double remant) {
		panelCenter.updateRemant(remant);
	}
}
