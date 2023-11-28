package co.edu.uptc.view.body.user.funtions;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;

import co.edu.uptc.view.Constants;
import co.edu.uptc.view.body.login.PanelBeginning;
import co.edu.uptc.view.body.login.ShapedPanelLoginUI;

public class PanelWithdraw extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblPassword;
	private JPasswordField passwordWithdraw;
	private JLabel lblAmount;
	private JSpinner amountWithdraw;
	private JButton btnWithdraw;
	
	public PanelWithdraw(ActionListener listener) {
		setUI(new ShapedPanelLoginUI(Constants.COLORPANELFUNTION));
		initComponents(listener);
		addComponents();
	}

	private void initComponents(ActionListener listener) {
		lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(Constants.FONTNORMAL);
		
		passwordWithdraw = new JPasswordField(18);
		passwordWithdraw.setFont(Constants.FONTNORMAL);
		
		lblAmount = new JLabel("¿Cuanto?");
		lblAmount.setFont(Constants.FONTNORMAL);
		
		amountWithdraw = new JSpinner();
		amountWithdraw.setFont(Constants.FONTNORMAL);
		
		btnWithdraw = new JButton("Retirar");
		btnWithdraw.setFont(Constants.FONTNORMAL);
		PanelBeginning.styleButton(btnWithdraw, "withdraw", listener, new Insets(5, 15, 5, 15), Constants.GREEN);
	}

	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(95,  0,  2,  0);
		add(lblPassword, gbc);

		gbc.insets = new Insets(2,  35,  25,  35);
		gbc.gridy = 1;
		add(passwordWithdraw, gbc);

		gbc.insets = new Insets(2,  0,  2,  0);
		gbc.gridy = 2;
		add(lblAmount, gbc);

		gbc.insets = new Insets(2,  35,  15,  35);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy= 3;
		add(amountWithdraw, gbc);
		
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(2,  35, 95,  35);
		add(btnWithdraw, gbc);
	}
}
