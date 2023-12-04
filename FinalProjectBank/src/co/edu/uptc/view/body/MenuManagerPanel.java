package co.edu.uptc.view.body;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuManagerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel iconChangePassword;
	private JButton changePassword;
	private JLabel iconBlockCountManager;
	private JButton blockCountManager;
	private JLabel iconLiquidateInterest;
	private JButton liquidateInterest;
	private JLabel iconShowChecks;
	private JButton showChecks;
	
	public MenuManagerPanel(ActionListener listener) {
		this.setBackground(Color.GREEN);
		init();
		add();
	}
	
	public void init() {
		Icon iCP = new ImageIcon(new ImageIcon(getClass().getResource("images/changePassword.jpg")).getImage().getScaledInstance(40, 40, 0));
		iconChangePassword = new JLabel(iCP);
		
		changePassword = new JButton("Cambiar Contraseña");
		
		Icon iBCM = new ImageIcon(new ImageIcon(getClass().getResource("images/blockCheck.jpg")).getImage().getScaledInstance(40, 40, 0));
		iconBlockCountManager = new JLabel(iBCM);
		
		blockCountManager = new JButton("Bloquear o Desbloquear Cuenta");
		
		Icon iLI = new ImageIcon(new ImageIcon(getClass().getResource("images/signDollar.jpg")).getImage().getScaledInstance(40, 40, 0));
		iconLiquidateInterest = new JLabel(iLI);
		
		liquidateInterest = new JButton("Liquidar Interes");
		
		Icon iSC = new ImageIcon(new ImageIcon(getClass().getResource("images/showUsers.jpg")).getImage().getScaledInstance(40, 40, 0));
		iconShowChecks = new JLabel(iSC);
		
		showChecks = new JButton("Mostrar cuentas o Usuarios");
	}
	
	public void add() {
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(4, 4, 4, 0);
		add(iconChangePassword, gbc);
		
		gbc.gridy = 1;
		add(iconBlockCountManager, gbc);
		
		gbc.gridy = 2;
		add(iconLiquidateInterest, gbc);
		
		gbc.gridy = 3;
		add(iconShowChecks, gbc);
		
		gbc.insets = new Insets(4, 0, 4, 4);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(changePassword, gbc);
		
		gbc.gridy = 1;
		add(blockCountManager, gbc);
		
		gbc.gridy = 2;
		add(liquidateInterest, gbc);
		
		gbc.gridy = 3;
		add(showChecks, gbc);
	}
}
