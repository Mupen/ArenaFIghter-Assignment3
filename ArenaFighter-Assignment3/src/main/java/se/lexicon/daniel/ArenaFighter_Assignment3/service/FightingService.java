package se.lexicon.daniel.ArenaFighter_Assignment3.service;

import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDao;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.AntagonistDaoSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.ProtagonistDao;
import se.lexicon.daniel.ArenaFighter_Assignment3.data.ProtagonistDaoSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Combatant;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;

public class FightingService implements FightingServiceSignatures{
	// Static final instance of SchoolService need to be accessed by a method getSchoolServiceInstance
	private static final FightingServiceSignatures fightingServiceInstance = new FightingService();
	public static FightingServiceSignatures getFightingServiceInstance() {return fightingServiceInstance;}
	
	// Private object references
	private AntagonistDaoSignatures antagonistDaoSignaturesObject;
	private ProtagonistDaoSignatures protagonistDaoSignaturesObject;
	private Antagonist newAntagonistObject;
	private Protagonist newProtagonistObject;
	
	// give Private object references values;
	FightingService() {
		antagonistDaoSignaturesObject = AntagonistDao.getAntagonistDaoInstance();
		protagonistDaoSignaturesObject = ProtagonistDao.getProtagonistDaoInstance();
	}
	
	void MeleeAttack(CombatantSignatures attacker, CombatantSignatures defender) {
		
		antagonistDaoSignaturesObject.AntagonistMeleeAttack(attacker, defender);
		protagonistDaoSignaturesObject.ProtagonistMeleeAttack(defender, attacker);
	}
	
	void MeleeDefence(Combatant attacker,Combatant defender) {
		antagonistDaoSignaturesObject.AntagonistMeleeAttack(attacker, defender);
		protagonistDaoSignaturesObject.ProtagonistMeleeAttack(defender, attacker);
	}
	

}
