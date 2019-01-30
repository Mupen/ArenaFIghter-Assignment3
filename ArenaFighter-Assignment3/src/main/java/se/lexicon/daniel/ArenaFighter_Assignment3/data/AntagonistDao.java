package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Combatant;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;

public class AntagonistDao implements AntagonistDaoSignatures {

	// Static final instance of CourseDao need to be accessed by a method getCourseDaoInstance
	private static final AntagonistDaoSignatures antagonistDaoInstance = new AntagonistDao();
	public static AntagonistDaoSignatures getAntagonistDaoInstance() {return antagonistDaoInstance;}
	
	// List of CrouseModels named storage gain values when the class constructor is activated. 
	// Because CourseDao can only have one instance it will only exist one storage for CourseModels
	private List<Antagonist> antagonistStorage;
	private AntagonistDao() {antagonistStorage = new ArrayList<>();}
	
	@Override
	public void AntagonistMeleeAttack(Antagonist attacker) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void AntagonistMeleeDefence(Antagonist defender) {
		// TODO Auto-generated method stub
		
	}
}
