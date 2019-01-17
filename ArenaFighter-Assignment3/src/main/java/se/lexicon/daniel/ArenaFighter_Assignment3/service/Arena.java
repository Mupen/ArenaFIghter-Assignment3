package se.lexicon.daniel.ArenaFighter_Assignment3.service;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.KeyboardInput;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

public class Arena {
	
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
		
		return currentProtagonist;
	}
	
	public Antagonist AntagonistCreation() {
		// Declare and Construct an instance of the Antagonist called currentAntagonist
		String randomName = RandomGenerator.getRandomName(); // placeholder
		Antagonist currentAntagonist = new Antagonist(randomName);
		    
		// Call Protagonist Character Creation Method in Protagonist class
	    currentAntagonist.GetAntagonistCreation(currentAntagonist);
	    
	    return currentAntagonist;
	}
	
	public CharacterAction Initiative(Protagonist currentProtagonist, Antagonist currentAntagonist) {
		
		CharacterAction initiativeWinner = currentProtagonist.RollInitiative(currentProtagonist, currentAntagonist);
		return initiativeWinner;
	}

	public void Fight(Protagonist currentProtagonist, Antagonist currentAntagonist, CharacterAction initiativeWinner) {
		
		// while both is alive it will continue when it will say that the one that is alive.
		// is the victor of the round and post it to the log.
		while(currentProtagonist.isAlive(currentProtagonist) && currentAntagonist.isAlive(currentAntagonist)) {
			if(initiativeWinner.equals(currentProtagonist)) {
				currentProtagonist.MeleeAttack(currentAntagonist);
			}
			else {
				currentAntagonist.MeleeAttack(currentProtagonist);
			}
		}
	}
}
