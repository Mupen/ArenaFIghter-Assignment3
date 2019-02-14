package se.lexicon.daniel.ArenaFighter_Assignment3.service;

import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDao;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDaoSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.ProtagonistDao;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.ProtagonistDaoSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
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
	public void CombatantDied(CombatantSignatures currentProtagonist,CombatantSignatures currentAntagonist) {
		if(currentProtagonist == null) {protagonistDaoSignaturesObject.ProtagonistDied();}
		if(currentAntagonist == null) {antagonistDaoSignaturesObject.AntagonistDied();}
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
	public CombatantSignatures CombatantInitiative() {
		currentProtagonist = protagonistDaoSignaturesObject.GetProtagonist();
		currentAntagonist = antagonistDaoSignaturesObject.GetAntagonist();
		
		int currentProtagonistInitiative = protagonistDaoSignaturesObject.ProtagonistInitiative(currentProtagonist);
		int currentAntagonistInitiative = antagonistDaoSignaturesObject.AntagonistInitiative(currentAntagonist);
		
		CombatantSignatures InitiativeWinner = null;
		
		if (currentProtagonistInitiative > currentAntagonistInitiative) {
			MeleeAttack(currentProtagonist, currentAntagonist, 1);
			InitiativeWinner = currentProtagonist;
			currentProtagonist.gainTurn(1);
		}
		
		else if (currentProtagonistInitiative < currentAntagonistInitiative) {
			MeleeAttack(currentAntagonist, currentProtagonist, 1);
			InitiativeWinner = currentAntagonist;
			currentAntagonist.gainTurn(1);
		}
		
		else if (currentProtagonistInitiative == currentAntagonistInitiative) {
			fightingServiceInstance.CombatantInitiative();
		}
		
		return InitiativeWinner;
	}
	
	@Override
	public void MeleeAttack(CombatantSignatures attacker, CombatantSignatures defender, int round) {
		int attackValue = 0, defenceValue = 0;
		
		if(attacker.equals(protagonistDaoSignaturesObject.GetProtagonist())) {
			attackValue = protagonistDaoSignaturesObject.ProtagonistMeleeAttack(attacker);
			defenceValue = antagonistDaoSignaturesObject.AntagonistMeleeDefence(defender);
		}
		
		else if(attacker.equals(antagonistDaoSignaturesObject.GetAntagonist())) {
			attackValue = antagonistDaoSignaturesObject.AntagonistMeleeAttack(attacker);
			defenceValue = protagonistDaoSignaturesObject.ProtagonistMeleeDefence(defender);
		}
		
		
		System.out.println("");
		System.out.println("|------" + attacker.getName().replaceAll("[a-zA-Z\\s]", "-") + "-" + defender.getName().replaceAll("[a-zA-Z\\s]", "-") + "-----|");
		System.out.println("| " + attacker.getName() + " Attacks! " + defender.getName() + " |");
		System.out.println("|------" + attacker.getName().replaceAll("[a-zA-Z\\s]", "-") + "-" + defender.getName().replaceAll("[a-zA-Z\\s]", "-") + "-----|");
		System.out.println("");
		
		if(attackValue >= defenceValue) {
			System.out.println("[" + attacker.getName() + "]: attack with his weapon and ["+ attackValue +"] Successfully bypassed his opponents defense of " + "["+ defenceValue + "]");
			System.out.println("[" + attacker.getName() + "]: deal ["+ attacker.getMeleeDamage() +"] in damage");
			
			defender.decreaseHealth(attacker.getMeleeDamage(), defender.getMeleeDamageReduction());
			
	    	if(defender.getMeleeDamageReduction() > 0) {
	    		System.out.println("[" + defender.getName() + "]: Armor and constitution protecteded him for: [" + defender.getMeleeDamageReduction() + "] and now have only: [" + defender.getHealth() + "] health left\n");
	    		}
	    	else {
	    		System.out.println("[" + defender.getName() + "]: Constitution that protecteded him for: [" + (defender.getConstitution()/2) + "] and now have only: [" + defender.getHealth() + "] health left\n");
	    		}
		}
		
		else {
			System.out.println("[" + attacker.getName() + "]: attack with his weapon and ["+ attackValue +"] failed in bypassing his opponents defense of " + "["+ defenceValue + "]\n");
		}
		
		currentAntagonist.setFightingLedger(round, currentAntagonist.getName(), attackValue, currentProtagonist.getName(), defenceValue, currentAntagonist.getMeleeDamage(), currentProtagonist.getMeleeDamageReduction(), currentAntagonist.getHealth());
		currentProtagonist.setFightingLedger(round, currentProtagonist.getName(), attackValue, currentAntagonist.getName(), defenceValue, currentProtagonist.getMeleeDamage(), currentAntagonist.getMeleeDamageReduction(), currentProtagonist.getHealth());
		
		currentAntagonist.addToFightingLedgerStorage(currentAntagonist.getFightingLedger());
		currentProtagonist.addToFightingLedgerStorage(currentProtagonist.getFightingLedger());
	}
	
	@Override
	public CombatantSignatures WinnerIs(CombatantSignatures currentProtagonist, CombatantSignatures currentAntagonist) {
		if(currentProtagonist.getHealth() > currentAntagonist.getHealth()) {return currentProtagonist;}
		else return currentAntagonist;
	}
	
	
	@Override
	public void levelUp(CombatantSignatures winner) {
		System.out.println("");
		winner.gainLevel(1);
		System.out.println("");
		winner.restoreHealth();
		System.out.println("");
		int levelUpSelection = RandomGenerator.getRandomDecimal(1, 6);
        switch (levelUpSelection) {
	        case 1: winner.gainStrenght(2); 
	        System.out.println("[" + winner.getName() + "] gaind 2 Strenght"); break;
	        case 2: winner.gainAgility(2);
	        System.out.println("[" + winner.getName() + "] gaind 2 Agility"); break;
	        case 3: winner.gainConstitution(2);
	        System.out.println("[" + winner.getName() + "] gaind 2 Constitution"); break;
	        case 4: winner.gainPerception(2);
	        System.out.println("[" + winner.getName() + "] gaind 2 Perception"); break;
	        case 5: winner.gainCharisma(2);
	        System.out.println("[" + winner.getName() + "] gaind 2 Charisma"); break;
	        case 6: winner.gainWill(2); 
	        System.out.println("[" + winner.getName() + "] gaind 2 Will"); break;
	        default: System.out.println("Something went wrong this should not be possible"); break;
        }
	}
}
