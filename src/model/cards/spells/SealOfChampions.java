package model.cards.spells;

import exceptions.InvalidTargetException;
import model.cards.Rarity;
import model.cards.minions.Minion;

public class SealOfChampions extends Spell implements MinionTargetSpell {

	public SealOfChampions() {
		super("Seal of Champions", 3, Rarity.COMMON);

	}

	public void performAction(Minion m) throws InvalidTargetException {
		// Increases the attack of a minion by 3 and gives it divine shield.
		m.setAttack(m.getAttack() + 3);
		m.setDivine(true);
	}

	public String getEffect() {
		return "Increases the attack of a minion by 3 and gives it divine shield";
	}
}
