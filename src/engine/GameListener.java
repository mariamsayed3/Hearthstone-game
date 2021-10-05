package engine;

public interface GameListener {
	public void onGameOver();
	public void onEndTurn();
	public void onAttackMinion();
	public void onAttackHero();
	public void onPlayMinion();
	public void onCastSpell();
	public void onUseHeroPower();
}
