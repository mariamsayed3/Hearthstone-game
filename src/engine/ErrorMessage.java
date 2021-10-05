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



import exceptions.*;
import model.heroes.Hero;
import view.CardButton;
import view.HeroButton;
import view.MinionButton;

@SuppressWarnings("serial")
public class ErrorMessage extends JWindow {
   
	public ErrorMessage(HearthstoneException e,CardButton b,Hero v) {
		
		if (e instanceof NotEnoughManaException) {
		setBounds(750,590, 150, 199);
		setBackground(new Color(0,0,0,0));
		JPanel c = new JPanel();
		c.setOpaque(false);	
		 c.setBounds(750,590, 150, 199);
		 ImageIcon x = new ImageIcon(new ImageIcon("images/minion4.png").getImage().getScaledInstance(150,199,Image.SCALE_SMOOTH));
		 JLabel z = new JLabel(x);
		 z.setOpaque(false);
		 c.add(z);
		 setContentPane(c);
		 if (v.getName().equals("Jaina Proudmoore")) {
			 playAudio("sounds/manamage.wav");
		 }
		 else {
		 playAudio("sounds/Mana.wav");
		 }
		 
		}
		
		  else if (e instanceof FullHandException) { 
			 setBounds(830,590, 150, 199);
			setBackground(new Color(0,0,0,0));
			JPanel c = new JPanel();
			c.setOpaque(false);	
		  c.setBounds(830,590, 150, 199);
		  ImageIcon x = new ImageIcon(new ImageIcon("images/minion3.png").getImage().getScaledInstance(150,199,Image.SCALE_SMOOTH));
		  JLabel z = new JLabel(x); 
		  z.setOpaque(false);
		  c.add(z); 
		  setContentPane(c);
		  if (v.getName().equals("Jaina Proudmoore")) {
			  playAudio("sounds/fullhandmage.wav");
			 }
			 else {
			 playAudio("sounds/FULL HAND.wav");
			 }
		  } else if (e instanceof FullFieldException) { 
			  setBounds(310,280, 150, 199);
				setBackground(new Color(0,0,0,0));
				JPanel c = new JPanel();
				c.setOpaque(false);	
			  c.setBounds(310,280, 150, 199); 
			  ImageIcon x = new ImageIcon(new ImageIcon("images/minion2.png").getImage().getScaledInstance(150,199,Image.SCALE_SMOOTH)); 
			  JLabel z = new JLabel(x);
			  z.setOpaque(false);
				 c.add(z);
				 setContentPane(c); 
			  if (v.getName().equals("Jaina Proudmoore")) {
				  playAudio("sounds/fullfieldmage.wav");
				 }
				 else {
				 playAudio("sounds/FULL FIELD.wav");
				 }
			} else if (e instanceof CannotAttackException) { 
				setBounds(900,250, 150, 199);
				setBackground(new Color(0,0,0,0));
				JPanel c = new JPanel();
				c.setOpaque(false);	
				c.setBounds(900,250, 150, 199); 
				ImageIcon x = new ImageIcon(new ImageIcon("images/minion1.png").getImage().getScaledInstance(150,199,Image.SCALE_SMOOTH)); 
				JLabel z = new JLabel(x); 
				z.setOpaque(false);
				 c.add(z);
				 setContentPane(c); 
				 if (v.getName().equals("Jaina Proudmoore")) {
					 if(e.getMessage().equals("The minion has already attacked!!"))
					 {
						 playAudio("sounds/minionalreadyattackedmage.wav");
					 }
					 else {
				 playAudio("sounds/endturn mage.wav");
					 }
				 }
				 else {
					 if(e.getMessage().equals("The minion has already attacked!!"))
					 {
						 playAudio("sounds/MINION ALREADY ATTACKED.wav");
					 }
					 else {
				 playAudio("sounds/ENDTURN.wav");
					 }
				 }
				 } 
			else if (e instanceof NotSummonedException) { 
				setBounds(0,555, 150, 199);
				setBackground(new Color(0,0,0,0));
				JPanel c = new JPanel();
				c.setOpaque(false);	
				c.setBounds(0,555, 150, 199); 
				ImageIcon x = new ImageIcon(new ImageIcon("images/minion4.png").getImage().getScaledInstance(150,199,Image.SCALE_SMOOTH)); 
				JLabel z = new JLabel(x);
				z.setOpaque(false);
				 c.add(z);
				 setContentPane(c);
				 if (v.getName().equals("Jaina Proudmoore")) {
					 playAudio("sounds/notsummonedmage.wav");
				 }
				 else {
				 playAudio("sounds/not summoned.wav");
				 }}
			else if (e instanceof TauntBypassException) { 
				setBounds(180,150, 150, 199);
				setBackground(new Color(0,0,0,0));
				JPanel c = new JPanel();
				c.setOpaque(false);	
				c.setBounds(310,150, 150, 199); 
				ImageIcon x = new ImageIcon(new ImageIcon("images/minion2.png").getImage().getScaledInstance(150,199,Image.SCALE_SMOOTH)); 
				JLabel z = new JLabel(x);
				z.setOpaque(false);
				 c.add(z);
				 setContentPane(c); 
				 if (v.getName().equals("Jaina Proudmoore")) {
					 playAudio("sounds/tauntmage.wav");
				 }
				 else {
				 playAudio("sounds/taunt.wav");
				 }} 
			else if (e instanceof NotYourTurnException) {
				setBounds(1180,150, 150, 199);
				setBackground(new Color(0,0,0,0));
				JPanel c = new JPanel();
				c.setOpaque(false);	
				c.setBounds(1180,150, 150, 199); 
				ImageIcon x = new ImageIcon(new ImageIcon("images/minion3.png").getImage().getScaledInstance(150,199,Image.SCALE_SMOOTH)); 
				JLabel z = new JLabel(x); 
				z.setOpaque(false);
				 c.add(z);
				 setContentPane(c); 
				 if (v.getName().equals("Jaina Proudmoore")) {
					 playAudio("sounds/endturnmage.wav");
				 }
				 else {
				 playAudio("sounds/ENDTURN.wav");
				 }} 
			else if (e instanceof InvalidTargetException) { 
				if (b instanceof HeroButton) {
					setBounds(500,0, 150, 199);
					setBackground(new Color(0,0,0,0));
					JPanel c = new JPanel();
					c.setOpaque(false);	
					c.setBounds(500,0,150, 199);
					ImageIcon x = new ImageIcon(new ImageIcon("images/minion2.png").getImage().getScaledInstance(150,199,Image.SCALE_SMOOTH)); 
					JLabel z = new JLabel(x);
					z.setOpaque(false);
					 c.add(z);
					 setContentPane(c);
					 if (v.getName().equals("Jaina Proudmoore")) {
						playAudio("sounds/invalidtargetmage.wav");
					 }
					 else {
					 playAudio("sounds/INVALID TARGET.wav");
					 }
					 } 
				else if (b instanceof MinionButton) { 
					setBounds(160,250, 150, 199);
					setBackground(new Color(0,0,0,0));
					JPanel c = new JPanel();
					c.setOpaque(false);	
					c.setBounds(310,170, 150, 199);
					ImageIcon x = new ImageIcon(new ImageIcon("images/minion2.png").getImage().getScaledInstance(150,199,Image.SCALE_SMOOTH)); 
					JLabel z = new JLabel(x); 
					z.setOpaque(false);
					 c.add(z);
					 setContentPane(c);
					 if (v.getName().equals("Jaina Proudmoore")) {
						 playAudio("sounds/invalidtargetmage.wav");
					 }
					 else {
					 playAudio("sounds/INVALID TARGET.wav");
					 }
					 } 
			else if(e.getMessage()== "Icehowl minions cannot attack heros directly!!") {
			setBounds(310,280, 150, 199);
			setBackground(new Color(0,0,0,0));
			JPanel c = new JPanel();
			c.setOpaque(false);	
			c.setBounds(310,280, 150, 199);
		  ImageIcon x = new ImageIcon(new ImageIcon("images/minion2.png").getImage().getScaledInstance(150,199,Image. SCALE_SMOOTH)); 
		  JLabel z = new JLabel(x); 
		  z.setOpaque(false);
			 c.add(z);
			 setContentPane(c);
		  if (v.getName().equals("Jaina Proudmoore")) {
			  playAudio("sounds/invalidtargetmage.wav"); 
			 }
			 else {
			 playAudio("sounds/INVALID TARGET.wav");
			 }
		  }
		} 
		else if (e instanceof HeroPowerAlreadyUsedException) {
					setBounds(470,450, 150, 199);
					setBackground(new Color(0,0,0,0));
					JPanel c = new JPanel();
					c.setOpaque(false);	
					c.setBounds(470,450, 150, 199);
					ImageIcon x= new ImageIcon(new ImageIcon("images/minion4.png").getImage().getScaledInstance(150,199,Image.SCALE_SMOOTH)); 
					JLabel z = new JLabel(x);
					z.setOpaque(false);
					 c.add(z);
					 setContentPane(c); 
					 if (v.getName().equals("Jaina Proudmoore")) {
						 playAudio("sounds/usedpowermage.wav");
					 }
					 else {
					 playAudio("sounds/USED POWER.wav");
					 }
					}
		 
		setVisible(true);
		
		new java.util.Timer().schedule(new java.util.TimerTask() {public void run() {dispose();}},2000);
		
		
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
