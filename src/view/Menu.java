package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JPanel{
	
	public Menu(ActionListener listener) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		BackgroundImage background = new BackgroundImage("images/menu.jpg");
		setLayout(new BorderLayout());
		add(background);
		HearthStoneButton resume = new HearthStoneButton("images/resume.jpg", 150, 80, "Resume", listener);
		HearthStoneButton replay = new HearthStoneButton("images/replay.jpg", 150, 80, "Back", listener);
		HearthStoneButton home = new HearthStoneButton("images/home.jpg", 150, 80, "home", listener);
		background.add(resume);
		background.add(replay);
		background.add(home);
		resume.setBounds(550, 250, 300, 70);
		replay.setBounds(550, 350, 300, 70);
		home.setBounds(550, 450, 300, 70);
		setVisible(true);
		revalidate();
		repaint();
	}

}
