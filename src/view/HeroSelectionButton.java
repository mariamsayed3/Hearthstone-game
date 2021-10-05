package view;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class HeroSelectionButton extends JButton {
	private ImageIcon icon1;
	private String background;

	public HeroSelectionButton(String imagePath, int width, int height, String str, ActionListener actionListener,
			BackgroundImage x) {
		addActionListener(actionListener);
		setSize(width, height);
		Image img = new ImageIcon(imagePath).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(img);
		setIcon(icon1);
		background = transformPath(imagePath);
		setBorderPainted(false);
		setOpaque(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setActionCommand(str);
		setListener(x);
		
		switch(str.charAt(0)) {
		case 'R' : setToolTipText("Inflict two damage points to the opponent"); break;
		case 'G' : setToolTipText("Draw an extra card and inflict two damage points to the hero"); break;
		case 'A' : setToolTipText("Restore two health points to a specific target (hero/minion)"); break;
		case 'J' : setToolTipText("Inflict one damage point to a specific target (hero/minion)"); break;
		case 'U' : setToolTipText("Adds a Silver Hand Recruit to the field"); break;
		}
	}

	public String transformPath(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.') {
				res = res + "2.jpg";
				return res;
			}
			res = res + s.charAt(i);
		}
		return res;
	}

	public void setListener(BackgroundImage x) {
		addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				setIcon(icon1);
				try {
					AudioInputStream ais = AudioSystem
							.getAudioInputStream(new File("sounds/hover.wav").getAbsoluteFile());
					Clip clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				} catch (Exception exc) {
					System.out.println(exc.getMessage());
					System.exit(0);
				}
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
				if (background != null) {
					x.changeImage(background);
				}
				x.revalidate();
				x.repaint();
			}

			public void mouseExited(MouseEvent e) {
				x.changeImage("images/background2.jpg");
				x.revalidate();
				x.repaint();
			}
		});
	}
}
