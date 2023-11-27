package co.edu.uptc.view.body;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelContentBeginning extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image;
	private PanelBeginning begin;
	
	public PanelContentBeginning(ActionListener listener) {
		initComponents(listener);
	}
	
	public void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		begin = new PanelBeginning(listener);
		add(begin, gbc);
	}
	
	@Override
	public void paint(Graphics g) {
		image = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/background.jpg")).getImage();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
}
