package model.cards.spells;

import exceptions.InvalidTargetException;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.heroes.Hero;

public class KillCommand extends Spell implements MinionTargetSpell, HeroTargetSpell {

	public KillCommand() {
		super("Kill Command", 3, Rarity.COMMON);

	}

	@Override
	public void performAction(Hero h) {
		// Deals 5 damage to a minion or 3 damage to a hero.
		h.setCurrentHP(h.getCurrentHP() - 3);
	}

	@Override
	public void performAction(Minion m) throws InvalidTargetException {
		// Deals 5 damage to a minion or 3 damage to a hero.
		if (m.isDivine()) {
			m.setDivine(false);
		} else {
			m.setCurrentHP(m.getCurrentHP() - 5);
		}
	}
	
	public String getEffect() {
		return "Deals 5 damage to a minion or 3 damage to a hero.";
	}
}
