package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.cards.spells.Spell;

@SuppressWarnings("serial")
public class SpellButton extends CardButton {
	private Spell spell;
	private ModernText ManaCost;
	private ModernText2 ManaCost2;
	private ModernText3 ManaCost3;

	public SpellButton(Spell spell, MouseListener listener) {
		this.spell = spell;
		setSize(70, 120);
		String name = spell.getName();
		if (name.equals("Shadow Word: Death")) {
			name = "Shadow Word Death";
		}
		String path = "images/Spells/" + name + ".png";
		Image img = new ImageIcon(path).getImage().getScaledInstance(83, 120, Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(img));
		int Mana = spell.getManaCost();
		ManaCost = new ModernText(Integer.toString(Mana));
		add(ManaCost);
		if (Mana < 10) {
			ManaCost.setBounds(8, 8, 20, 20);
		} else {
			ManaCost.setBounds(5, 8, 20, 20);
		}
		ManaCost.ChangeColor(Color.WHITE);

		setToolTipText(spell.getEffect());

		addMouseListener(listener);

		if (name.equals("Curse of Weakness") || name.equals("Flamestrike") || name.equals("Holy Nova")
				|| name.equals("Multi-Shot") || name.equals("Twisting Nether")) {
			setActionCommand("AOEspell");
		}

		if (name.equals("Divine Spirit") || name.equals("Polymorph") || name.equals("Seal of Champions")
				|| name.equals("Shadow Word Death")) {
			setActionCommand("MinionTargetSpell");
		}

		if (name.equals("Level Up!")) {
			setActionCommand("FieldSpell");
		}

		if (name.equals("Siphon Soul")) {
			setActionCommand("LeechingSpell");
		}

		if (name.equals("Kill Command") || name.equals("Pyroblast")) {
			setActionCommand("MinionAndHeroTargetSpell");
		}

	}

	public SpellButton(Spell spell) {
		this.spell = spell;
		String name = spell.getName();
		if (name.equals("Shadow Word: Death")) {
			name = "Shadow Word Death";
		}
		String path = "images/Spells/" + name + ".png";
		Image img = new ImageIcon(path).getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(img));
		int Mana = spell.getManaCost();
		ManaCost2 = new ModernText2(Integer.toString(Mana));
		add(ManaCost2);
		if (Mana < 10) {
			ManaCost2.setBounds(20, 24, 100, 100);
		} else {
			ManaCost2.setBounds(15, 24, 100, 100);
		}
		ManaCost2.ChangeColor(Color.WHITE);

	}

	public SpellButton(Spell spell, MouseListener listener, boolean b) {
		this.spell = spell;
		String name = spell.getName();
		if (name.equals("Shadow Word: Death")) {
			name = "Shadow Word Death";
		}
		String path = "images/Spells/" + name + ".png";
		Image img = new ImageIcon(path).getImage().getScaledInstance(40, 60, Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(img));

		int Mana = spell.getManaCost();
		ManaCost3 = new ModernText3(Integer.toString(Mana));
		add(ManaCost3);
		if (Mana < 10) {
			ManaCost3.setBounds(3, 1, 15, 15);
		} else {
			ManaCost3.setBounds(3, 1, 15, 15);
		}
		ManaCost3.ChangeColor(Color.WHITE);

		setToolTipText(spell.getEffect());

		addMouseListener(listener);

		if (name.equals("Curse of Weakness") || name.equals("Flamestrike") || name.equals("Holy Nova")
				|| name.equals("Multi-Shot") || name.equals("Twisting Nether")) {
			setActionCommand("AOEspell");
		}

		if (name.equals("Divine Spirit") || name.equals("Polymorph") || name.equals("Seal of Champions")
				|| name.equals("Shadow Word: Death")) {
			setActionCommand("MinionTargetSpell");
		}

		if (name.equals("Level Up!")) {
			setActionCommand("FieldSpell");
		}

		if (name.equals("Siphon Soul")) {
			setActionCommand("LeechingSpell");
		}

		if (name.equals("Kill Command") || name.equals("Pyroblast")) {
			setActionCommand("MinionAndHeroTargetSpell");
		}
	}

	public Spell getSpell() {
		return spell;
	}

	public ModernText getManaCost() {
		return ManaCost;
	}

	public void setManaCost(ModernText manaCost) {
		ManaCost = manaCost;
	}

	@Override
	public void setFocus() {
		JLabel x = new JLabel();
		x.setIcon(new ImageIcon("images/focus/focus.gif"));
		x.setBounds(23,55,100,100);
		add(x,0);
		JLabel y = new JLabel();
		y.setIcon(new ImageIcon(new ImageIcon("images/focus/focus.png").getImage().getScaledInstance(70, 70,Image.SCALE_SMOOTH)));
		y.setBounds(5,20,70,70);
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
