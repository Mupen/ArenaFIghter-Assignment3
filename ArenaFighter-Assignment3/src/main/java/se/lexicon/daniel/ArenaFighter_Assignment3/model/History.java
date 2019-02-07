package se.lexicon.daniel.ArenaFighter_Assignment3.model;

import java.util.UUID;

public class History {
	private int round = 0;
	private int attack;
	private int damage;
	private int dodge;
	private int damageReductionn;
	private int healthLeft;
	
	public History(int attack, int damage, int dodge, int damageReductionn, int healthLeft) {
		this.attack = attack;
		this.damage = damage;
		this.dodge = dodge;
		this.damageReductionn = damageReductionn;
		this.healthLeft = healthLeft;
	}

	@Override
	public String toString() {
		return "History [round=" + round + ", attack=" + attack + ", damage=" + damage + ", dodge=" + dodge
				+ ", damageReductionn=" + damageReductionn + ", healthLeft=" + healthLeft + "]";
	}
}
