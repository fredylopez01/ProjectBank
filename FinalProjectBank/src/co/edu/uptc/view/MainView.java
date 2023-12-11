package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainView extends JFrame {
	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	
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
	}
}
