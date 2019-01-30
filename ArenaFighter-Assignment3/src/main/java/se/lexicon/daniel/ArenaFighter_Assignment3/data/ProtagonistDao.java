package se.lexicon.daniel.ArenaFighter_Assignment3.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Combatant;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;

	public class ProtagonistDao implements ProtagonistDaoSignatures {

		// Static final instance of CourseDao need to be accessed by a method getCourseDaoInstance
		private static final ProtagonistDaoSignatures protagonistDaoInstance = new ProtagonistDao();
		public static ProtagonistDaoSignatures getProtagonistDaoInstance() {return protagonistDaoInstance;}
		
		// List of CrouseModels named storage gain values when the class constructor is activated. 
		// Because CourseDao can only have one instance it will only exist one storage for CourseModels
		private List<Protagonist> protagonistStorage;
		private ProtagonistDao() {protagonistStorage = new ArrayList<>();}
		
		@Override
		public void ProtagonistMeleeAttack(Combatant defender, Combatant attacker) {
			// TODO Auto-generated method stub
			
		}
		
	}