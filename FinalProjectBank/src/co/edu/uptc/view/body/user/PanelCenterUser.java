package co.edu.uptc.view.body.user;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import co.edu.uptc.view.body.user.funtions.ContentWithdraw;

public class PanelCenterUser extends JPanel {
	private static final long serialVersionUID = 1L;
	private ContentWithdraw panelWithDraw;
	
	public PanelCenterUser(ActionListener listener) {
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new CardLayout());
		
		panelWithDraw = new ContentWithdraw(listener);
		add(panelWithDraw, "panelWithdraw");
	}

}
