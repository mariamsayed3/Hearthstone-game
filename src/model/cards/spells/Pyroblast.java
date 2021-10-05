package model.cards.spells;

import exceptions.InvalidTargetException;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.heroes.Hero;

public class Pyroblast extends Spell implements HeroTargetSpell, MinionTargetSpell {
	public Pyroblast() {
		super("Pyroblast", 10, Rarity.EPIC);
	}

	public void performAction(Hero h) {
		h.setCurrentHP(h.getCurrentHP() - 10);
	}

	@Override
	public void performAction(Minion m) throws InvalidTargetException {
		if (!m.isDivine()) {
			m.setCurrentHP(m.getCurrentHP() - 10);
		} else {
			m.setDivine(false);
		}
	}
	
	public String getEffect() {
		return "Deals 10 damage to a chosen target (hero/minion).";
	}

}
