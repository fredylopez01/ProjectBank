package co.edu.uptc.view.body.user.funtions;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.uptc.view.Constants;

public class PanelBlockCheck extends PanelFuntionBasic {
	private static final long serialVersionUID = 1L;
	private JLabel lblNumberCheck;
	private JTextField numberCheck;
	private JButton btnActionTwo;
	
	public PanelBlockCheck(ActionListener listener) {
		super();
		initComponents(listener);
		addComponents();
	}

	private void initComponents(ActionListener listener) {
		lblTitlePanel.setText("<html><body style=\"text-align: center\">Bloquear <br>Desbloquear <br>Cuenta</body></html>");
		
		lblNumberCheck = new JLabel("Número Cuenta");
		lblNumberCheck.setFont(Constants.FONTNORMAL);
		
		numberCheck = new JTextField(18);
		numberCheck.setFont(Constants.FONTNORMAL);
		
		btnAction.setText("Bloquear");
		actionButton(btnAction, "blockCount", listener);
		
		btnActionTwo = new JButton("Desbloquear");
		styleButton(btnActionTwo, new Insets(5, 15, 5, 15), Constants.GREEN);
		actionButton(btnAction, "unBlockCount", listener);
	}

	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(65,  0,  2,  0);
		gbc.gridwidth = 2;
		add(lblTitlePanel, gbc);
		
		gbc.gridy = 1;
		gbc.insets = new Insets(45,  0,  2,  0);
		add(lblPassword, gbc);

		gbc.insets = new Insets(2,  35,  25,  35);
		gbc.gridy = 2;
		add(password, gbc);

		gbc.insets = new Insets(2,  0,  2,  0);
		gbc.gridy = 3;
		add(lblNumberCheck, gbc);

		gbc.insets = new Insets(2,  35,  15,  35);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy= 4;
		add(numberCheck, gbc);
		
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(2,  35, 75,  5);
		add(btnAction, gbc);
		
		gbc.gridx = 1;
		gbc.insets = new Insets(2,  5, 75,  35);
		add(btnActionTwo, gbc);
	}

}
