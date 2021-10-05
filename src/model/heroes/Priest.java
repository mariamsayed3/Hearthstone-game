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
import model.cards.spells.DivineSpirit;
import model.cards.spells.HolyNova;
import model.cards.spells.ShadowWordDeath;

public class Priest extends Hero {

	public Priest() throws IOException, CloneNotSupportedException {
		super("Anduin Wrynn");
	}

	@Override
	public void buildDeck() throws IOException, CloneNotSupportedException {
		ArrayList<Minion> neutrals= getNeutralMinions(getAllNeutralMinions("neutral_minions.csv"),13);
		for(int i=0;i<neutrals.size();i++)
		{
			neutrals.get(i).setListener(this);
		}
		getDeck().addAll(neutrals);
		for(int i = 0 ; i < 2; i++)
		{
			getDeck().add(new DivineSpirit());
			getDeck().add(new HolyNova());
			getDeck().add(new ShadowWordDeath());
		}
		Minion velen=new Minion("Prophet Velen", 7, Rarity.LEGENDARY, 7, 7, false, false, false);
		velen.setListener(this);
		getDeck().add(velen);
		Collections.shuffle(getDeck());

	}
	public void useHeroPower(Hero target) throws NotEnoughManaException,
	HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	FullFieldException, CloneNotSupportedException{
		useHeroPower(); 
		for (int i = 0 ; i < this.getField().size() ; i++ ) {
			if (this.getField().get(i).getName().equals("Prophet Velen")) {
				target.setCurrentHP(target.getCurrentHP()+8);
				return;
			}
		}
		target.setCurrentHP(target.getCurrentHP()+2);
		getListener().onUseHeroPower();
	}
	public void useHeroPower(Minion target) throws NotEnoughManaException,
	HeroPowerAlreadyUsedException, NotYourTurnException, FullHandException,
	FullFieldException, CloneNotSupportedException{
		useHeroPower();
		for (int i = 0 ; i < this.getField().size() ; i++ ) {
			if (this.getField().get(i).getName().equals("Prophet Velen")) {
				target.setCurrentHP(target.getCurrentHP()+8);
				return;
			}
		}
		target.setCurrentHP(target.getCurrentHP()+2);
		getListener().onUseHeroPower();
	}
	
	public String getHeroPower() {
		return "Restore two health points to a specific target (hero/minion)";
	}

}
