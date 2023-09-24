package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
	

public class HeaderPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel logo;
	private JLabel title;
	private JButton manager;
	private JButton user;
	private JButton exit;
	private JLabel date;
	
	public HeaderPanel(ActionListener listener,Icon img) {
		init(listener, img);
		add();
	}
	
	public void init(ActionListener listener,Icon img) {
		logo = new JLabel(img);
		
		title = new JLabel("Banco de Confianza");
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		
		manager = new JButton("Administrador");
		manager.setActionCommand("manager");
		manager.addActionListener(listener);
		
		user = new JButton("Usuario");
		user.setActionCommand("user");
		user.addActionListener(listener);
		
		exit = new JButton("Salir");
		exit.setActionCommand("exit");
		exit.addActionListener(listener);
		
		date = new JLabel(LocalDate.now().toString());
		date.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
	}
	
	public void add() {
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(4, 4, 4, 4);
		gbc.fill = GridBagConstraints.BOTH;
		add(logo, gbc);
		
		gbc.gridx = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.SOUTH;
		add(title, gbc);
		
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		add(manager, gbc);
		
		gbc.gridx = 3;
		add(user, gbc);
		
		gbc.gridx = 4;
		add(exit, gbc);
		
		gbc.gridy = 0;
		gbc.gridx = 5;
		gbc.gridwidth = 2;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		add(date, gbc);
	}
}
