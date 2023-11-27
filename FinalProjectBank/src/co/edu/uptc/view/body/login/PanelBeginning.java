package co.edu.uptc.view.body.login;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import co.edu.uptc.view.Constants;
import co.edu.uptc.view.body.ShapedButtonProfile;

public class PanelBeginning extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblBegin;
	private JLabel lblCheck;
	private JTextField numberCheck;
	private JLabel lblPassword;
	private JPasswordField password;
	private JButton login;
	private JButton register;
	private JButton newCheck;
	
	public PanelBeginning(ActionListener listener) {
		setUI(new ShapedPanelLoginUI(Constants.COLORPANELLOGIN));
		setBackground(Constants.COLORBACKGROUNDPANELTWO);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		lblBegin = new JLabel("Inicio");
		lblBegin.setFont(Constants.FONTTITLEPANEL);
		gbc.insets = new Insets(95,  0,  55,  0);
		gbc.gridwidth = 2;
		add(lblBegin,gbc);
		
		lblCheck = new JLabel("Número de Cuenta");
		lblCheck.setFont(Constants.FONTNORMAL);
		gbc.insets = new Insets(2,  0,  2,  0);
		gbc.gridy = 1;
		add(lblCheck, gbc);
		
		numberCheck = new JTextField(18);
		numberCheck.setFont(Constants.FONTNORMAL);
		gbc.insets = new Insets(2,  0,  7,  0);
		gbc.gridy = 2;
		add(numberCheck, gbc);
		
		lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(Constants.FONTNORMAL);
		gbc.insets = new Insets(2,  0,  2,  0);
		gbc.gridy = 3;
		add(lblPassword, gbc);
		
		password = new JPasswordField(18);
		password.setFont(Constants.FONTNORMAL);
		gbc.insets = new Insets(2,  35,  15,  35);
		gbc.gridy = 4;
		add(password, gbc);
		
		login = new JButton("Ingresar");
		styleButton(login, "login", listener, new Insets (5,25,5,25), Constants.GREEN);
		gbc.insets = new Insets(2,  0, 45,  0);
		gbc.gridy = 5;
		add(login, gbc);
		
		register = new JButton("Registrarse");
		styleButton(register, "register", listener, new Insets (5,15,5,15), Constants.COLORBACKGROUNDHEADER);
		gbc.insets = new Insets(2,  35, 95,  5);
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		add(register, gbc);
		
		newCheck = new JButton("Crear Cuenta");
		styleButton(newCheck, "newCheck", listener, new Insets (5,15,5,15), Constants.COLORBACKGROUNDPANEL);
		gbc.insets = new Insets(2,  5, 95,  35);
		gbc.gridx = 1;
		add(newCheck, gbc);
	}
	
	public void styleButton(JButton btn, String comand, ActionListener listener, Insets insets, Color color) {
		btn.setFont(Constants.FONTNORMAL);
		btn.setForeground(Color.WHITE);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setCursor(Constants.HANDCURSOR);
		btn.setMargin(insets);
		btn.setFocusPainted(false);
		btn.setUI(new ShapedButtonProfile(color));
		btn.setActionCommand(comand);
		btn.addActionListener(listener);
	}
}
