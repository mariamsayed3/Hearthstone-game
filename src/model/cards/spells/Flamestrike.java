package model.cards.spells;

import java.util.ArrayList;
import model.cards.Rarity;
import model.cards.minions.Minion;

public class Flamestrike extends Spell implements AOESpell {

	public Flamestrike() {
		super("Flamestrike", 7, Rarity.BASIC);
	}

	@Override
	public void performAction(ArrayList<Minion> oppField, ArrayList<Minion> curField) {
		// Deals 4 damage to all enemy minions. Make sure you will pass by all enemy
		// minions
		// Note: Think about how to handle the case where an enemy minion dies during
		// the process
		int c = 0;
		int i = 0;
		int count = oppField.size();
		while (c < count) {
			if (oppField.get(i).getCurrentHP() <= 4 && !oppField.get(i).isDivine()) {
				c++;
				oppField.get(i).setCurrentHP(oppField.get(i).getCurrentHP() - 4);
				continue;
			}
			if (oppField.get(i).isDivine()) {
				oppField.get(i).setDivine(false);
			} else {
				oppField.get(i).setCurrentHP(oppField.get(i).getCurrentHP() - 4);
			}
			i++;
			c++;
		}
	}
	
	public String getEffect() {
		return "Deals 4 damage to all enemy minions";
	}
}
