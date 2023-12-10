package co.edu.uptc.view.body.user.lateral;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.uptc.view.Constants;

public class ProfileInformation extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon imgUser;
	private JLabel img;
	private JLabel lblOwner;
	private JLabel lblIdentification;
	private JLabel identification;
	private JLabel lblNumberCheck;
	private JLabel numberCheck;
	private JLabel lblTypeAccount;
	
	public ProfileInformation(ActionListener listener) {
		setBorder(new EmptyBorder(10, 19, 10, 19));
		setBackground(Constants.COLORPANELLOGIN);
		initComponents(listener);
		addComponents();
	}

	private void initComponents(ActionListener listener) {
		imgUser = new ImageIcon(getClass().getResource("/co/edu/uptc/view/images/changeAccount.png"));
		img = new JLabel(imgUser);
		
		lblOwner = new JLabel("<html><body style=\"text-align: center\">FREDY OSWALDO<br> LÓPEZ DAZA</body></html>");
		lblOwner.setFont(Constants.FONTNAMEUSER);
		
		lblIdentification = new JLabel("Identificación: ");
		lblIdentification.setFont(Constants.FONTDATESUSER);
		
		identification = new JLabel("1054708088");
		identification.setFont(Constants.FONTDATESUSER);
		
		lblNumberCheck = new JLabel("N. Cuenta: ");
		lblNumberCheck.setFont(Constants.FONTDATESUSER);
		
		numberCheck = new JLabel("123");
		numberCheck.setFont(Constants.FONTDATESUSER);
		
		lblTypeAccount = new JLabel("Cuenta Corriente");
		lblTypeAccount.setFont(Constants.FONTDATESUSER);
	}
	
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridwidth = 2;
		add(img, gbc);
		
		gbc.gridy = 1;
		add(lblOwner, gbc);
		
		gbc.gridwidth = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(lblIdentification, gbc);
		
		gbc.gridx = 1;
		add(identification, gbc);
		
		gbc.gridy = 3;
		gbc.gridx = 0;
		add(lblNumberCheck, gbc);
		
		gbc.gridx = 1;
		add(numberCheck, gbc);
		
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		add(lblTypeAccount, gbc);
	}
}
