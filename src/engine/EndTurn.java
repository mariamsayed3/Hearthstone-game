package engine;

import java.awt.Color;
import java.awt.Image;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class EndTurn extends JWindow{

	public EndTurn() {
		setSize(700,92);
		setLocationRelativeTo(null);
		setBackground(new Color(0,0,0,0));
		JPanel c = new JPanel();
		c.setOpaque(false);	
		c.setSize(942, 124);
		ImageIcon x = new ImageIcon(new ImageIcon("images/End.png").getImage().getScaledInstance(700,92,Image.SCALE_SMOOTH));
		JLabel z = new JLabel(x);
		z.setOpaque(false);
		c.add(z);
		setContentPane(c);
		playAudio("sounds/turnB.wav");
		setVisible(true);
		new java.util.Timer().schedule(new java.util.TimerTask() {public void run() {dispose();}},1000);
			 
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
