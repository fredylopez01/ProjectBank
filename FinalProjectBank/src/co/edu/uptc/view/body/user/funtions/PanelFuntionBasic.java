package co.edu.uptc.view.body.user.funtions;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import co.edu.uptc.view.Constants;
import co.edu.uptc.view.body.ShapedButtonProfile;
import co.edu.uptc.view.body.login.ShapedPanelLoginUI;

public class PanelFuntionBasic extends JPanel {
	private static final long serialVersionUID = 1L;
	protected JLabel lblTitlePanel;
	protected JLabel lblPassword;
	protected JPasswordField password;
	protected JButton btnAction;
	
	public PanelFuntionBasic() {
		setUI(new ShapedPanelLoginUI(Constants.COLORPANELFUNTION));
		
		lblTitlePanel = new JLabel();
		lblTitlePanel.setFont(Constants.FONTTITLEPANEL);
		
		lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(Constants.FONTNORMAL);
		
		password = new JPasswordField(18);
		password.setFont(Constants.FONTNORMAL);
		
		btnAction = new JButton();
		btnAction.setFont(Constants.FONTNORMAL);
		styleButton(btnAction, new Insets(5, 15, 5, 15), Constants.GREEN);
	}
	
	public void styleButton(JButton btn,Insets insets, Color color) {
		btn.setFont(Constants.FONTNORMAL);
		btn.setForeground(Color.WHITE);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		btn.setCursor(Constants.HANDCURSOR);
		btn.setMargin(insets);
		btn.setFocusPainted(false);
		btn.setUI(new ShapedButtonProfile(color));
	}
	
	public void actionButton(JButton btn, String comand, ActionListener listener) {
		btn.setActionCommand(comand);
		btn.addActionListener(listener);
	}
}
