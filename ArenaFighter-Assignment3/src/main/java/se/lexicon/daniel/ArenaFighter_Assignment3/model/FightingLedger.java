package se.lexicon.daniel.ArenaFighter_Assignment3.model;

import java.util.UUID;

public class FightingLedger  {
	private String FightingLedgerId;
	private int FightingLedgerRound;
	private String FightingLedgerAttacker;
	private int FightingLedgerAttackValue;
	private String FightingLedgerDodger;
	private int FightingLedgerDodgeValue;
	private int FightingLedgerDamage;
	private int FightingLedgerDamageReductionn;
	private int FightingLedgerHealthLeft;
	
	
	public FightingLedger(int round, String attacker, int attackValue, String dodger, int dodgeValue, int damage, int damageReductionn, int healthLeft) {
		this.FightingLedgerId = UUID.randomUUID().toString();
		this.FightingLedgerRound = round;
		this.FightingLedgerAttacker = attacker;
		this.FightingLedgerAttackValue = attackValue;
		this.FightingLedgerDodger = dodger;
		this.FightingLedgerDodgeValue = dodgeValue;
		this.FightingLedgerDamage = damage;
		this.FightingLedgerDamageReductionn = damageReductionn;
		this.FightingLedgerHealthLeft = healthLeft;
	}


	@Override
	public String toString() {
		return "FightingLedger [FightingLedgerId=" + FightingLedgerId + ", FightingLedgerRound=" + FightingLedgerRound
				+ ", FightingLedgerAttacker=" + FightingLedgerAttacker + ", FightingLedgerAttackValue="
				+ FightingLedgerAttackValue + ", FightingLedgerDodger=" + FightingLedgerDodger
				+ ", FightingLedgerDodgeValue=" + FightingLedgerDodgeValue + ", FightingLedgerDamage="
				+ FightingLedgerDamage + ", FightingLedgerDamageReductionn=" + FightingLedgerDamageReductionn
				+ ", FightingLedgerHealthLeft=" + FightingLedgerHealthLeft + "]";
	}
}
