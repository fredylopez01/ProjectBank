package co.edu.uptc.view.body.user;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.view.Constants;

public class Options extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnConsign;
	private JButton btnWithdraw;
	private JButton btnTransfer;
	private JButton btnHistoryTransactions;
	private JButton btnChangePassword;
	private JButton btnBlockCount;
	
	public Options(ActionListener listener) {
		setBackground(Constants.COLORBACKGROUNDPANEL);
		initComponents(listener);
		addComponents();
	}

	private void initComponents(ActionListener listener) {
		btnConsign = new JButton("Consignar");
		styleButton(btnConsign, "pConsign", listener, new Insets(5, 66, 5, 66), Constants.COLORBACKGROUNDHEADER);
		
		btnWithdraw = new JButton("Retirar");
		styleButton(btnWithdraw, "pWithdraw", listener, new Insets(5, 77, 5, 77), Constants.COLORBACKGROUNDHEADER);
		
		btnTransfer = new JButton("Transferir");
		styleButton(btnTransfer, "pTransfer", listener, new Insets(5, 68, 5, 68), Constants.COLORBACKGROUNDHEADER);
		
		btnHistoryTransactions = new JButton("Historial");
		styleButton(btnHistoryTransactions, "pHistoryTransactions", listener, new Insets(5, 73, 5, 73), Constants.COLORBACKGROUNDHEADER);
		
		btnChangePassword = new JButton("Cambiar Contraseña");
		styleButton(btnChangePassword, "pChangePassword", listener, new Insets(5, 31, 5, 31), Constants.COLORBACKGROUNDHEADER);
		
		btnBlockCount = new JButton("<html><body style=\"text-align: center\">Desbloquear/Bloquear <br> Cuenta</body></html>");
		styleButton(btnBlockCount, "pBlockCount", listener, new Insets(5, 27, 5, 27), Constants.COLORBACKGROUNDHEADER);
	}
	
	public void styleButton(JButton btn, String comand, ActionListener listener, Insets insets, Color color) {
		btn.setFont(Constants.FONTNORMAL);
		btn.setForeground(Color.WHITE);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setCursor(Constants.HANDCURSOR);
		btn.setMargin(insets);
		btn.setFocusPainted(false);
		btn.setUI(new ShapedButtonMenuHover(color));
		btn.setActionCommand(comand);
		btn.addActionListener(listener);
	}
	
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 3, 5, 3);
		add(btnConsign, gbc);
		
		gbc.gridy = 1;
		add(btnWithdraw, gbc);
		
		gbc.gridy = 2;
		add(btnTransfer, gbc);
		
		gbc.gridy = 3;
		add(btnHistoryTransactions, gbc);
		
		gbc.gridy = 4;
		add(btnChangePassword, gbc);
		
		gbc.gridy = 5;
		add(btnBlockCount, gbc);
	}
}
