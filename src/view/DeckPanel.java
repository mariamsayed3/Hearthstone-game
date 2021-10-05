package view;

import java.awt.Image;
import javax.swing.*;

@SuppressWarnings("serial")
public class DeckPanel extends JLabel {
	public DeckPanel(int x) {
		super();
		String path = "images/CardsTemplates/deck1.png";
		Image img = new ImageIcon(path).getImage().getScaledInstance(50, 114, Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(img));
		this.setToolTipText("Cards Remaining: " + x);
	}

	public void update(int x) {
		if (x > 12) {
			String path = "images/CardsTemplates/deck1.png";
			Image img = new ImageIcon(path).getImage().getScaledInstance(50, 114, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(img));
		} else if (x > 6) {
			String path = "images/CardsTemplates/deck2.png";
			Image img = new ImageIcon(path).getImage().getScaledInstance(50, 114, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(img));
		} else if (x > 0) {
			String path = "images/CardsTemplates/deck3.png";
			Image img = new ImageIcon(path).getImage().getScaledInstance(50, 114, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(img));
		} else if (x == 0) {
			String path = "images/CardsTemplates/deck4.png";
			Image img = new ImageIcon(path).getImage().getScaledInstance(50, 114, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(img));
		}
	}

}
