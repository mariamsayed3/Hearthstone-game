package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import engine.Controller;
import model.heroes.Hero;
import model.heroes.Hunter;
import model.heroes.Mage;
import model.heroes.Paladin;
import model.heroes.Priest;
import model.heroes.Warlock;

@SuppressWarnings("serial")
public class GameView extends JFrame implements ActionListener {
	private GameIntro intro;
	private HeroScreen heroScreen;
	private Platform platform;
	private Menu menu;
	private Hero hero1;
	private Hero hero2;
	private boolean flag;
	private boolean flag2;
	private String str;
	private String str2;

	public GameView() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		intro = new GameIntro(this);
		heroScreen = new HeroScreen(this);
		menu = new Menu(this);
		setTitle("HearthStone team 122");
		setUndecorated(true);
		setContentPane(intro);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("images/frame.png").getImage());
		// Controller.playAudio("sounds/main.wav");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof HearthStoneButton) {
			String x = ((HearthStoneButton) e.getSource()).getActionCommand();
			if (x == "playBtn")
				setContentPane(heroScreen);
			else if (x == "exitBtn") {
				new Bye();
				new java.util.Timer().schedule(new java.util.TimerTask() {public void run() {System.exit(0);}},4000);
			}
			else if (x == "back") {
				setContentPane(intro);
				clearHeroScreen();
			}
			else if (x == "next") {
				if (hero1 == null || hero2 == null)
					new HeroError();
				else {
					platform = new Platform();
					Versus v = new Versus(hero1,hero2);
					setContentPane(v);
					new java.util.Timer().schedule(new java.util.TimerTask() {public void run() {setContentPane(platform);}},3000);
					
					try {
						new Controller(this, hero1, hero2);
					} catch (Exception e1) {
					}
				}
			}
			else if (x.equals("Resume")) {
				setContentPane(platform);
			}
			
			else if (x.equals("Back")) {
				clearHeroScreen();
				setContentPane(heroScreen);
			} 
			
			else if (x.equals("home")) {
				clearHeroScreen();
				setContentPane(intro);
			}
			
		} else {
			String x = ((HeroSelectionButton) e.getSource()).getActionCommand();
			if (x == "Rexxar1") {
				if (flag) {
					if (str.charAt(0) == 'A')
						clearA1();
					else if (str.charAt(0) == 'R')
						clearR1();
					else if (str.charAt(0) == 'J')
						clearJ1();
					else if (str.charAt(0) == 'U')
						clearU1();
					else
						clearG1();
				} else {
					flag = true;
				}
				str = "R1";
				heroScreen.getRexxar1().setIcon(new ImageIcon(new ImageIcon("images/RexxarSelected.png").getImage()
						.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
				playAudio("sounds/r1.wav");
				try {
					hero1 = new Hunter();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(0);
				}
			}
			if (x == "Rexxar2") {
				if (flag2) {
					if (str2.charAt(0) == 'A')
						clearA2();
					else if (str2.charAt(0) == 'R')
						clearR2();
					else if (str2.charAt(0) == 'J')
						clearJ2();
					else if (str2.charAt(0) == 'U')
						clearU2();
					else
						clearG2();
				} else {
					flag2 = true;
				}
				str2 = "R2";
				heroScreen.getRexxar2().setIcon(new ImageIcon(new ImageIcon("images/RexxarSelected.png").getImage()
						.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
				playAudio("sounds/r2.wav");
				try {
					hero2 = new Hunter();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(0);
				}
			}
			if (x == "Guldan1") {
				if (flag) {
					if (str.charAt(0) == 'A')
						clearA1();
					else if (str.charAt(0) == 'R')
						clearR1();
					else if (str.charAt(0) == 'J')
						clearJ1();
					else if (str.charAt(0) == 'U')
						clearU1();
					else
						clearG1();
				} else {
					flag = true;
				}
				str = "G1";
				heroScreen.getGuldan1().setIcon(new ImageIcon(new ImageIcon("images/GuldanSelected.png").getImage()
						.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
				playAudio("sounds/G1.wav");
				try {
					hero1 = new Warlock();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(0);
				}
			}
			if (x == "Guldan2") {
				if (flag2) {
					if (str2.charAt(0) == 'A')
						clearA2();
					else if (str2.charAt(0) == 'R')
						clearR2();
					else if (str2.charAt(0) == 'J')
						clearJ2();
					else if (str2.charAt(0) == 'U')
						clearU2();
					else
						clearG2();
				} else {
					flag2 = true;
				}
				str2 = "G2";
				heroScreen.getGuldan2().setIcon(new ImageIcon(new ImageIcon("images/GuldanSelected.png").getImage()
						.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
				playAudio("sounds/G2.wav");
				try {
					hero2 = new Warlock();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(0);
				}
			}
			if (x == "Anduin1") {
				if (flag) {
					if (str.charAt(0) == 'A')
						clearA1();
					else if (str.charAt(0) == 'R')
						clearR1();
					else if (str.charAt(0) == 'J')
						clearJ1();
					else if (str.charAt(0) == 'U')
						clearU1();
					else
						clearG1();
				} else {
					flag = true;
				}
				str = "A1";
				heroScreen.getAnduin1().setIcon(new ImageIcon(new ImageIcon("images/AnduinSelected.png").getImage()
						.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
				playAudio("sounds/A1.wav");
				try {
					hero1 = new Priest();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(0);
				}
			}
			if (x == "Anduin2") {
				if (flag2) {
					if (str2.charAt(0) == 'A')
						clearA2();
					else if (str2.charAt(0) == 'R')
						clearR2();
					else if (str2.charAt(0) == 'J')
						clearJ2();
					else if (str2.charAt(0) == 'U')
						clearU2();
					else
						clearG2();
				} else {
					flag2 = true;
				}
				str2 = "A2";
				heroScreen.getAnduin2().setIcon(new ImageIcon(new ImageIcon("images/AnduinSelected.png").getImage()
						.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
				playAudio("sounds/a2.wav");
				try {
					hero2 = new Priest();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(0);
				}
			}
			if (x == "Uther1") {
				if (flag) {
					if (str.charAt(0) == 'A')
						clearA1();
					else if (str.charAt(0) == 'R')
						clearR1();
					else if (str.charAt(0) == 'J')
						clearJ1();
					else if (str.charAt(0) == 'U')
						clearU1();
					else
						clearG1();
				} else {
					flag = true;
				}
				str = "U1";
				heroScreen.getUther1().setIcon(new ImageIcon(new ImageIcon("images/UtherSelected.png").getImage()
						.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
				playAudio("sounds/u1.wav");
				try {
					hero1 = new Paladin();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(0);
				}
			}
			if (x == "Uther2") {
				if (flag2) {
					if (str2.charAt(0) == 'A')
						clearA2();
					else if (str2.charAt(0) == 'R')
						clearR2();
					else if (str2.charAt(0) == 'J')
						clearJ2();
					else if (str2.charAt(0) == 'U')
						clearU2();
					else
						clearG2();
				} else {
					flag2 = true;
				}
				str2 = "U2";
				heroScreen.getUther2().setIcon(new ImageIcon(new ImageIcon("images/UtherSelected.png").getImage()
						.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
				playAudio("sounds/u2.wav");
				try {
					hero2 = new Paladin();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(0);
				}
			}
			if (x == "Jaina1") {
				if (flag) {
					if (str.charAt(0) == 'A')
						clearA1();
					else if (str.charAt(0) == 'R')
						clearR1();
					else if (str.charAt(0) == 'J')
						clearJ1();
					else if (str.charAt(0) == 'U')
						clearU1();
					else
						clearG1();
				} else {
					flag = true;
				}
				str = "J1";
				heroScreen.getJaina1().setIcon(new ImageIcon(new ImageIcon("images/JainaSelected.png").getImage()
						.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
				playAudio("sounds/j1.wav");
				try {
					hero1 = new Mage();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(0);
				}
			}
			if (x == "Jaina2") {
				if (flag2) {
					if (str2.charAt(0) == 'A')
						clearA2();
					else if (str2.charAt(0) == 'R')
						clearR2();
					else if (str2.charAt(0) == 'J')
						clearJ2();
					else if (str2.charAt(0) == 'U')
						clearU2();
					else
						clearG2();
				} else {
					flag2 = true;
				}
				str2 = "J2";
				heroScreen.getJaina2().setIcon(new ImageIcon(new ImageIcon("images/JainaSelected.png").getImage()
						.getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
				playAudio("sounds/j2.wav");
				try {
					hero2 = new Mage();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
					System.exit(0);
				}
			}
		}

	}

	public Platform getPlatform() {
		return platform;
	}

	public HeroScreen getHeroScreen() {
		return heroScreen;
	}

	public GameIntro getIntro() {
		return intro;
	}
	
	public Menu getMenu() {
		return menu;
	}

	public void clearHeroScreen() {
		hero1 = null;
		hero2 = null;
		heroScreen.getJaina1().setIcon(new ImageIcon(
				new ImageIcon("images/Jaina.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		heroScreen.getUther1().setIcon(new ImageIcon(
				new ImageIcon("images/Uther.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		heroScreen.getAnduin1().setIcon(new ImageIcon(
				new ImageIcon("images/Anduin.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		heroScreen.getGuldan1().setIcon(new ImageIcon(
				new ImageIcon("images/Guldan.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		heroScreen.getRexxar1().setIcon(new ImageIcon(
				new ImageIcon("images/Rexxar.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		heroScreen.getJaina2().setIcon(new ImageIcon(
				new ImageIcon("images/Jaina.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		heroScreen.getUther2().setIcon(new ImageIcon(
				new ImageIcon("images/Uther.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		heroScreen.getAnduin2().setIcon(new ImageIcon(
				new ImageIcon("images/Anduin.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		heroScreen.getGuldan2().setIcon(new ImageIcon(
				new ImageIcon("images/Guldan.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		heroScreen.getRexxar2().setIcon(new ImageIcon(
				new ImageIcon("images/Rexxar.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
		heroScreen.revalidate();
		heroScreen.repaint();
	}

	private void clearG2() {
		heroScreen.getGuldan2().setIcon(new ImageIcon(
				new ImageIcon("images/Guldan.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
	}

	private void clearU2() {
		heroScreen.getUther2().setIcon(new ImageIcon(
				new ImageIcon("images/Uther.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
	}

	private void clearJ2() {
		heroScreen.getJaina2().setIcon(new ImageIcon(
				new ImageIcon("images/Jaina.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
	}

	private void clearR2() {
		heroScreen.getRexxar2().setIcon(new ImageIcon(
				new ImageIcon("images/Rexxar.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
	}

	private void clearA2() {
		heroScreen.getAnduin2().setIcon(new ImageIcon(
				new ImageIcon("images/Anduin.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
	}

	private void clearG1() {
		heroScreen.getGuldan1().setIcon(new ImageIcon(
				new ImageIcon("images/Guldan.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
	}

	private void clearU1() {
		heroScreen.getUther1().setIcon(new ImageIcon(
				new ImageIcon("images/Uther.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
	}

	private void clearJ1() {
		heroScreen.getJaina1().setIcon(new ImageIcon(
				new ImageIcon("images/Jaina.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
	}

	private void clearR1() {
		heroScreen.getRexxar1().setIcon(new ImageIcon(
				new ImageIcon("images/Rexxar.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
	}

	private void clearA1() {
		heroScreen.getAnduin1().setIcon(new ImageIcon(
				new ImageIcon("images/Anduin.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
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

	public static void main(String[] args) {
		new GameView();
		/*
		 * GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		 * GraphicsDevice device = env.getScreenDevices()[0]; DisplayMode oldMode =
		 * device.getDisplayMode(); DisplayMode newMode = new DisplayMode(1366, 768,
		 * oldMode.getBitDepth(), oldMode.getRefreshRate());
		 * device.setFullScreenWindow(frame); device.setDisplayMode(newMode);
		 */
	}

}
