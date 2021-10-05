package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class OpponentHand extends JLabel{

	public OpponentHand() {
		setIcon(new ImageIcon(new ImageIcon("images/CardsTemplates/CardsCover.png").getImage().getScaledInstance(55,80,Image.SCALE_SMOOTH)));
	}
}
