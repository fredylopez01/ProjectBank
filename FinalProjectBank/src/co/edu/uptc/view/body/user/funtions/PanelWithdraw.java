package co.edu.uptc.view.body.user.funtions;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSpinner;

import co.edu.uptc.view.Constants;

public class PanelWithdraw extends PanelFuntionBasic {
	private static final long serialVersionUID = 1L;
	private JLabel lblAmount;
	private JSpinner amount;
	
	public PanelWithdraw(ActionListener listener) {
		super();
		initComponents(listener);
		addComponents();
	}

	private void initComponents(ActionListener listener) {
		lblTitlePanel.setText("Retirar");
		
		lblAmount = new JLabel("¿Cuanto?");
		lblAmount.setFont(Constants.FONTNORMAL);
		
		amount = new JSpinner();
		amount.setFont(Constants.FONTNORMAL);
		
		btnAction.setText("Retirar");
		actionButton(btnAction, "withdraw", listener);
	}

	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(95,  0,  2,  0);
		add(lblTitlePanel, gbc);
		
		gbc.gridy = 1;
		gbc.insets = new Insets(45,  0,  2,  0);
		add(lblPassword, gbc);

		gbc.insets = new Insets(2,  35,  25,  35);
		gbc.gridy = 2;
		add(password, gbc);

		gbc.insets = new Insets(2,  0,  2,  0);
		gbc.gridy = 3;
		add(lblAmount, gbc);

		gbc.insets = new Insets(2,  35,  15,  35);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy= 4;
		add(amount, gbc);
		
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(2,  35, 95,  35);
		add(btnAction, gbc);
	}
}
