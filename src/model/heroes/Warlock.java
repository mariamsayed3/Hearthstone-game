package model.heroes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Icehowl;
import model.cards.minions.Minion;
import model.cards.spells.CurseOfWeakness;
import model.cards.spells.SiphonSoul;
import model.cards.spells.TwistingNether;

public class Warlock extends Hero {

	public Warlock() throws IOException, CloneNotSupportedException {
		super("Gul'dan");
	}

	@Override
	public void buildDeck() throws IOException, CloneNotSupportedException {
		ArrayList<Minion> neutrals = getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"), 13);
		for (int i = 0; i < neutrals.size(); i++) {
			neutrals.get(i).setListener(this);
		}
		getDeck().addAll(neutrals);
		for (int i = 0; i < 2; i++) {
			getDeck().add(new CurseOfWeakness());
			getDeck().add(new SiphonSoul());
			getDeck().add(new TwistingNether());
		}
		Minion wilfred = new Minion("Wilfred Fizzlebang", 6, Rarity.LEGENDARY, 4, 4, false, false, false);
		wilfred.setListener(this);
		getDeck().add(wilfred);
		Collections.shuffle(getDeck());

	}

	public void useHeroPower() throws NotEnoughManaException, HeroPowerAlreadyUsedException, NotYourTurnException,
			FullHandException, FullFieldException, CloneNotSupportedException {
		super.useHeroPower();
		Card c = this.getDeck().isEmpty() ? null : this.getDeck().get(0);
		if (c != null) {
			for (int i = 0; i < this.getField().size(); i++) {
				if (this.getField().get(i).getName().equals("Wilfred Fizzlebang") && (c instanceof Minion||c instanceof Icehowl)) {
					c.setManaCost(0);
					break;
				}
			}
		}
		drawCard();
		setCurrentHP(getCurrentHP() - 2);
		getListener().onUseHeroPower();
	}
	
	public String getHeroPower() {
		return "Draw an extra card and inflict two damage points to the hero";
	}

}
