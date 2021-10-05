package model.cards.spells;

import exceptions.InvalidTargetException;
import model.cards.Rarity;
import model.cards.minions.Minion;

public class Polymorph extends Spell implements MinionTargetSpell {

	public Polymorph() {
		super("Polymorph", 4, Rarity.BASIC);
	}

	@Override
	public void performAction(Minion m) throws InvalidTargetException {
		// Transforms a minion into a minion with the following attributes
		// CurrentHP, maxHp and attack value (all with a value of 1)
		// Name is ”Sheep”
		// A non-taunt, non-divine and non-charge minion
		// Mana cost is 1 mana crystal
		// Note: If Icehowl got polymorphed, the resultant sheep can normally attack
		// heroes
		// m = new Minion("Sheep", 1, m.getRarity(), 1, 1, false, false, false);
		m.setName("Sheep");
		m.setManaCost(1);
		m.setAttack(1);
		m.setMaxHP(1);
		m.setCurrentHP(1);
		m.setDivine(false);
		m.setTaunt(false);
		m.setSleeping(true);
	}
	
	public String getEffect() {
		return "Transforms a minion into a sheep";
	}

}
