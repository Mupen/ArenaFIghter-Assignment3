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
		
		if (currentProtagonistInitiative > currentAntagonistInitiative) {
			MeleeAttack(currentProtagonist, currentAntagonist);
			currentProtagonist.gainTurns(1);
		}
		else if (currentProtagonistInitiative < currentAntagonistInitiative) {
			MeleeAttack(currentAntagonist, currentProtagonist);
			currentAntagonist.gainTurns(1);
		}
		else if (currentProtagonistInitiative == currentAntagonistInitiative) {
			fightingServiceInstance.CombatantInitiative();
		}
		return null;
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
			System.out.println(attacker.getName() + "["+ attackValue +"] Successfully bypassed his opponents defense of" + "["+ defenceValue + "]");
		}
		else if (attackValue < defenceValue) {
			System.out.println(defender.getName() + "["+ defenceValue +"] Successfully blocked his opponents attack of" + "["+ attackValue + "]");
		}
	}
}
