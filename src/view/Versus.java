package view;

import java.awt.BorderLayout;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import model.heroes.Hero;

@SuppressWarnings("serial")
public class Versus extends JPanel{

	public Versus(Hero hero1, Hero hero2) {
		String Str1 = hero1.getName();
		String Str2 = hero2.getName();
		String res = "images/Vs/";
		if (Str1.charAt(0) == 'J')
			res += "Jaina1vs";
		else if (Str1.charAt(0) == 'G')
			res += "Guldan1vs";
		else if (Str1.charAt(0) == 'A')
			res += "Anduin1vs";
		else if (Str1.charAt(0) == 'R')
			res += "Rexxar1vs";
		else
			res += "Uther1vs";
		if (Str2.charAt(0) == 'J')
			res += "Jaina2.jpg";
		else if (Str2.charAt(0) == 'G')
			res += "Guldan2.jpg";
		else if (Str2.charAt(0) == 'A')
			res += "Anduin2.jpg";
		else if (Str2.charAt(0) == 'R')
			res += "Rexxar2.jpg";
		else
			res += "Uther2.jpg";
		//System.out.println(res);
		BackgroundImage img = new BackgroundImage(res);
		setLayout(new BorderLayout());
		add(img);
		setBounds(0,0,1366,768);
		setVisible(true);
		new java.util.Timer().schedule(new java.util.TimerTask() {public void run() {playAudio("sounds/versus/"+hero1.getName().charAt(0)+".wav");}},500);
		new java.util.Timer().schedule(new java.util.TimerTask() {public void run() {playAudio("sounds/versus/vs.wav");}},1500);
		new java.util.Timer().schedule(new java.util.TimerTask() {public void run() {playAudio("sounds/versus/"+hero2.getName().charAt(0)+".wav");}},2500);
	}
	
	public static void playAudio(String path) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		} catch (Exception e) {

		}
	}
}
