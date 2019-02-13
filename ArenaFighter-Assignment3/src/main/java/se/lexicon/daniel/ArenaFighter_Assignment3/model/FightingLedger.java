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


	public String stringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n *** FightingLedger *** \n");
		
		sb.append(" FightingLedgerId = ");
		sb.append(FightingLedgerId + "\n");
		
		sb.append(" FightingLedgerRound = ");
		sb.append(FightingLedgerRound + "\n");
		
		sb.append(" FightingLedgerAttacker = ");
		sb.append(FightingLedgerAttacker + "\n");
		
		sb.append(" FightingLedgerAttackValue = ");
		sb.append(FightingLedgerAttackValue + "\n");
		
		sb.append(" FightingLedgerDodger = ");
		sb.append(FightingLedgerDodger + "\n");
		
		sb.append(" FightingLedgerDodgeValue = ");
		sb.append(FightingLedgerDodgeValue + "\n");
		
		sb.append(" FightingLedgerDamage = ");
		sb.append(FightingLedgerDamage + "\n");
		
		sb.append(" FightingLedgerDamageReductionn = ");
		sb.append(FightingLedgerDamageReductionn + "\n");
		
		sb.append(" FightingLedgerHealthLeft = ");
		sb.append(FightingLedgerHealthLeft + "\n");
		
		return sb.toString(); 
	}
}
