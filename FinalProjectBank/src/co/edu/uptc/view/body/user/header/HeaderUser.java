package co.edu.uptc.view.body.user.header;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class HeaderUser extends JPanel {
	private static final long serialVersionUID = 1L;
	private ProfileInformation infoUser;
	
	public HeaderUser(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		infoUser = new ProfileInformation(listener);
		add(infoUser);
	}
}
