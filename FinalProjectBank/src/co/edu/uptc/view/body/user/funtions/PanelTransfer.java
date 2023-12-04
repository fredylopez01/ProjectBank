package co.edu.uptc.view.body.user.funtions;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import co.edu.uptc.view.Constants;

public class PanelTransfer extends PanelFuntionBasic {
	private static final long serialVersionUID = 1L;
	private JLabel lblNCheck;
	private JTextField numberCheckTwo;
	private JLabel lblAmount;
	private JSpinner amount;
	
	public PanelTransfer(ActionListener listener) {
		super();
		initComponents(listener);
		addComponents();
	}

	private void initComponents(ActionListener listener) {
		lblTitlePanel.setText("Transferir");
		
		lblNCheck = new JLabel("N. Cuenta Destino");
		lblNCheck.setFont(Constants.FONTNORMAL);
		
		numberCheckTwo = new JTextField(18);
		numberCheckTwo.setFont(Constants.FONTNORMAL);
		
		lblAmount = new JLabel("¿Cuanto?");
		lblAmount.setFont(Constants.FONTNORMAL);
		
		amount = new JSpinner();
		amount.setFont(Constants.FONTNORMAL);
		
		btnAction.setText("Transferir");
		actionButton(btnAction, "withdraw", listener);
	}

	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(69,  0,  2,  0);
		add(lblTitlePanel, gbc);
		
		gbc.gridy = 1;
		gbc.insets = new Insets(45,  0,  2,  0);
		add(lblPassword, gbc);

		gbc.insets = new Insets(2,  35,  15,  35);
		gbc.gridy = 2;
		add(password, gbc);
		
		gbc.insets = new Insets(2,  0,  2,  0);
		gbc.gridy = 3;
		add(lblNCheck, gbc);

		gbc.insets = new Insets(2,  35,  15,  35);
		gbc.gridy = 4;
		add(numberCheckTwo, gbc);

		gbc.insets = new Insets(2,  0,  2,  0);
		gbc.gridy = 5;
		add(lblAmount, gbc);

		gbc.insets = new Insets(2,  35,  15,  35);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy= 6;
		add(amount, gbc);
		
		gbc.gridy = 7;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(2,  35, 69,  35);
		add(btnAction, gbc);
	}
}
