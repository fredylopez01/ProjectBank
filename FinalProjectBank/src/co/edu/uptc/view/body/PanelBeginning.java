package co.edu.uptc.view.body;

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
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		lblBegin = new JLabel("Inicio");
		lblBegin.setFont(Constants.FONTTITLEPANEL);
		gbc.insets = new Insets(5,  5,  55,  5);
		gbc.gridwidth = 2;
		add(lblBegin,gbc);
		
		lblCheck = new JLabel("Número de Cuenta");
		lblCheck.setFont(Constants.FONTNORMAL);
		gbc.insets = new Insets(2,  5,  2,  5);
		gbc.gridy = 1;
		add(lblCheck, gbc);
		
		numberCheck = new JTextField(18);
		numberCheck.setFont(Constants.FONTNORMAL);
		gbc.insets = new Insets(2,  5,  7,  5);
		gbc.gridy = 2;
		add(numberCheck, gbc);
		
		lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(Constants.FONTNORMAL);
		gbc.insets = new Insets(2,  5,  2,  5);
		gbc.gridy = 3;
		add(lblPassword, gbc);
		
		password = new JPasswordField(18);
		password.setFont(Constants.FONTNORMAL);
		gbc.insets = new Insets(2,  5,  15,  5);
		gbc.gridy = 4;
		add(password, gbc);
		
		login = new JButton("Ingresar");
		styleButton(login, "login", listener, new Insets (5,25,5,25), Constants.GREEN);
		gbc.insets = new Insets(2,  5, 45,  5);
		gbc.gridy = 5;
		add(login, gbc);
		
		register = new JButton("Registrarse");
		styleButton(register, "register", listener, new Insets (5,15,5,15), Constants.COLORBACKGROUNDHEADER);
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		add(register, gbc);
		
		newCheck = new JButton("Crear Cuenta");
		styleButton(newCheck, "newCheck", listener, new Insets (5,15,5,15), Constants.COLORBACKGROUNDPANEL);
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
