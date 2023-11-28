package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import co.edu.uptc.view.body.login.PanelContentBeginning;
import co.edu.uptc.view.body.user.PanelUser;

public class MainView extends JFrame {
	private static final long serialVersionUID = 1L;
	private PanelContentBeginning contentBegin;
	
	public static void main(String[] args) {
		new MainView(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}
		);
	}
	
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
		
		contentBegin = new PanelContentBeginning(listener);
		
		PanelUser panelUser = new PanelUser(listener);
		add(contentBegin, BorderLayout.CENTER);
	}
}
