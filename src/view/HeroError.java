package view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class HeroError extends JWindow{

	public HeroError() {
		//setBounds(750,590, 150, 199);
		setSize(639,390);
		setLocationRelativeTo(null);
		setBackground(new Color(0,0,0,0));
		JPanel c = new JPanel();
		c.setOpaque(false);	
		 c.setSize(639,390);
		 ImageIcon x = new ImageIcon(new ImageIcon("images/select.png").getImage().getScaledInstance(639,390,Image.SCALE_SMOOTH));
		 JLabel z = new JLabel(x);
		 z.setOpaque(false);
		 c.add(z);
		 setContentPane(c);
		 setVisible(true);
		 new java.util.Timer().schedule(new java.util.TimerTask() {public void run() {dispose();}},2000);
	}

}
