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
public class HearthStoneButton extends JButton {
	private ImageIcon icon1;
	private ImageIcon icon2;

	public HearthStoneButton(String imagePath, int width, int height, String str, ActionListener actionListener) {
		addActionListener(actionListener);
		setSize(width, height);
		Image img = new ImageIcon(imagePath).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(img);
		setIcon(icon1);
		String imagePath2 = transformPath(imagePath);
		icon2 = new ImageIcon(
				new ImageIcon(imagePath2).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		setBorderPainted(false);
		setOpaque(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setActionCommand(str);
		setListener();
	}

	public String transformPath(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.')
				res = res + "2";
			res = res + s.charAt(i);
		}
		return res;
	}

	public void setListener() {
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
				if (icon2 != null)
					setIcon(icon2);
			}

			public void mouseExited(MouseEvent e) {
				setIcon(icon1);
			}
		});
	}
}
