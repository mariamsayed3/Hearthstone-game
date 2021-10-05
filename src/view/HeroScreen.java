package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HeroScreen extends  JPanel {
	private HeroSelectionButton Anduin1;
	private HeroSelectionButton Anduin2;
	private HeroSelectionButton Rexxar1;
	private HeroSelectionButton Rexxar2;
	private HeroSelectionButton Jaina1;
	private HeroSelectionButton Jaina2;
	private HeroSelectionButton Uther1;
	private HeroSelectionButton Uther2;
	private HeroSelectionButton Guldan1;
	private HeroSelectionButton Guldan2;

	public HeroScreen(ActionListener buttonsListener) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		BackgroundImage background = new BackgroundImage("images/background2.jpg");
		setLayout(new BorderLayout());
		add(background);
		background.setLayout(new BorderLayout());
		JPanel firstHero = new JPanel();
		firstHero.setOpaque(false);
		firstHero.setLayout(new BoxLayout(firstHero, BoxLayout.Y_AXIS));
		JPanel secondHero = new JPanel();
		secondHero.setOpaque(false);
		secondHero.setLayout(new BoxLayout(secondHero, BoxLayout.Y_AXIS));
		JPanel buttons = new JPanel();
		buttons.setOpaque(false);
		background.add(firstHero, BorderLayout.WEST);
		background.add(secondHero, BorderLayout.EAST);
		background.add(buttons, BorderLayout.SOUTH);
		Rexxar1 = new HeroSelectionButton("images/Rexxar.png", 120, 120, "Rexxar1", buttonsListener, background);
		Rexxar2 = new HeroSelectionButton("images/Rexxar.png", 120, 120, "Rexxar2", buttonsListener, background);
		Guldan1 = new HeroSelectionButton("images/Guldan.png", 120, 120, "Guldan1", buttonsListener, background);
		Guldan2 = new HeroSelectionButton("images/Guldan.png", 120, 120, "Guldan2", buttonsListener, background);
		Anduin1 = new HeroSelectionButton("images/Anduin.png", 120, 120, "Anduin1", buttonsListener, background);
		Anduin2 = new HeroSelectionButton("images/Anduin.png", 120, 120, "Anduin2", buttonsListener, background);
		Uther1 = new HeroSelectionButton("images/Uther.png", 120, 120, "Uther1", buttonsListener, background);
		Uther2 = new HeroSelectionButton("images/Uther.png", 120, 120, "Uther2", buttonsListener, background);
		Jaina1 = new HeroSelectionButton("images/Jaina.png", 120, 120, "Jaina1", buttonsListener, background);
		Jaina2 = new HeroSelectionButton("images/Jaina.png", 120, 120, "Jaina2", buttonsListener, background);
		/*
		 * firstHeroSelected = new JLabel(); firstHeroSelected.setOpaque(false);
		 * secondHeroSelected = new JLabel(); secondHeroSelected.setOpaque(false);
		 * firstHeroSelected.setIcon(new ImageIcon(new
		 * ImageIcon("images/firstHeroSelected.png").getImage() .getScaledInstance(200,
		 * 200, Image.SCALE_SMOOTH))); secondHeroSelected.setIcon(new ImageIcon(new
		 * ImageIcon("images/secondHeroSelected.png").getImage() .getScaledInstance(200,
		 * 200, Image.SCALE_SMOOTH)));
		 */
		firstHero.add(Anduin1);
		firstHero.add(Rexxar1);
		firstHero.add(Jaina1);
		firstHero.add(Uther1);
		firstHero.add(Guldan1);
		secondHero.add(Anduin2);
		secondHero.add(Rexxar2);
		secondHero.add(Jaina2);
		secondHero.add(Uther2);
		secondHero.add(Guldan2);
		HearthStoneButton back = new HearthStoneButton("images/back.png", 100, 100, "back", buttonsListener);
		HearthStoneButton next = new HearthStoneButton("images/next.png", 100, 100, "next", buttonsListener);
		buttons.add(back);
		buttons.add(next);

		Image CursorImage = new ImageIcon("Cursors/HeroCursor.png").getImage();
		Point hotSpot = new Point(7, 7);
		Cursor HeroCursor = Toolkit.getDefaultToolkit().createCustomCursor(CursorImage, hotSpot, "HeroCursor");
		this.setCursor(HeroCursor);
	}

	public HeroSelectionButton getAnduin1() {
		return Anduin1;
	}

	public void setAnduin1(HeroSelectionButton anduin1) {
		Anduin1 = anduin1;
	}

	public HeroSelectionButton getAnduin2() {
		return Anduin2;
	}

	public void setAnduin2(HeroSelectionButton anduin2) {
		Anduin2 = anduin2;
	}

	public HeroSelectionButton getRexxar1() {
		return Rexxar1;
	}

	public void setRexxar1(HeroSelectionButton rexxar1) {
		Rexxar1 = rexxar1;
	}

	public HeroSelectionButton getRexxar2() {
		return Rexxar2;
	}

	public void setRexxar2(HeroSelectionButton rexxar2) {
		Rexxar2 = rexxar2;
	}

	public HeroSelectionButton getJaina1() {
		return Jaina1;
	}

	public void setJaina1(HeroSelectionButton jaina1) {
		Jaina1 = jaina1;
	}

	public HeroSelectionButton getJaina2() {
		return Jaina2;
	}

	public void setJaina2(HeroSelectionButton jaina2) {
		Jaina2 = jaina2;
	}

	public HeroSelectionButton getUther1() {
		return Uther1;
	}

	public void setUther1(HeroSelectionButton uther1) {
		Uther1 = uther1;
	}

	public HeroSelectionButton getUther2() {
		return Uther2;
	}

	public void setUther2(HeroSelectionButton uther2) {
		Uther2 = uther2;
	}

	public HeroSelectionButton getGuldan1() {
		return Guldan1;
	}

	public void setGuldan1(HeroSelectionButton guldan1) {
		Guldan1 = guldan1;
	}

	public HeroSelectionButton getGuldan2() {
		return Guldan2;
	}

	public void setGuldan2(HeroSelectionButton guldan2) {
		Guldan2 = guldan2;
	}
}
