package engine;

import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.Card;
import model.cards.minions.Icehowl;
import model.cards.minions.Minion;
import model.heroes.Hero;
import model.heroes.HeroListener;

public class Game implements ActionValidator, HeroListener {
	private Hero firstHero;
	private Hero secondHero;
	private Hero currentHero;
	private Hero opponent;
	private GameListener listener;

	public Game(Hero p1, Hero p2) throws FullHandException, CloneNotSupportedException {
		firstHero = p1;
		secondHero = p2;
		int coin = (int) (Math.random() * 2);
		currentHero = coin == 0 ? firstHero : secondHero;
		opponent = currentHero == firstHero ? secondHero : firstHero;
		currentHero.setCurrentManaCrystals(1);
		currentHero.setTotalManaCrystals(1);
		opponent.setCurrentManaCrystals(0);
		opponent.setTotalManaCrystals(0);
		firstHero.setListener(this);
		secondHero.setListener(this);
		firstHero.setValidator(this);
		secondHero.setValidator(this);
		for (int i = 0; i < 3; i++) {
			currentHero.drawCard();
		}
		for (int i = 0; i < 4; i++) {
			opponent.drawCard();
		}

	}

	public Hero getCurrentHero() {
		return currentHero;
	}

	public Hero getOpponent() {
		return opponent;
	}

	@Override
	public void validateTurn(Hero user) throws NotYourTurnException {
		if (user != currentHero)
			throw new NotYourTurnException("It is not your turn!!");
	}

	@Override
	public void validateAttack(Minion attacker, Minion target)
			throws CannotAttackException, NotSummonedException, TauntBypassException, InvalidTargetException {
		if (attacker.isSleeping())
			throw new CannotAttackException("The minion is still sleeping!!");
		if (attacker.isAttacked())
			throw new CannotAttackException("The minion has already attacked!!");
		if (!currentHero.getField().contains(attacker))
			throw new NotSummonedException("This minion is not yet summoned!!");
		if (opponent.hasTaunt() && !target.isTaunt())
			throw new TauntBypassException("The target hero has taunt minions, attack them first!!");
		if (currentHero.getField().contains(target))
			throw new InvalidTargetException("Choose a valid target to attack!!");
		if (!opponent.getField().contains(target))
			throw new NotSummonedException("This minion is not yet summoned!!");
		if (attacker.getAttack() == 0)
			throw new CannotAttackException("Minion has zero attack points!!");
	}

	@Override
	public void validateAttack(Minion attacker, Hero target)
			throws CannotAttackException, NotSummonedException, TauntBypassException, InvalidTargetException {
		if (attacker.isSleeping())
			throw new CannotAttackException("The minion is still sleeping!!");
		if (attacker.isAttacked())
			throw new CannotAttackException("The minion has already attacked!!");
		if (!currentHero.getField().contains(attacker))
			throw new NotSummonedException("This minion is not yet summoned!!");
		if (opponent.hasTaunt())
			throw new TauntBypassException("The target hero has taunt minions, attack them first!!");
		if (target != opponent)
			throw new InvalidTargetException("Choose a valid target to attack!!");
		if (attacker instanceof Icehowl && attacker.getName().equals("Icehowl"))
			throw new InvalidTargetException("Icehowl minions cannot attack heros directly!!");
		if (attacker.getAttack() == 0)
			throw new CannotAttackException("Minion has zero attack points!!");
	}

	@Override
	public void validateManaCost(Card card) throws NotEnoughManaException {
		if (card.getManaCost() > currentHero.getCurrentManaCrystals())
			throw new NotEnoughManaException("You don't have enough mana crystals for this card!!");
	}

	@Override
	public void validatePlayingMinion(Minion minion) throws FullFieldException {
		if (currentHero.getField().size() == 7)
			throw new FullFieldException("Your field is full!!");
	}

	@Override
	public void validateUsingHeroPower(Hero hero) throws NotEnoughManaException, HeroPowerAlreadyUsedException {
		if (hero.getCurrentManaCrystals() < 2)
			throw new NotEnoughManaException("You don't have enough mana crystals for this action!!");
		if (hero.isHeroPowerUsed())
			throw new HeroPowerAlreadyUsedException("You already used your hero power!!");
	}

	@Override
	public void onHeroDeath() {
		listener.onGameOver();
	}

	@Override
	public void damageOpponent(int amount) {
		opponent.setCurrentHP(opponent.getCurrentHP() - amount);
	}

	@Override
	public void endTurn() throws FullHandException, CloneNotSupportedException {
		Hero tmp = currentHero;
		currentHero = opponent;
		opponent = tmp;
		currentHero.setCurrentManaCrystals(currentHero.getTotalManaCrystals() + 1);
		currentHero.setTotalManaCrystals(currentHero.getTotalManaCrystals() + 1);
		currentHero.setHeroPowerUsed(false);
		for (int i = 0; i < currentHero.getField().size(); i++) {
			currentHero.getField().get(i).setSleeping(false);
			currentHero.getField().get(i).setAttacked(false);
		}
		currentHero.drawCard();
		listener.onEndTurn();
	}

	public void setListener(GameListener listener) {
		this.listener = listener;
	}
	
	public void onAttackMinion() {
		if(listener != null)
			listener.onAttackMinion();
	}
	
	public void onAttackHero() {
		if(listener != null)
			listener.onAttackHero();
	}

	public void onPlayMinion() {
		if(listener != null)
			listener.onPlayMinion();
	}
	
	public void onUseHeroPower() {
		if(listener != null)
			listener.onUseHeroPower();
	}
	
	public void onCastSpell() {
		if(listener != null)
			listener.onCastSpell();
	}

}
