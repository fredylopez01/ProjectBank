package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainView extends JFrame {
	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	private CardLayout layoutMainPanel;
	private JDMessage jdMessage;
	
	public MainView(ActionListener listener) {
		super("Banco de Confianza");
		this.setSize(1000, 600);
		init(listener);
		this.setIconImage(new ImageIcon(getClass().getResource("images/bank-02.jpg")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void init(ActionListener listener) {
		setLayout(new BorderLayout());
		
		mainPanel = new MainPanel(listener);
		add(mainPanel, BorderLayout.CENTER);
		
		layoutMainPanel = (CardLayout) mainPanel.getLayout();
		
		jdMessage = new JDMessage(listener, this);
	}
	
	public String getLoginPassword() {
		return mainPanel.getLoginPassword();
	}
	
	public String getLoginNumberCheck() {
		return mainPanel.getLoginNumberCheck();
	}
	
	public void message(String message) {
		jdMessage.getLblMessage().setText(message);
		jdMessage.setVisible(true);
	}
	
	public void ok() {
		jdMessage.dispose();
	}
	
	public void loadDatesProfile(ArrayList<String> dates) {
		mainPanel.loadDatesProfile(dates);
	}
	
	public void updateRemant(double remant) {
		mainPanel.updateRemant(remant);
	}
	
	public void showPanelUser() {
		layoutMainPanel.show(mainPanel, "panelUser");
	}
}
