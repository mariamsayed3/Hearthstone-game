package model.cards.spells;

import java.util.*;
import model.cards.Rarity;
import model.cards.minions.Minion;

public class MultiShot extends Spell implements AOESpell {

	public MultiShot() {
		super("Multi-Shot", 4, Rarity.BASIC);

	}

	@Override
	public void performAction(ArrayList<Minion> oppField, ArrayList<Minion> curField) {
		// Deals 3 damage to two random enemy minions. If the opponent has only one
		// minion
		// it deals 3 damage once to this minion. If the opponent field is empty then
		// nothing happens
		if (oppField.size() != 0) {
			if (oppField.size() == 1) {
				if (!oppField.get(0).isDivine()) {
					oppField.get(0).setCurrentHP(oppField.get(0).getCurrentHP() - 3);
				} else {
					oppField.get(0).setDivine(false);
				}
			} else {
					Random r = new Random();
					int x1 = r.nextInt(oppField.size());
					int x2 = r.nextInt(oppField.size());
					while(x1==x2) {
						x2 = r.nextInt(oppField.size());
					}
					boolean died = false;
					if (!oppField.get(x1).isDivine()) {
						died = oppField.get(x1).getCurrentHP() > 3;
						oppField.get(x1).setCurrentHP(oppField.get(x1).getCurrentHP() - 3);
					} else {
						oppField.get(x1).setDivine(false);
					}
					if(died&&x2!=0)
						x2--;
					if (!oppField.get(x2).isDivine()) {
						oppField.get(x2).setCurrentHP(oppField.get(x2).getCurrentHP() - 3);
					} else {
						oppField.get(x2).setDivine(false);
					}
			}
		}

	}
	
	public String getEffect() {
		return "Deals 3 damage to two random enemy minions";
	}

}
