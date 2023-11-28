package co.edu.uptc.view.body.user.lateral;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.view.Constants;

public class Options extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon iconConsign;
	private JButton btnConsign;
	private ImageIcon iconWithdraw;
	private JButton btnWithdraw;
	private ImageIcon iconTransfer;
	private JButton btnTransfer;
	private ImageIcon iconHistoryTransactions;
	private JButton btnHistoryTransactions;
	private ImageIcon iconChangePassword;
	private JButton btnChangePassword;
	private ImageIcon iconBlockCount;
	private JButton btnBlockCount;
	
	public Options(ActionListener listener) {
		setBackground(Constants.COLORBACKGROUNDPANEL);
		initComponents(listener);
		addComponents();
	}

	private void initComponents(ActionListener listener) {
		iconConsign = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/lateral/test.png"));
		btnConsign = new JButton("CONSIGNAR");
		btnConsign.setIcon(iconConsign);
		btnConsign.setIconTextGap(11);
		styleButton(btnConsign, "pConsign", listener, new Insets(5, 5, 5, 116), Constants.COLORBACKGROUNDHEADER);
		
		iconWithdraw = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/lateral/test.png"));
		btnWithdraw = new JButton("RETIRAR");
		btnWithdraw.setIcon(iconWithdraw);
		btnWithdraw.setIconTextGap(11);
		styleButton(btnWithdraw, "pWithdraw", listener, new Insets(5, 5, 5, 139), Constants.COLORBACKGROUNDHEADER);
		
		iconTransfer = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/lateral/test.png"));
		btnTransfer = new JButton("TRANSFERIR");
		btnTransfer.setIcon(iconTransfer);
		btnTransfer.setIconTextGap(11);
		styleButton(btnTransfer, "pTransfer", listener, new Insets(5, 5, 5, 109), Constants.COLORBACKGROUNDHEADER);
		
		iconHistoryTransactions = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/lateral/test.png"));
		btnHistoryTransactions = new JButton("HISTORIAL");
		btnHistoryTransactions.setIcon(iconHistoryTransactions);
		btnHistoryTransactions.setIconTextGap(11);
		styleButton(btnHistoryTransactions, "pHistoryTransactions", listener, new Insets(5, 5, 5, 127), Constants.COLORBACKGROUNDHEADER);
		
		iconChangePassword = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/lateral/test.png"));
		btnChangePassword = new JButton("CAMBIAR CONTRASEÑA");
		btnChangePassword.setIcon(iconChangePassword);
		btnChangePassword.setIconTextGap(11);
		styleButton(btnChangePassword, "pChangePassword", listener, new Insets(5, 5, 5, 34), Constants.COLORBACKGROUNDHEADER);
		
		iconBlockCount = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/lateral/test.png"));
		btnBlockCount = new JButton("<html><body style=\"text-align: center\">DESBLOQUEAR/BLOQUEAR<br> CUEANTA</body></html>");
		btnBlockCount.setIcon(iconBlockCount);
		btnBlockCount.setIconTextGap(10);
		styleButton(btnBlockCount, "pBlockCount", listener, new Insets(5, 5, 5, 5), Constants.COLORBACKGROUNDHEADER);
	}
	
	public void styleButton(JButton btn, String comand, ActionListener listener, Insets insets, Color color) {
		btn.setFont(Constants.FONTNORMAL);
		btn.setForeground(Color.WHITE);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setCursor(Constants.HANDCURSOR);
		btn.setMargin(insets);
		btn.setFocusPainted(false);
		btn.setUI(new ShapedButtonMenu(color));
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
