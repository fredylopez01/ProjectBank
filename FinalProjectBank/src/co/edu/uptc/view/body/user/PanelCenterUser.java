package co.edu.uptc.view.body.user;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.view.body.user.funtions.PanelTransfer;
import co.edu.uptc.view.body.user.funtions.PanelWithdraw;
import co.edu.uptc.view.body.user.plusCenter.Balance;
import co.edu.uptc.view.body.user.plusCenter.DateLogin;

public class PanelCenterUser extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image;
	private PanelWithdraw withdraw;
	private PanelTransfer transfer;
	private Balance balance;
	private DateLogin date;
	
	public PanelCenterUser(ActionListener listener) {
		initComponents(listener);
	}
	
	public void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		date = new DateLogin();
		gbc.gridx = 2;
		add(date, gbc);
		
		balance = new Balance(listener);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridy = 0;
		gbc.gridx = 0;
		add(balance, gbc);
		
		withdraw = new PanelWithdraw(listener);
		transfer = new PanelTransfer(listener);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		add(transfer, gbc);
	}
	
	@Override
	public void paint(Graphics g) {
		image = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/background.jpg")).getImage();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
}

