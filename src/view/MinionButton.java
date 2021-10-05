package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.cards.minions.Minion;

@SuppressWarnings("serial")
public class MinionButton extends CardButton {
	private Minion minion;
	private ModernText ManaCost;
	private ModernText Attack;
	private ModernText CurrentHealth;
	private ModernText2 ManaCost2;
	private ModernText2 Attack2;
	private ModernText2 CurrentHealth2;
	private ModernText5 Attack3;
	private ModernText5 CurrentHealth3;
	// private JLabel divine;
	// private JLabel taunt;
	private JLabel sleep;
	private JLabel attack;

	public MinionButton(Minion minion, MouseListener listener) {
		this.minion = minion;
		setSize(70, 127);
		String path = "images/Minions/" + minion.getName() + ".png";
		Image img = new ImageIcon(path).getImage().getScaledInstance(83, 120, Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(img));

		int Mana = minion.getManaCost();
		int Atk = minion.getAttack();
		int HP = minion.getCurrentHP();
		ManaCost = new ModernText(Integer.toString(Mana));
		add(ManaCost);
		if (Mana < 10) {
			ManaCost.setBounds(7, 8, 20, 20);
		} else {
			ManaCost.setBounds(4, 8, 20, 20);
		}
		ManaCost.ChangeColor(Color.WHITE);

		Attack = new ModernText(Integer.toString(Atk));
		add(Attack);
		if (Atk < 10) {
			Attack.setBounds(8, 99, 20, 20);
		} else {
			Attack.setBounds(6, 99, 20, 20);
		}
		Attack.ChangeColor(Color.WHITE);

		CurrentHealth = new ModernText(Integer.toString(HP));
		add(CurrentHealth);
		if (HP < 10) {
			CurrentHealth.setBounds(67, 100, 20, 20);
		} else {
			CurrentHealth.setBounds(65, 100, 20, 20);
		}
		CurrentHealth.ChangeColor(Color.WHITE);

		setToolTipText(minion.getProperties());

		addMouseListener(listener);
		sleep = new JLabel(new ImageIcon(
				new ImageIcon("images/Minions/sleep.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		attack = new JLabel(new ImageIcon(
				new ImageIcon("images/Minions/attack.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		sleep.setBounds(61, 0, 20, 20);
		add(sleep);
		attack.setBounds(2, 25, 20, 20);
		add(attack);

		setProperties();

	}

	public MinionButton(Minion minion, MouseListener listener, boolean flag) {
		this.minion = minion;
		String str = minion.isDivine() ? "Shield" : "";
		String path = "images/Minions/" + minion.getName() + "Field" + str + ".png";
		Image img = new ImageIcon(path).getImage().getScaledInstance(100, 120, Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(img));

		int Atk = minion.getAttack();
		int HP = minion.getCurrentHP();

		Attack3 = new ModernText5(Integer.toString(Atk));
		add(Attack3);
		if (Atk < 10 && Atk != 1) {
			Attack3.setBounds(21, 75, 20, 20);
		} else if (Atk == 10) {
			Attack3.setBounds(19, 75, 20, 20);
		} else {
			Attack3.setBounds(23, 75, 20, 20);
		}
		Attack3.ChangeColor(Color.WHITE);

		CurrentHealth3 = new ModernText5(Integer.toString(HP));
		add(CurrentHealth3);
		if (HP < 10 && HP != 1) {
			CurrentHealth3.setBounds(67, 75, 20, 20);
		} else if (HP == 10) {
			CurrentHealth3.setBounds(65, 75, 20, 20);
		} else {
			CurrentHealth3.setBounds(69, 75, 20, 20);
		}
		CurrentHealth3.ChangeColor(Color.WHITE);

		addMouseListener(listener);

		sleep = new JLabel(new ImageIcon(
				new ImageIcon("images/Minions/sleep.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
		attack = new JLabel(new ImageIcon(
				new ImageIcon("images/Minions/attack.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

		sleep.setBounds(61, 0, 20, 20);
		add(sleep);
		attack.setBounds(2, 25, 20, 20);
		add(attack);
		sleep.setVisible(minion.isSleeping());
		attack.setVisible(!minion.isAttacked() && !minion.isSleeping());

	}

	public void setProperties() {
		sleep.setVisible(minion.isSleeping());
		attack.setVisible(!minion.isAttacked() && !minion.isSleeping());
	}

	public MinionButton(Minion minion) {
		this.minion = minion;
		setSize(200, 310);
		String path = "images/Minions/" + minion.getName() + ".png";
		Image img = new ImageIcon(path).getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(img));
		int Mana = minion.getManaCost();
		int Atk = minion.getAttack();
		int HP = minion.getCurrentHP();
		ManaCost2 = new ModernText2(Integer.toString(Mana));
		add(ManaCost2);
		if (Mana < 10 && Mana != 1) {
			ManaCost2.setBounds(20, 23, 100, 100);
		} else if (Mana >= 10) {
			ManaCost2.setBounds(14, 23, 100, 100);
		} else {
			ManaCost2.setBounds(23, 23, 100, 100);
		}
		ManaCost2.ChangeColor(Color.WHITE);

		Attack2 = new ModernText2(Integer.toString(Atk));
		add(Attack2);
		if (Atk < 10 && Atk != 1) {
			Attack2.setBounds(21, 255, 100, 100);
		} else if (Atk >= 10) {
			Attack2.setBounds(17, 255, 100, 100);
		} else {
			Attack2.setBounds(24, 255, 100, 100);
		}
		Attack2.ChangeColor(Color.WHITE);

		CurrentHealth2 = new ModernText2(Integer.toString(HP));
		add(CurrentHealth2);
		if (HP < 10 && HP != 0) {
			CurrentHealth2.setBounds(163, 253, 100, 100);
		} else if (HP >= 10) {
			CurrentHealth2.setBounds(158, 253, 100, 100);
		} else {
			CurrentHealth2.setBounds(172, 253, 100, 100);
		}
		CurrentHealth2.ChangeColor(Color.WHITE);

		sleep = new JLabel(new ImageIcon(
				new ImageIcon("images/Minions/sleep.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		attack = new JLabel(new ImageIcon(
				new ImageIcon("images/Minions/attack.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

		sleep.setBounds(132, 0, 40, 40);
		add(sleep);
		attack.setBounds(7, 60, 40, 40);
		add(attack);

		setProperties();

	}

	public Minion getMinion() {
		return minion;
	}

	public ModernText getManaCost() {
		return ManaCost;
	}

	public void setManaCost(ModernText manaCost) {
		ManaCost = manaCost;
	}

	public ModernText getAttack() {
		return Attack;
	}

	public void setAttack(ModernText attack) {
		Attack = attack;
	}

	public ModernText getCurrentHealth() {
		return CurrentHealth;
	}

	public void setCurrentHealth(ModernText currentHealth) {
		CurrentHealth = currentHealth;
	}

	@Override
	public void setFocus() {
		JLabel x = new JLabel();
		x.setIcon(new ImageIcon("images/focus/focus.gif"));
		x.setBounds(33,55,100,100);
		add(x,0);
		JLabel y = new JLabel();
		y.setIcon(new ImageIcon(new ImageIcon("images/focus/focus.png").getImage().getScaledInstance(70, 70,Image.SCALE_SMOOTH)));
		y.setBounds(13,15,70,70);
		add(y,1);
		revalidate();
		repaint();
	}

	@Override
	public void removeFocus() {
		remove(1);
		remove(0);
		revalidate();
		repaint();
	}
}
