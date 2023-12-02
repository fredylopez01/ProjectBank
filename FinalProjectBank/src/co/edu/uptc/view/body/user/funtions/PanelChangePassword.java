package co.edu.uptc.view.body.user.funtions;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

import co.edu.uptc.view.Constants;

public class PanelChangePassword extends PanelFuntionBasic {
	private static final long serialVersionUID = 1L;
	private JLabel lblNewPassword;
	private JPasswordField newPassword;
	
	public PanelChangePassword(ActionListener listener) {
		super();
		initComponents(listener);
		addComponents();
	}

	private void initComponents(ActionListener listener) {
		lblTitlePanel.setText("<html><body style=\"text-align: center\">Cambiar <br>Contraseña</body></html>");
		
		lblNewPassword = new JLabel("Nueva Contraseña");
		lblNewPassword.setFont(Constants.FONTNORMAL);
		
		newPassword = new JPasswordField(18);
		password.setFont(Constants.FONTNORMAL);
		
		btnAction.setText("Cambiar");
		actionButton(btnAction, "changePassword", listener);
	}

	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(80,  0,  2,  0);
		add(lblTitlePanel, gbc);
		
		gbc.gridy = 1;
		gbc.insets = new Insets(45,  0,  2,  0);
		add(lblPassword, gbc);

		gbc.insets = new Insets(2,  35,  25,  35);
		gbc.gridy = 2;
		add(password, gbc);

		gbc.insets = new Insets(2,  0,  2,  0);
		gbc.gridy = 3;
		add(lblNewPassword, gbc);

		gbc.insets = new Insets(2,  35,  15,  35);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy= 4;
		add(newPassword, gbc);
		
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(2,  35, 85,  35);
		add(btnAction, gbc);
	}
}
