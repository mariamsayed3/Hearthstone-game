package engine;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import exceptions.*;
import model.cards.Card;
import model.cards.minions.Minion;
import model.heroes.Hero;
import model.heroes.Mage;
import model.heroes.Priest;
import model.cards.spells.*;
import view.CardButton;
import view.DeckPanel;
import view.GameView;
import view.HearthStoneButton;
import view.HeroButton;
import view.MinionButton;
import view.ModernText4;
import view.OpponentHand;
import view.Platform;
import view.SpellButton;

public class Controller implements GameListener, ActionListener, MouseListener {
	private GameView view;
	private Game model;
	private HearthStoneButton endTurn;
	private HearthStoneButton menuButton;
	private HeroButton currentHero;
	private HeroButton opponentHero;
	private ArrayList<CardButton> currentHand;
	private ArrayList<OpponentHand> opponentHand;
	private ArrayList<MinionButton> currentField;
	private ArrayList<MinionButton> opponentField;
	private ArrayList<SpellButton> spellsField;
	private SpellButton temp;
	private Platform platform;
	private DeckPanel currentDeck;
	private DeckPanel opponentDeck;
	private ModernText4 currentMana;
	private ModernText4 opponentMana;
	private CardButton tmp;

	public Controller(GameView v, Hero CH, Hero OH) throws FullHandException, CloneNotSupportedException {
		view = v;
		platform = v.getPlatform();
		model = new Game(CH, OH);
		model.setListener(this);

		endTurn = new HearthStoneButton("images/EndTurn.png", 120, 65, "endTurn", this);
		platform.getEndTurn().add(endTurn);

		menuButton = new HearthStoneButton("images/mainB.png", 70, 70, "MenuButton", this);
		platform.getMenuButton().add(menuButton);

		currentHero = new HeroButton(model.getCurrentHero(), this, "current");
		platform.getCurrentHero().add(currentHero);

		opponentHero = new HeroButton(model.getOpponent(), this, "opponent");
		platform.getOpponentHero().add(opponentHero);

		currentHand = new ArrayList<CardButton>();

		opponentHand = new ArrayList<OpponentHand>();

		currentField = new ArrayList<MinionButton>();
		opponentField = new ArrayList<MinionButton>();

		spellsField = new ArrayList<SpellButton>();

		currentDeck = new DeckPanel(model.getCurrentHero().getDeck().size());
		opponentDeck = new DeckPanel(model.getOpponent().getDeck().size());
		platform.getCurrentDeck().add(currentDeck);
		platform.getOpponentDeck().add(opponentDeck);

		currentMana = new ModernText4(
				model.getCurrentHero().getCurrentManaCrystals() + "/" + model.getCurrentHero().getTotalManaCrystals());
		currentMana.ChangeColor(new Color(255, 255, 255));
		platform.getCurrentMana().add(currentMana);

		opponentMana = new ModernText4(
				model.getOpponent().getCurrentManaCrystals() + "/" + model.getOpponent().getTotalManaCrystals());
		opponentMana.ChangeColor(new Color(255, 255, 255));
		platform.getOpponentMana().add(opponentMana);

		updateAll();

		platform.revalidate();
		platform.repaint();

		setTmp(null);

	}
	
