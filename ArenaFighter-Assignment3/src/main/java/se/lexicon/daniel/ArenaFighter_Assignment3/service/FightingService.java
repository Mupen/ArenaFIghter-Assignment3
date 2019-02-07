package se.lexicon.daniel.ArenaFighter_Assignment3.service;

import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDao;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDaoSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.ProtagonistDao;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.ProtagonistDaoSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Combatant;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

public class FightingService implements FightingServiceSignatures{
	// Static final instance of SchoolService need to be accessed by a method getSchoolServiceInstance
	private static final FightingServiceSignatures fightingServiceInstance = new FightingService();
	public static FightingServiceSignatures getFightingServiceInstance() {return fightingServiceInstance;}
	
	// Private object references
	private AntagonistDaoSignatures antagonistDaoSignaturesObject;
	private ProtagonistDaoSignatures protagonistDaoSignaturesObject;
	private Antagonist currentAntagonist;
	private Protagonist currentProtagonist;
	
	// give Private object references values;
	FightingService() {
		antagonistDaoSignaturesObject = AntagonistDao.getAntagonistDaoInstance();
		protagonistDaoSignaturesObject = ProtagonistDao.getProtagonistDaoInstance();
	}
	
	@Override
	public void CombatantCreation() {
		protagonistDaoSignaturesObject.ProtagonistCreation();
		antagonistDaoSignaturesObject.AntagonistCreation();
	}
	
	@Override
	public CombatantSignatures CombatantInitiative() {
		currentProtagonist = protagonistDaoSignaturesObject.GetProtagonist();
		currentAntagonist = antagonistDaoSignaturesObject.GetAntagonist();
		
		int currentProtagonistInitiative = currentProtagonist.getInitiative() + RandomGenerator.getRandomDecimal();
		int currentAntagonistInitiative = currentAntagonist.getInitiative() + RandomGenerator.getRandomDecimal();
		CombatantSignatures InitiativeWinner = null;
		
		if (currentProtagonistInitiative > currentAntagonistInitiative) {
			MeleeAttack(currentProtagonist, currentAntagonist);
			InitiativeWinner = currentProtagonist;
			currentProtagonist.gainTurns(1);
		}
		else if (currentProtagonistInitiative < currentAntagonistInitiative) {
			MeleeAttack(currentAntagonist, currentProtagonist);
			InitiativeWinner = currentAntagonist;
			currentAntagonist.gainTurns(1);
		}
		else if (currentProtagonistInitiative == currentAntagonistInitiative) {
			fightingServiceInstance.CombatantInitiative();
		}
		return InitiativeWinner;
	}
	
	@Override
	public Protagonist GetProtagonistObject() {
		return protagonistDaoSignaturesObject.GetProtagonist();
	}
	
	@Override
	public Antagonist GetAntagonistObject() {
		return antagonistDaoSignaturesObject.GetAntagonist();
	}
	
	@Override
	public void MeleeAttack(CombatantSignatures attacker, CombatantSignatures defender) {

		int attackValue = 0, defenceValue = 0;
		
		if(attacker.equals(protagonistDaoSignaturesObject.GetProtagonist())) {
			attackValue = protagonistDaoSignaturesObject.ProtagonistMeleeAttack(attacker);
			defenceValue = antagonistDaoSignaturesObject.AntagonistMeleeDefence(defender);
		}
		
		else if(attacker.equals(antagonistDaoSignaturesObject.GetAntagonist())) {
			attackValue = antagonistDaoSignaturesObject.AntagonistMeleeAttack(attacker);
			defenceValue = protagonistDaoSignaturesObject.ProtagonistMeleeDefence(defender);
		}
		
		if (attackValue >= defenceValue) {
			System.out.println("");
			System.out.println("|------" + attacker.getName().replaceAll("[a-zA-Z\\s]", "-") + "-" + defender.getName().replaceAll("[a-zA-Z\\s]", "-") + "-----|");
			System.out.println("| " + attacker.getName() + " Attacks! " + defender.getName() + " |");
			System.out.println("|------" + attacker.getName().replaceAll("[a-zA-Z\\s]", "-") + "-" + defender.getName().replaceAll("[a-zA-Z\\s]", "-") + "-----|");
			System.out.println("");
			
			System.out.println("[" + attacker.getName() + "]: attack with his weapon and ["+ attackValue +"] Successfully bypassed his opponents defense of " + "["+ defenceValue + "]");
			System.out.println("[" + attacker.getName() + "]: deal ["+ attacker.getMeleeDamage() +"] in damage ");
			
			defender.decreaseHealth(attacker.getMeleeDamage());
	    	if (defender.getArmor() > 0) {
	    		System.out.println("[" + defender.getName() + "]: Armor and constitution protecteded him for: [" + defender.getMeleeDamageReduction() + "] and now have only: [" + defender.getHealth() + "] health left");}
	    	else {
	    		System.out.println("[" + defender.getName() + "]: Constitution that protecteded him for: [" + defender.getMeleeDamageReduction() + "] and now have only: [" + defender.getHealth() + "] health left");}
		
			attacker.addHistory("Turn" + attacker.getTurns()
					+ "\n[" + attacker.getName() + "]: Attacks! [" + defender.getName() + "]"
					+ "\n[" + attacker.getName() + "]: attack with his weapon and ["+ attackValue +"] Successfully bypassed his opponents defense of " + "["+ defenceValue + "]"
					+ "\n[" + attacker.getName() + "]: deal [" + attacker.getMeleeDamage() + "] in damage "
					+ "\n[" + defender.getName() + "]: was protected for a total of [" + defender.getMeleeDamageReduction() + "]");
		}
		
		else if (attackValue < defenceValue) {
			System.out.println("[" + defender.getName() + "]: ["+ defenceValue +"] Successfully blocked his opponents attack of " + "["+ attackValue + "]");
			
			attacker.addHistory("Turn" + attacker.getTurns()
			+ "\n[" + attacker.getName() + "]: Attacks! [" + defender.getName() + "]"
			+ "\n[" + defender.getName() + "]: ["+ defenceValue +"] Successfully blocked his opponents attack of " + "["+ attackValue + "]");
		}
	}

	@Override
	public void levelUppifAlive(Protagonist currentProtagonist, Antagonist currentAntagonist) {
		// TODO Auto-generated method stub
		
	}
}
