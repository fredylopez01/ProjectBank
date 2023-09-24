package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainView extends JFrame {
	private static final long serialVersionUID = 1L;
	private Images img;
	private HeaderPanel header;
	private MenuPanel menu;
	
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
		this.setSize(500, 300);
		init(listener);
		this.setIconImage(new ImageIcon(getClass().getResource("images/bank-01.jpg")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void init(ActionListener listener) {
		img = new Images();
		this.setLayout(new BorderLayout());
		
		header = new HeaderPanel(listener,img.getMainIcon() );
		add(header, BorderLayout.NORTH);
	}
}
