package model.heroes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.Flamestrike;
import model.cards.spells.Polymorph;
import model.cards.spells.Pyroblast;

public class Mage extends Hero {

	public Mage() throws IOException, CloneNotSupportedException {
		super("Jaina Proudmoore");
	}

	@Override
	public void buildDeck() throws IOException, CloneNotSupportedException {
		ArrayList<Minion> neutrals = getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"), 13);
		for (int i = 0; i < neutrals.size(); i++) {
			neutrals.get(i).setListener(this);
		}
		getDeck().addAll(neutrals);
		for (int i = 0; i < 2; i++) {
			getDeck().add(new Polymorph());
			getDeck().add(new Flamestrike());
			getDeck().add(new Pyroblast());
		}
		Minion kalycgos = (new Minion("Kalycgos", 10, Rarity.LEGENDARY, 4, 12, false, false, false));
		kalycgos.setListener(this);
		getDeck().add(kalycgos);
		Collections.shuffle(getDeck());

	}

	public void useHeroPower(Hero target) throws NotEnoughManaException, HeroPowerAlreadyUsedException,
			NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException {
		useHeroPower();
		target.setCurrentHP(target.getCurrentHP() - 1);
		getListener().onUseHeroPower();
	}

	public void useHeroPower(Minion target) throws NotEnoughManaException, HeroPowerAlreadyUsedException,
			NotYourTurnException, FullHandException, FullFieldException, CloneNotSupportedException {
		useHeroPower();
		if (target.isDivine())
			target.setDivine(false);

		else {
			target.setCurrentHP(target.getCurrentHP() - 1);
		}
		getListener().onUseHeroPower();
	}
	
	public String getHeroPower() {
		return "Inflict one damage point to a specific target (hero/minion)";
	}

}
