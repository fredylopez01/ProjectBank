package co.edu.uptc.view.body.user;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.view.body.user.funtions.PanelWithdraw;
import co.edu.uptc.view.body.user.plusCenter.Balance;

public class PanelCenterUser extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image;
	private PanelWithdraw withdraw;
	private Balance balance;
	
	public PanelCenterUser(ActionListener listener) {
		initComponents(listener);
	}
	
	public void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		balance = new Balance(listener);
		add(balance, gbc);
		
		withdraw = new PanelWithdraw(listener);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(withdraw, gbc);
	}
	
	@Override
	public void paint(Graphics g) {
		image = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/background.jpg")).getImage();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
}

