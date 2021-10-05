package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class Bye extends JWindow{

	public Bye() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0,0,screenSize.width,screenSize.height);
		setBackground(new Color(0,0,0,0));
		JPanel c = new JPanel();
		c.setOpaque(false);	
		c.setBounds(0,0,screenSize.width,screenSize.height);
		ImageIcon x = new ImageIcon(new ImageIcon("images/GOODBYE.jpg").getImage().getScaledInstance(screenSize.width,screenSize.height,Image.SCALE_SMOOTH));
		JLabel z = new JLabel(x);
		z.setOpaque(false);
		c.add(z);
		setContentPane(c);
		setVisible(true);
		playAudio("sounds/ending.wav");
		
	}
	public static void playAudio(String path) {
		try {
			AudioInputStream ais= AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e) {
			
		}
	}

}