	private void setTmp(CardButton c) {
		if(tmp != null) {
			tmp.removeFocus();
		}
		tmp = c;
		if(tmp !=null) {
			tmp.setFocus();
		}
	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if (b.getActionCommand() == "endTurn") {
			if (platform.getRightPanel().getComponents().length != 0)
				platform.getRightPanel().remove(0);
			new EndTurn();
			try {
				model.endTurn();
				setTmp(null);
			} catch (FullHandException e1) {
				//JOptionPane.showMessageDialog(null, e1.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
				new ErrorMessage(e1,null, model.getCurrentHero());
				Card c = e1.getBurned();
				CardButton m = null;
				if (c instanceof Minion)
					m = new MinionButton((Minion) c);
				else if (c instanceof Spell)
					m = new SpellButton((Spell) c);
				JLabel burned = new JLabel(new ImageIcon(new ImageIcon("images/Minions/fire.png").getImage()
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
				burned.setBounds(140, 60, 70, 70);
				m.add(burned);
				platform.getRightPanel().add(m);
				setTmp(null);
				updateAll();
			} catch (CloneNotSupportedException e1) {
				e1.printStackTrace();
			}
		} else if (b.getActionCommand() == "MenuButton") {
			view.setContentPane(view.getMenu());
		}
	}

	public Game getModel() {
		return model;
	}

	public GameView getView() {
		return view;
	}

	public void onGameOver() {
		new GameOver(model.getCurrentHero(),model.getOpponent());
		new java.util.Timer().schedule(new java.util.TimerTask() {public void run() {view.setContentPane(view.getIntro());;}},4000);
		view.clearHeroScreen();
	}

	public void onEndTurn() {
		playAudio("sounds/newTurn.wav");
		updateAll();
	}

	public void onAttackMinion() {
		playAudio("sounds/attack.wav");
		updateAll();
	}

	public void onAttackHero() {
		playAudio("sounds/attack.wav");
		updateAll();
	}

	public void onPlayMinion() {
		playAudio("sounds/playMinion.wav");
		updateAll();
	}

	public void onCastSpell() {
		playAudio("sounds/castSpell.wav");
		updateAll();
	}

	public void onUseHeroPower() {
		if(model.getCurrentHero().getName().equals("Jaina Proudmoore"))
			playAudio("sounds/heroJaina.wav");
		else
			playAudio("sounds/hero.wav");
		updateAll();
	}

	@SuppressWarnings("finally")
	public void mouseClicked(MouseEvent e) {

		if (platform.getRightPanel().getComponents().length != 0)
			platform.getRightPanel().remove(0);

		CardButton b = (CardButton) e.getSource();
		if (b.equals(tmp) && !(tmp instanceof HeroButton)) {
			setTmp(null);
			return;
		}
		
		if (b instanceof MinionButton) {

			if (currentHand.contains(b)) {
				try {
					model.getCurrentHero().playMinion(((MinionButton) b).getMinion());
				} catch (HearthstoneException e1) {
					new ErrorMessage(e1,b,model.getCurrentHero());
				} finally {
					setTmp(null);
					return;
				}
			}

			if (tmp != null && tmp instanceof SpellButton && ((SpellButton) tmp).getSpell() instanceof MinionTargetSpell
					&& (currentField.contains(b) || opponentField.contains(b))) {
				MinionTargetSpell minionTargetSpell = (MinionTargetSpell) ((SpellButton) tmp).getSpell();
				try {
					model.getCurrentHero().castSpell(minionTargetSpell, ((MinionButton) b).getMinion());
					platform.getSpellsPanel().removeAll();
					spellsField.add(temp);
					for (int i = spellsField.size() - 1; i >= 0; i--) {
						platform.getSpellsPanel().add(spellsField.get(i));
					}
					platform.revalidate();
					platform.repaint();
				} catch (HearthstoneException e1) {
					new ErrorMessage(e1,b,model.getCurrentHero());
				} finally {
					setTmp(null);
					return;
				}
			}

			if (tmp != null && tmp instanceof SpellButton && ((SpellButton) tmp).getSpell() instanceof LeechingSpell
					&& (currentField.contains(b) || opponentField.contains(b))) {
				LeechingSpell leechingSpell = (LeechingSpell) ((SpellButton) tmp).getSpell();
				try {
					model.getCurrentHero().castSpell(leechingSpell, ((MinionButton) b).getMinion());
					platform.getSpellsPanel().removeAll();
					spellsField.add(temp);
					for (int i = spellsField.size() - 1; i >= 0; i--) {
						platform.getSpellsPanel().add(spellsField.get(i));
					}
					platform.revalidate();
					platform.repaint();
				} catch (HearthstoneException e1) {
					new ErrorMessage(e1,b,model.getCurrentHero());
				} finally {
					setTmp(null);
					return;
				}
			}

			if (tmp != null && tmp instanceof HeroButton && ((HeroButton) tmp).getHero() instanceof Mage
					&& (currentField.contains(b) || opponentField.contains(b))) {
				Mage heroMage = (Mage) ((HeroButton) tmp).getHero();
				try {
					heroMage.useHeroPower(((MinionButton) b).getMinion());
				} catch (HearthstoneException e1) {
					new ErrorMessage(e1,b,model.getCurrentHero());
				} finally {
					setTmp(null);
					return;
				}
			}

			if (tmp != null && tmp instanceof HeroButton && ((HeroButton) tmp).getHero() instanceof Priest
					&& (currentField.contains(b) || opponentField.contains(b))) {
				Priest heroPriest = (Priest) ((HeroButton) tmp).getHero();
				try {
					heroPriest.useHeroPower(((MinionButton) b).getMinion());
				} catch (HearthstoneException e1) {
					new ErrorMessage(e1,b,model.getCurrentHero());
				} finally {
					setTmp(null);
					return;
				}
			}

			if (currentField.contains(b)) {
				setTmp(b);
				return;
			}

			if (opponentField.contains(b) && tmp != null && tmp instanceof MinionButton) {
				Minion attacker = ((MinionButton) tmp).getMinion();
				try {
					model.getCurrentHero().attackWithMinion(attacker, ((MinionButton) b).getMinion());
				} catch (HearthstoneException e1) {
					new ErrorMessage(e1,b,model.getCurrentHero());
				} finally {
					setTmp(null);
					return;
				}
			}
		}

		if (b instanceof SpellButton && currentHand.contains(b)) {
			SpellButton g = (SpellButton) b;

			if (b.getActionCommand() == "AOEspell") {
				try {
					model.getCurrentHero().castSpell((AOESpell) g.getSpell(), model.getOpponent().getField());
					temp = new SpellButton(g.getSpell(), this, true);
					platform.getSpellsPanel().removeAll();
					spellsField.add(temp);
					for (int i = spellsField.size() - 1; i >= 0; i--) {
						platform.getSpellsPanel().add(spellsField.get(i));
					}
					platform.revalidate();
					platform.repaint();
				} catch (HearthstoneException e1) {
					new ErrorMessage(e1,b,model.getCurrentHero());
				} finally {
					setTmp(null);
					return;
				}
			}

			if (b.getActionCommand() == "FieldSpell") {
				try {
					model.getCurrentHero().castSpell((FieldSpell) g.getSpell());
					temp = new SpellButton(g.getSpell(), this, true);
					platform.getSpellsPanel().removeAll();
					spellsField.add(temp);
					for (int i = spellsField.size() - 1; i >= 0; i--) {
						platform.getSpellsPanel().add(spellsField.get(i));
					}
					platform.revalidate();
					platform.repaint();
				} catch (HearthstoneException e1) {
					new ErrorMessage(e1,b,model.getCurrentHero());
				} finally {
					setTmp(null);
					return;
				}
			}

			if (b.getActionCommand() == "MinionTargetSpell" || b.getActionCommand() == "LeechingSpell"
					|| g.getActionCommand() == "MinionAndHeroTargetSpell") {
				setTmp(b);
				temp = new SpellButton(g.getSpell(), this, true);
				return;
			}

		}

		if (b instanceof HeroButton) {

			if (tmp != null && tmp instanceof HeroButton && ((HeroButton) tmp).getHero() instanceof Mage) {
				Mage heroMage = (Mage) ((HeroButton) tmp).getHero();
				try {
					heroMage.useHeroPower(((HeroButton) b).getHero());
				} catch (HearthstoneException e1) {
					new ErrorMessage(e1,b,model.getCurrentHero());
				} finally {
					setTmp(null);
					return;
				}
			}

			if (tmp != null && tmp instanceof HeroButton && ((HeroButton) tmp).getHero() instanceof Priest) {
				Priest heroPriest = (Priest) ((HeroButton) tmp).getHero();
				try {
					heroPriest.useHeroPower(((HeroButton) b).getHero());
				} catch (HearthstoneException e1) {
					new ErrorMessage(e1,b,model.getCurrentHero());
				} finally {
					setTmp(null);
					return;
				}
			}

			if (tmp != null && tmp instanceof SpellButton
					&& ((SpellButton) tmp).getSpell() instanceof HeroTargetSpell) {
				HeroTargetSpell heroTargetSpell = (HeroTargetSpell) ((SpellButton) tmp).getSpell();
				try {
					model.getCurrentHero().castSpell(heroTargetSpell, ((HeroButton) b).getHero());
				} catch (HearthstoneException e1) {
					new ErrorMessage(e1,b,model.getCurrentHero());
				} finally {
					setTmp(null);
					return;
				}
			}

			if (b.getActionCommand() == "opponent" && tmp != null && tmp instanceof MinionButton) {
				Minion attacker = ((MinionButton) tmp).getMinion();
				try {
					model.getCurrentHero().attackWithMinion(attacker, model.getOpponent());
				} catch (HearthstoneException e1) {
					new ErrorMessage(e1,b,model.getCurrentHero());
				} finally {
					setTmp(null);
					return;
				}
			}

			if (b.getActionCommand() == "current") {
				if (model.getCurrentHero().getName().equals("Rexxar")
						|| model.getCurrentHero().getName().equals("Uther Lightbringer")
						|| model.getCurrentHero().getName().equals("Gul'dan")) {
					try {
						model.getCurrentHero().useHeroPower();
					} catch (FullHandException e1) {
						//JOptionPane.showMessageDialog(null, e1.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
						new ErrorMessage(e1,b,model.getCurrentHero());
						Card c = e1.getBurned();
						CardButton m = null;
						if (c instanceof Minion)
							m = new MinionButton((Minion) c);
						else if (c instanceof Spell)
							m = new SpellButton((Spell) c);
						if (platform.getRightPanel().getComponents().length != 0)
							platform.getRightPanel().remove(0);
						JLabel burned = new JLabel(new ImageIcon(new ImageIcon("images/Minions/fire.png").getImage()
								.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
						burned.setBounds(140, 60, 70, 70);
						m.add(burned);
						platform.getRightPanel().add(m);
						updateAll();
					} catch (HearthstoneException e1) {
						new ErrorMessage(e1,b,model.getCurrentHero());
					} finally {
						setTmp(null);
						return;
					}
				}

				if (model.getCurrentHero().getName().equals("Jaina Proudmoore")||model.getCurrentHero().getName().equals("Anduin Wrynn")) {
					setTmp(b);
					return;
				}

			}

		}

	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		if (platform.getLeftPanel().getComponents().length != 0) {
			platform.getLeftPanel().remove(0);
			platform.revalidate();
			platform.repaint();
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() instanceof MinionButton) {
			Minion m = ((MinionButton) e.getSource()).getMinion();
			MinionButton Mb = new MinionButton(m);
			platform.getLeftPanel().add(Mb);
			platform.revalidate();
			platform.repaint();
		} else if (e.getSource() instanceof SpellButton) {
			Spell s = ((SpellButton) e.getSource()).getSpell();
			SpellButton Sb = new SpellButton(s);
			platform.getLeftPanel().add(Sb);
			platform.revalidate();
			platform.repaint();
		}
	}

	public void mouseExited(MouseEvent e) {
		if (platform.getLeftPanel().getComponents().length != 0) {
			platform.getLeftPanel().remove(0);
			platform.revalidate();
			platform.repaint();
		}
	}

	public void updateCurrentHand() {
		ArrayList<Card> hand = model.getCurrentHero().getHand();
		currentHand.clear();
		platform.getCurrentHand().removeAll();
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i) instanceof Minion)
				currentHand.add(new MinionButton((Minion) hand.get(i), this));
			else if (hand.get(i) instanceof Spell)
				currentHand.add(new SpellButton((Spell) hand.get(i), this));
			platform.getCurrentHand().add(currentHand.get(i));
		}
		platform.revalidate();
		platform.repaint();
	}

	public void updateOpponentHand() {
		ArrayList<Card> hand = model.getOpponent().getHand();
		opponentHand.clear();
		platform.getOpponentHand().removeAll();
		for (int i = 0; i < hand.size(); i++) {
			opponentHand.add(new OpponentHand());
			platform.getOpponentHand().add(opponentHand.get(i));
		}
		platform.revalidate();
		platform.repaint();
	}

	public void updateCurrentField() {
		ArrayList<Minion> field = model.getCurrentHero().getField();
		currentField.clear();
		platform.getCurrentField().removeAll();
		for (int i = 0; i < field.size(); i++) {
			currentField.add(new MinionButton(field.get(i), this,true));
			platform.getCurrentField().add(currentField.get(i));
		}
		platform.revalidate();
		platform.repaint();
	}

	public void updateOpponentField() {
		ArrayList<Minion> field = model.getOpponent().getField();
		opponentField.clear();
		platform.getOpponentField().removeAll();
		for (int i = 0; i < field.size(); i++) {
			opponentField.add(new MinionButton(field.get(i), this,true));
			platform.getOpponentField().add(opponentField.get(i));
		}
		platform.revalidate();
		platform.repaint();
	}

	public void updateCurrentMana() {
		int x = model.getCurrentHero().getCurrentManaCrystals();
		int y = model.getCurrentHero().getTotalManaCrystals();
		currentMana.setText(x + "/" + y);
		platform.putManaCrystals(x, y);
		platform.revalidate();
		platform.repaint();
	}

	public void updateOpponentMana() {
		opponentMana.setText(
				model.getOpponent().getCurrentManaCrystals() + "/" + model.getOpponent().getTotalManaCrystals());
		platform.revalidate();
		platform.repaint();
	}

	public void updateCurrentDeck() {
		currentDeck.setToolTipText("Cards Remaining: " + model.getCurrentHero().getDeck().size());
		currentDeck.update(model.getCurrentHero().getDeck().size());
	}

	public void updateOpponentDeck() {
		opponentDeck.setToolTipText("Cards Remaining: " + model.getOpponent().getDeck().size());
		opponentDeck.update(model.getOpponent().getDeck().size());
	}

	public void updateCurrentHero() {
		currentHero = new HeroButton(model.getCurrentHero(), this, "current");
		platform.getCurrentHero().remove(0);
		platform.getCurrentHero().add(currentHero);
		platform.revalidate();
		platform.repaint();
	}

	public void updateOpponentHero() {
		opponentHero = new HeroButton(model.getOpponent(), this, "opponent");
		platform.getOpponentHero().remove(0);
		platform.getOpponentHero().add(opponentHero);
		platform.revalidate();
		platform.repaint();
	}

	public void updateAll() {
		updateCurrentHand();
		updateCurrentField();
		updateCurrentHero();
		updateCurrentMana();
		updateCurrentDeck();
		updateOpponentHand();
		updateOpponentField();
		updateOpponentHero();
		updateOpponentMana();
		updateOpponentDeck();
		System.gc();
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
