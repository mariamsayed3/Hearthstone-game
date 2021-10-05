package model.cards.spells;

import java.util.ArrayList;
import model.cards.Rarity;
import model.cards.minions.Minion;

public class HolyNova extends Spell implements AOESpell {

	public HolyNova() {
		super("Holy Nova", 5, Rarity.BASIC);

	}

	@Override
	public void performAction(ArrayList<Minion> oppField, ArrayList<Minion> curField) {
		// Deals 2 damage to all enemy minions. Restores 2 health to all friendly
		// minions
		int c = 0;
		int i = 0;
		int count = oppField.size();
		while (c < count) {
			if (oppField.get(i).getCurrentHP() <= 2 && !oppField.get(i).isDivine()) {
				oppField.get(i).setCurrentHP(oppField.get(i).getCurrentHP() - 2);
				c++;
				continue;
			}
			if (oppField.get(i).isDivine()) {
				oppField.get(i).setDivine(false);
			} else {
				oppField.get(i).setCurrentHP(oppField.get(i).getCurrentHP() - 2);
			}
			i++;
			c++;
		}
		for (int j = 0; j < curField.size(); j++) {
			curField.get(j).setCurrentHP(curField.get(j).getCurrentHP() + 2);
		}

	}
	
	public String getEffect() {
		return "Deals 2 damage to all enemy minions. Restores 2 health to all friendly minions";
	}

}
