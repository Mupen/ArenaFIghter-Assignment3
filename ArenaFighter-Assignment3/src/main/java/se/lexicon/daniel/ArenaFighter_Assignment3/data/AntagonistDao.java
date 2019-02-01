package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Combatant;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

public class AntagonistDao implements AntagonistDaoSignatures {

	// Static final instance of CourseDao need to be accessed by a method getCourseDaoInstance
	private static final AntagonistDaoSignatures antagonistDaoInstance = new AntagonistDao();
	public static AntagonistDaoSignatures getAntagonistDaoInstance() {return antagonistDaoInstance;}

	// List of CrouseModels named storage gain values when the class constructor is activated. 
	// Because CourseDao can only have one instance it will only exist one storage for CourseModels
	private List<Antagonist> antagonistStorage;
	private AntagonistDao() {antagonistStorage = new ArrayList<>();}
	
	@Override	
	public Antagonist AntagonistCreation() {
		// Declare and Construct an instance of the Antagonist called currentAntagonist
		String randomName = RandomGenerator.getRandomName(); // placeholder
		
		Antagonist currentAntagonist = new Antagonist(randomName);
		    
		// Call Antagonist Character Creation Method in Antagonist class
	    currentAntagonist.GetAntagonistCreation(currentAntagonist);
	    
	    antagonistStorage.add(currentAntagonist);
	    return currentAntagonist;
	}
	
	@Override
	public void AntagonistDied() {
		antagonistStorage.clear();
	}
	
	@Override
	public Antagonist GetAntagonist() {
		Antagonist currentAntagonist = antagonistStorage.get(0);
		return currentAntagonist;
	}
	
	@Override
	public int AntagonistMeleeAttack(CombatantSignatures attacker) {
		return attacker.getMeleeAttack();
	}
	
	@Override
	public int AntagonistMeleeDefence(CombatantSignatures defender) {
		return defender.getDodgeAttack();
	}
}
