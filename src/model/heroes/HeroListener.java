package model.heroes;

import exceptions.FullHandException;

public interface HeroListener {
	public void onHeroDeath();

	public void damageOpponent(int amount);

	public void endTurn() throws FullHandException, CloneNotSupportedException;
	
	public void onPlayMinion();
	
	public void onUseHeroPower();
	
	public void onAttackMinion();
	
	public void onAttackHero();
	
	public void onCastSpell();
}
