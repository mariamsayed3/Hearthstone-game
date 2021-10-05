package view;

import javax.swing.JLabel;


@SuppressWarnings("serial")
public abstract class CardButton extends JLabel{
	private String actionCommand;

	public String getActionCommand() {
		return actionCommand;
	}

	public void setActionCommand(String actionCommand) {
		this.actionCommand = actionCommand;
	}
	
	public abstract void setFocus();
	public abstract void removeFocus();
}
