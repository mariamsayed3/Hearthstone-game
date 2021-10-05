package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.heroes.Hero;

@SuppressWarnings("serial")
public class HeroButton extends CardButton {
	private Hero hero;
	private ModernText CurrentHealth;

	public HeroButton(Hero hero, MouseListener listener, String actionCommand) {
		this.hero = hero;
		setSize(140, 135);
		setIcon(new ImageIcon("images/HeroTemplate/"+hero.getName()+".gif"));
		addMouseListener(listener);
		
		int HP = hero.getCurrentHP();
		CurrentHealth = new ModernText(Integer.toString(HP));
		add(CurrentHealth);
		CurrentHealth.setBounds(100, 111, 20, 20);
		CurrentHealth.ChangeColor(Color.WHITE);
		
		
		
		ImageIcon x = new ImageIcon(new ImageIcon("images/HeroTemplate/hero.png").getImage().getScaledInstance(140, 135, Image.SCALE_SMOOTH));
		JLabel label = new JLabel(x);
		label.setBounds(-10,2,140,135);
		add(label);
		
		setToolTipText(hero.getHeroPower());
		
		setActionCommand(actionCommand);
	}

	public Hero getHero() {
		return hero;
	}

	public ModernText getCurrentHealth() {
		return CurrentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		CurrentHealth.setText(currentHealth+"");;
	}

	public void setFocus() {
		JLabel x = new JLabel();
		x.setIcon(new ImageIcon("images/focus/focus.gif"));
		x.setBounds(20,-15,80,76);
		add(x,0);
		JLabel y = new JLabel();
		y.setIcon(new ImageIcon(new ImageIcon("images/focus/focus2.png").getImage().getScaledInstance(120, 30,Image.SCALE_SMOOTH)));
		y.setBounds(0,65,120,30);
		add(y,1);
		revalidate();
		repaint();
	}

	public void removeFocus() {
		remove(1);
		remove(0);
		revalidate();
		repaint();
	}
}
