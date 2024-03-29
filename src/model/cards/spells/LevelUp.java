package model.cards.spells;

import java.util.ArrayList;
import model.cards.Rarity;
import model.cards.minions.Minion;

public class LevelUp extends Spell implements FieldSpell {

	public LevelUp() {
		super("Level Up!", 6, Rarity.EPIC);

	}

	@Override
	public void performAction(ArrayList<Minion> field) {
		// Increase the attack, current, and max HP of all silver hand recruits by 1.
		for (int i = 0; i < field.size(); i++) {
			if (field.get(i).getName().equals("Silver Hand Recruit")) {
				field.get(i).setAttack(field.get(i).getAttack() + 1);
				field.get(i).setMaxHP(field.get(i).getMaxHP() + 1);
				field.get(i).setCurrentHP(field.get(i).getCurrentHP() + 1);
			}
		}
	}
	
	public String getEffect() {
		return "Increase the attack, current, and max HP of all silver hand recruits by 1.";
	}

}
