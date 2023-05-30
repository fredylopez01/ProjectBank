package co.edu.uptc.view;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class View {
	private Icon bankIcon;
	private Icon createUser;
	private Icon changePassword;
	private Icon blockCheck;
	private Icon consultRemmant;
	private Icon withdraw;
	private Icon consign;
	private Icon transfer;
	private Icon showUsers;
	private Icon correct;
	private Icon incorrect;
	private Icon signDollar;
	private Icon signQuestion;
	
	
	public View() {
		bankIcon = new ImageIcon(new ImageIcon(getClass().getResource("bank.jpg")).getImage().getScaledInstance(300, 260, 0));
		createUser = new ImageIcon(new ImageIcon(getClass().getResource("createUser.jpg")).getImage().getScaledInstance(80, 80, 0));
		changePassword = new ImageIcon(new ImageIcon(getClass().getResource("changePassword.jpg")).getImage().getScaledInstance(60, 60, 0));
		blockCheck = new ImageIcon(new ImageIcon(getClass().getResource("blockCheck.jpg")).getImage().getScaledInstance(60, 60, 0));
		consultRemmant = new ImageIcon(new ImageIcon(getClass().getResource("consultRemmants.jpg")).getImage().getScaledInstance(60, 60, 0));
		withdraw = new ImageIcon(new ImageIcon(getClass().getResource("withdraw.jpg")).getImage().getScaledInstance(60, 60, 0));
		consign = new ImageIcon(new ImageIcon(getClass().getResource("consig.jpg")).getImage().getScaledInstance(60, 60, 0));
		transfer = new ImageIcon(new ImageIcon(getClass().getResource("transfer.jpg")).getImage().getScaledInstance(60, 60, 0));
		showUsers = new ImageIcon(new ImageIcon(getClass().getResource("showUsers.jpg")).getImage().getScaledInstance(80, 80, 0));
		correct = new ImageIcon(new ImageIcon(getClass().getResource("correct.jpg")).getImage().getScaledInstance(40, 40, 0));
		incorrect = new ImageIcon(new ImageIcon(getClass().getResource("incorrect.jpg")).getImage().getScaledInstance(40, 40, 0));
		signDollar = new ImageIcon(new ImageIcon(getClass().getResource("signDollar.jpg")).getImage().getScaledInstance(40, 40, 0));
		signQuestion = new ImageIcon(new ImageIcon(getClass().getResource("questionSign.jpg")).getImage().getScaledInstance(40, 40, 0));
	}
	
	public int readInt(String message,  String title, Icon icon) {
		return Integer.parseInt((String) JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, icon, null, null));
	}
	
	public String readString(String message,  String title, Icon icon) {
		return (String) JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, icon, null, null);
	}
	
	public void showMessage(String message, String title, Icon icon) {
		JOptionPane.showMessageDialog(null, message, title, 0, icon);
	}

	public Icon getBankIcon() {
		return bankIcon;
	}

	public void setBankIcon(Icon bankIcon) {
		this.bankIcon = bankIcon;
	}

	public Icon getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Icon createUser) {
		this.createUser = createUser;
	}

	public Icon getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(Icon changePassword) {
		this.changePassword = changePassword;
	}

	public Icon getBlockCheck() {
		return blockCheck;
	}

	public void setBlockCheck(Icon blockCheck) {
		this.blockCheck = blockCheck;
	}

	public Icon getConsultRemmant() {
		return consultRemmant;
	}

	public void setConsultRemmant(Icon consultRemmant) {
		this.consultRemmant = consultRemmant;
	}

	public Icon getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Icon withdraw) {
		this.withdraw = withdraw;
	}

	public Icon getConsign() {
		return consign;
	}

	public void setConsign(Icon consign) {
		this.consign = consign;
	}

	public Icon getTransfer() {
		return transfer;
	}

	public void setTransfer(Icon transfer) {
		this.transfer = transfer;
	}

	public Icon getShowUsers() {
		return showUsers;
	}

	public void setShowUsers(Icon showUsers) {
		this.showUsers = showUsers;
	}

	public Icon getCorrect() {
		return correct;
	}

	public void setCorrect(Icon correct) {
		this.correct = correct;
	}

	public Icon getIncorrect() {
		return incorrect;
	}

	public void setIncorrect(Icon incorrect) {
		this.incorrect = incorrect;
	}
	
	public Icon getSignDollar() {
		return signDollar;
	}

	public void setSignDollar(Icon signDollar) {
		this.signDollar = signDollar;
	}

	public Icon getSignQuestion() {
		return signQuestion;
	}

	public void setSignQuestion(Icon signQuestion) {
		this.signQuestion = signQuestion;
	}
	
}