package co.edu.uptc.view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import co.edu.uptc.view.body.login.PanelContentBeginning;
import co.edu.uptc.view.body.user.PanelUser;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private PanelContentBeginning contentBegin;
	private PanelUser panelUser;
	
	public MainPanel(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new CardLayout());
		contentBegin = new PanelContentBeginning(listener);
		add(contentBegin, "login");
		
		panelUser = new PanelUser(listener);
		add(panelUser, "panelUser");
	}
	
	public String getLoginPassword() {
		return contentBegin.getBegin().getPassword();
	}
	
	public String getLoginNumberCheck() {
		return contentBegin.getBegin().getNumberCheck();
	}
	
	public void loadDatesProfile(ArrayList<String> dates) {
		panelUser.loadDatesProfile(dates);
	}
	
	public void updateRemant(double remant) {
		panelUser.updateRemant(remant);
	}
}
