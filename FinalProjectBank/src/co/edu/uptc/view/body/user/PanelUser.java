package co.edu.uptc.view.body.user;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import co.edu.uptc.view.body.user.header.HeaderUser;

public class PanelUser extends JPanel {
	private static final long serialVersionUID = 1L;
	private HeaderUser headerUser;
	private Options options;
	
	public PanelUser(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new BorderLayout());
		
		headerUser = new HeaderUser(listener);
		add(headerUser, BorderLayout.NORTH);
		
		options = new Options(listener);
		add(options, BorderLayout.WEST);
	}
}
