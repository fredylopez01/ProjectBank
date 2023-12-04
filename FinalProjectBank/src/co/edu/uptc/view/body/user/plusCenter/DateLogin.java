package co.edu.uptc.view.body.user.plusCenter;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.view.Constants;
import co.edu.uptc.view.body.login.ShapedPanelLoginUI;

public class DateLogin extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblDate;
	
	public DateLogin() {
		setUI(new ShapedPanelLoginUI(Constants.GRAY));
		lblDate = new JLabel(LocalDate.now().toString());
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(Constants.FONTNAV);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 10, 5, 10);
		add(lblDate, gbc);
	}
}
