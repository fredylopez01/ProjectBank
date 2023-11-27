package co.edu.uptc.view.body.user;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Options extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnConsign;
	private JButton btnWithdraw;
	private JButton btnTransfer;
	private JButton btnHistoryTransactions;
	private JButton btnChangePassword;
	private JButton btnBlockCount;
	
	public Options(ActionListener listener) {
		initComponents(listener);
		addComponents();
	}

	private void initComponents(ActionListener listener) {
		btnConsign = new JButton("Consignar");
		
		btnWithdraw = new JButton("Retirar");
		
		btnTransfer = new JButton("Transferir");
		
		btnHistoryTransactions = new JButton("Historial");
		
		btnChangePassword = new JButton("Cambiar Contraseña");
		
		btnBlockCount = new JButton("<html><body>Desbloquear/Bloquear <br> Cuenta</body></html>");
	}
	
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
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
		add(btnBlockCount);
	}
}
