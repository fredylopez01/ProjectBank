package co.edu.uptc.view.body.user;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.view.body.user.funtions.PanelFuntions;
import co.edu.uptc.view.body.user.plusCenter.Balance;
import co.edu.uptc.view.body.user.plusCenter.DateLogin;

public class PanelCenterUser extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image;
	private Balance balance;
	private PanelFuntions funtions;
	private CardLayout layoutFuntions;
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
		
		funtions = new PanelFuntions(listener);
		layoutFuntions = (CardLayout) funtions.getLayout();
		layoutFuntions.show(funtions, "pBlockCount");
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridy = 1;
		gbc.gridx = 1;
		add(funtions, gbc);
		layoutFuntions.show(funtions, "pWithdraw");
	}
	
	public void updateRemant(double remant) {
		balance.updateRemant(remant);
	}
	
	@Override
	public void paint(Graphics g) {
		image = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/background.jpg")).getImage();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
}

