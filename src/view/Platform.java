package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platform extends JPanel {
	private ModernJPanel currentDeck;
	private ModernJPanel currentHand;
	private ModernJPanel currentHero;
	private ModernJPanel currentMana;
	private ModernJPanel currentField;
	private ModernJPanel endTurn;
	private ModernJPanel opponentField;
	private ModernJPanel opponentMana;
	private ModernJPanel opponentHero;
	private ModernJPanel opponentHand;
	private ModernJPanel opponentDeck;
	private ModernJPanel leftPanel;
	private ModernJPanel rightPanel;
	private ModernJPanel menuButton;
	private ModernJPanel spellsPanel;
	private JLabel crystal;
	private ModernJPanel crystals;

	public Platform() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		BackgroundImage background = new BackgroundImage("images/PlatfromBackground.png");
		setLayout(new BorderLayout());
		add(background);

		currentMana = new ModernJPanel();
		background.add(currentMana);
		currentMana.setOpaque(false);
		currentMana.setBounds(852, 688, 70, 40);

		crystals = new ModernJPanel();
		background.add(crystals);
		crystals.setOpaque(false);
		crystals.setBounds(922, 685, 230, 40);
		crystals.setLayout(new BoxLayout(crystals, BoxLayout.X_AXIS));
		crystal = new JLabel();

		/*
		 * crystalsList = new JLabel[10]; for (int i = 0; i < 10; i++) { crystalsList[i]
		 * = new JLabel(new ImageIcon( new
		 * ImageIcon("images/mana.png").getImage().getScaledInstance(23, 22,
		 * Image.SCALE_SMOOTH))); crystals.add(crystalsList[i]);
		 * crystalsList[i].setVisible(false); }
		 */

		currentHand = new ModernJPanel();
		background.add(currentHand);
		currentHand.setBounds(0, 640, 880, 155);
		currentHand.setOpaque(false);

		currentHero = new ModernJPanel();
		background.add(currentHero);
		currentHero.setBounds(607, 506, 150, 170);
		currentHero.setOpaque(false);

		currentField = new ModernJPanel();
		background.add(currentField);
		currentField.setLayout(new BoxLayout(currentField,BoxLayout.X_AXIS));
		currentField.setBounds(310, 360, 720, 150);
		currentField.setOpaque(false);

		endTurn = new ModernJPanel();
		background.add(endTurn);
		endTurn.setBounds(1020, 310, 140, 85);
		endTurn.setOpaque(false);

		opponentField = new ModernJPanel();
		background.add(opponentField);
		opponentField.setLayout(new BoxLayout(opponentField,BoxLayout.X_AXIS));
		opponentField.setBounds(310, 225, 720, 150);
		opponentField.setOpaque(false);

		opponentMana = new ModernJPanel();
		background.add(opponentMana);
		opponentMana.setOpaque(false);
		opponentMana.setBounds(827, 41, 70, 40);

		opponentHero = new ModernJPanel();
		background.add(opponentHero);
		opponentHero.setBounds(607, 73, 150, 170);
		opponentHero.setOpaque(false);

		opponentHand = new ModernJPanel();
		background.add(opponentHand);
		opponentHand.setBounds(0, 5, 650, 100);
		opponentHand.setOpaque(false);

		currentDeck = new ModernJPanel();
		background.add(currentDeck);
		currentDeck.setBounds(1117, 394, 50, 124);
		currentDeck.setOpaque(false);

		opponentDeck = new ModernJPanel();
		background.add(opponentDeck);
		opponentDeck.setBounds(1113, 197, 50, 124);
		opponentDeck.setOpaque(false);

		leftPanel = new ModernJPanel();
		background.add(leftPanel);
		leftPanel.setBounds(5, 200, 200, 310);
		leftPanel.setOpaque(false);

		rightPanel = new ModernJPanel();
		background.add(rightPanel);
		rightPanel.setBounds(1160, 200, 200, 310);
		rightPanel.setOpaque(false);

		menuButton = new ModernJPanel();
		background.add(menuButton);
		menuButton.setBounds(1200, 30, 100, 100);
		menuButton.setOpaque(false);

		spellsPanel = new ModernJPanel();
		background.add(spellsPanel);
		spellsPanel.setBounds(216, 220, 38, 272);
		spellsPanel.setOpaque(false);
		spellsPanel.setLayout(new BoxLayout(spellsPanel, BoxLayout.Y_AXIS));

		Image CursorImage = new ImageIcon("Cursors/PlatformCursor3.png").getImage();
		Point hotSpot = new Point(3, 3);
		Cursor PlatformCursor = Toolkit.getDefaultToolkit().createCustomCursor(CursorImage, hotSpot, "PlatformCursor");
		setCursor(PlatformCursor);
	}

	public JPanel getCurrentHand() {
		return currentHand;
	}

	public JPanel getCurrentHero() {
		return currentHero;
	}

	public JPanel getCurrentMana() {
		return currentMana;
	}

	public JPanel getCurrentField() {
		return currentField;
	}

	public JPanel getEndTurn() {
		return endTurn;
	}

	public JPanel getOpponentField() {
		return opponentField;
	}

	public JPanel getOpponentMana() {
		return opponentMana;
	}

	public JPanel getOpponentHero() {
		return opponentHero;
	}

	public JPanel getOpponentHand() {
		return opponentHand;
	}

	public JPanel getCurrentDeck() {
		return currentDeck;
	}

	public JPanel getOpponentDeck() {
		return opponentDeck;
	}

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public JPanel getMenuButton() {
		return menuButton;
	}

	public JPanel getSpellsPanel() {
		return spellsPanel;
	}

	public void putManaCrystals(int x, int y) {
		crystals.removeAll();
		for (int i = 0; i < x; i++) {
			crystal = new JLabel(new ImageIcon(
					new ImageIcon("images/mana.png").getImage().getScaledInstance(23, 22, Image.SCALE_SMOOTH)));
			crystals.add(crystal);
			crystal.setVisible(true);
		}
		for (int i = 0; i < y - x; i++) {
			crystal = new JLabel(new ImageIcon(
					new ImageIcon("images/darkmana.png").getImage().getScaledInstance(23, 22, Image.SCALE_SMOOTH)));
			crystals.add(crystal);
			crystal.setVisible(true);
		}
		crystals.revalidate();
		crystals.repaint();
	}
}