package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameIntro extends JPanel {
	public GameIntro(ActionListener buttonsListener) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		BackgroundImage background = new BackgroundImage("images/background.png");
		setLayout(new BorderLayout());
		add(background);
		HearthStoneButton playBtn = new HearthStoneButton("images/play.png", 400, 330, "playBtn", buttonsListener);
		HearthStoneButton exitBtn = new HearthStoneButton("images/exit.png", 300, 70, "exitBtn", buttonsListener);
		background.add(playBtn);
		background.add(exitBtn);
		playBtn.setBounds(500, 150, 400, 330);
		exitBtn.setBounds(550, 480, 300, 70);
		Image CursorImage = new ImageIcon("Cursors/IntroCursor.png").getImage();
		Point hotSpot = new Point(3, 3);
		Cursor IntroCursor = Toolkit.getDefaultToolkit().createCustomCursor(CursorImage, hotSpot, "IntroCursor");
		this.setCursor(IntroCursor);
	}
}
