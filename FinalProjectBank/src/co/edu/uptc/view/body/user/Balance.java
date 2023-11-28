package co.edu.uptc.view.body.user;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.view.Constants;

public class Balance extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel balanceValue;
	
	public Balance(ActionListener listener) {
		setUI(new ShapedPanelBalance(Constants.YELLOWPANEL));
		initComponents(listener);
		addComponents();
	}

	private void initComponents(ActionListener listener) {
		lblTitle = new JLabel("Saldo");
		lblTitle.setFont(Constants.FONTNAV);
		lblTitle.setForeground(Color.WHITE);
		
		balanceValue = new JLabel("$200000");
		balanceValue.setFont(Constants.FONTTITLEPANEL);
	}
	
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(20, 0, 0, 0);
		add(lblTitle, gbc);
		
		gbc.gridy = 1;
		gbc.insets = new Insets(2, 5, 20, 5);
		add(balanceValue, gbc);
	}

}
