package co.edu.uptc.view.body.user.funtions;

import java.awt.CardLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import co.edu.uptc.view.Constants;
import co.edu.uptc.view.body.login.ShapedPanelLoginUI;

public class PanelFuntions extends JPanel {
	private static final long serialVersionUID = 1L;
	private PanelWithdraw withdraw;
	private PanelTransfer transfer;
	private PanelHistory history;
	private PanelChangePassword changePassword;
	private PanelBlockCheck blockCheck;
	
	public PanelFuntions(ActionListener listener) {
		initComponents(listener);
		
		setUI(new ShapedPanelLoginUI(Constants.TRANSPARENT));
	}

	private void initComponents(ActionListener listener) {
		setLayout(new CardLayout());
		
		withdraw = new PanelWithdraw(listener);
		add(withdraw, "pWithdraw");
		
		transfer = new PanelTransfer(listener);
		add(transfer, "pTransfer");
		
		history = new PanelHistory();
		add(history, "pHistoryTransactions");
		
		changePassword = new PanelChangePassword(listener);
		add(changePassword, "pChangePassword");
		
		blockCheck = new PanelBlockCheck(listener);
		add(blockCheck, "pBlockCount");
	}

}
