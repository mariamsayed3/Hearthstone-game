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

import model.heroes.Hero;

@SuppressWarnings("serial")
public class GameOver extends JWindow {
	public GameOver(Hero H1 , Hero H2) {
		if (H1.getName().equals("Rexxar")) {
		setSize(500,450);
		setLocationRelativeTo(null);
		setBackground(new Color(0,0,0,0));
		JPanel c = new JPanel();
		c.setOpaque(false);	
		 c.setSize(500,450);
		 ImageIcon x = new ImageIcon(new ImageIcon("images/RW.png").getImage().getScaledInstance(500,450,Image.SCALE_SMOOTH));
		 JLabel z = new JLabel(x);
		 z.setOpaque(false);
		 c.add(z);
		 setContentPane(c);
		}
		else if (H1.getName().equals("Jaina Proudmoore")) {
			setSize(500,450);
			setLocationRelativeTo(null);
			setBackground(new Color(0,0,0,0));
			JPanel c = new JPanel();
			c.setOpaque(false);	
			 c.setSize(500,450);
			 if (H1.getCurrentHP()!=0) {
			 ImageIcon x = new ImageIcon(new ImageIcon("images/JW.png").getImage().getScaledInstance(500,450,Image.SCALE_SMOOTH));
			 JLabel z = new JLabel(x);
			 z.setOpaque(false);
			 c.add(z);
			 }
			 else {
				 if(H2.getName().equals("Rexxar")) {
				 ImageIcon x = new ImageIcon(new ImageIcon("images/RW.png").getImage().getScaledInstance(500,450,Image.SCALE_SMOOTH));
				 JLabel z = new JLabel(x);
				 z.setOpaque(false);
				 c.add(z);
				 }
				 else if(H2.getName().equals("Jaina Proudmoore")) {
					 ImageIcon x = new ImageIcon(new ImageIcon("images/JW.png").getImage().getScaledInstance(500,450,Image.SCALE_SMOOTH));
					 JLabel z = new JLabel(x);
					 z.setOpaque(false);
					 c.add(z);
					 }
				 else if(H2.getName().equals("Uther Lightbringer")) {
					 ImageIcon x = new ImageIcon(new ImageIcon("images/UW.png").getImage().getScaledInstance(500,450,Image.SCALE_SMOOTH));
					 JLabel z = new JLabel(x);
					 z.setOpaque(false);
					 c.add(z);
					 }
				 else if(H2.getName().equals("Anduin Wrynn")) {
					 ImageIcon x = new ImageIcon(new ImageIcon("images/AW.png").getImage().getScaledInstance(500,450,Image.SCALE_SMOOTH));
					 JLabel z = new JLabel(x);
					 z.setOpaque(false);
					 c.add(z);
					 }
				 else if(H2.getName().equals("Gul'dan")) {
					 ImageIcon x = new ImageIcon(new ImageIcon("images/GW.png").getImage().getScaledInstance(500,450,Image.SCALE_SMOOTH));
					 JLabel z = new JLabel(x);
					 z.setOpaque(false);
					 c.add(z);
					 }
			 }
			 setContentPane(c);
			}
		else if (H1.getName().equals("Uther Lightbringer")) {
			setSize(500,450);
			setLocationRelativeTo(null);
			setBackground(new Color(0,0,0,0));
			JPanel c = new JPanel();
			c.setOpaque(false);	
			 c.setSize(500,450);
			 ImageIcon x = new ImageIcon(new ImageIcon("images/UW.png").getImage().getScaledInstance(500,450,Image.SCALE_SMOOTH));
			 JLabel z = new JLabel(x);
			 z.setOpaque(false);
			 c.add(z);
			 setContentPane(c);
			}
		else if (H1.getName().equals("Anduin Wrynn")) {
			setSize(500,450);
			setLocationRelativeTo(null);
			setBackground(new Color(0,0,0,0));
			JPanel c = new JPanel();
			c.setOpaque(false);	
			 c.setSize(500,450);
			 ImageIcon x = new ImageIcon(new ImageIcon("images/AW.png").getImage().getScaledInstance(500,450,Image.SCALE_SMOOTH));
			 JLabel z = new JLabel(x);
			 z.setOpaque(false);
			 c.add(z);
			 setContentPane(c);
			}
		else if (H1.getName().equals("Gul'dan")) {
			setSize(500,450);
			setLocationRelativeTo(null);
			setBackground(new Color(0,0,0,0));
			JPanel c = new JPanel();
			c.setOpaque(false);	
			 c.setSize(500,450);
			 ImageIcon x = new ImageIcon(new ImageIcon("images/GW.png").getImage().getScaledInstance(500,450,Image.SCALE_SMOOTH));
			 JLabel z = new JLabel(x);
			 z.setOpaque(false);
			 c.add(z);
			 setContentPane(c);
			}
		setVisible(true);
		playAudio("sounds/victory2.wav");
		playAudio("sounds/victory1.wav");
		new java.util.Timer().schedule(new java.util.TimerTask() {public void run() {dispose();}},4000);
		 
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
