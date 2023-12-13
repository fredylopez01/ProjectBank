package co.edu.uptc.view.body.user.lateral;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import co.edu.uptc.view.Constants;

public class LateralMenu extends JPanel {
	private static final long serialVersionUID = 1L;
	private ProfileInformation infoUser;
	private Options options;
	
	public LateralMenu(ActionListener listener) {
		setBackground(Constants.COLORBACKGROUNDPANEL);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		infoUser = new ProfileInformation(listener);
		add(infoUser);
		
		options = new Options(listener);
		gbc.gridy = 1;
		add(options, gbc);
	}
	
	public void loadDatesProfile(ArrayList<String> dates) {
		infoUser.loadDates(dates);
	}
	
}
