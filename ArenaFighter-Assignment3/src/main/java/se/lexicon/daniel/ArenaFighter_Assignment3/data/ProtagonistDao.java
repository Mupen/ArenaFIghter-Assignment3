package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.CombatantSignatures;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.KeyboardInput;

public class ProtagonistDao implements ProtagonistDaoSignatures {

	// Static final instance of CourseDao need to be accessed by a method getCourseDaoInstance
	private static final ProtagonistDaoSignatures protagonistDaoInstance = new ProtagonistDao();
	public static ProtagonistDaoSignatures getProtagonistDaoInstance() {return protagonistDaoInstance;}

	// List of CrouseModels named storage gain values when the class constructor is activated. 
	// Because CourseDao can only have one instance it will only exist one storage for CourseModels
	private List<Protagonist> protagonistStorage;
	private ProtagonistDao() {protagonistStorage = new ArrayList<>();}
	
	@Override
	public Protagonist ProtagonistCreation() {
		// Call on misc class to scan keyboard and give the value to the String primitive
		String nameSelection = KeyboardInput.getString("Write the name for your Combatant: ");
			
		// Declare and Construct an instance of the Protagonist called currentProtagonist
		Protagonist currentProtagonist = new Protagonist(nameSelection);
		
		// Declare primitives with values for an instance of current Protagonist method that do character creation
		int amout = 0;
		int times = 5;
			
		// Call Protagonist Character Creation Method in Protagonist class
		currentProtagonist.GetProtagonistCreation(currentProtagonist, amout, times);
		
		protagonistStorage.add(currentProtagonist);
		return currentProtagonist;
	}
	
	@Override
	public void ProtagonistDied() {
		protagonistStorage.clear();
	}
	
	@Override
	public Protagonist GetProtagonist() {
		Protagonist currentProtagonist = protagonistStorage.get(0);
		return currentProtagonist;
	}
	
	
	@Override
	public int ProtagonistMeleeAttack(CombatantSignatures attacker) {
		return attacker.getMeleeAttack();
		
	}
	
	@Override
	public int ProtagonistMeleeDefence(CombatantSignatures defender) {
		return defender.getDodgeAttack();
		
	}



}