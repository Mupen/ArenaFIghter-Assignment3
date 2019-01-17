package se.lexicon.daniel.ArenaFighter_Assignment3.service;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.KeyboardInput;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

public class CharacterCreation {

	public CharacterCreation() {
		// Call on misc class to scan keyboard and give the value to the String primitive
		String nameSelection = KeyboardInput.getString("Write the name for your Combatant: ");
			
		// Declare and Construct an instance of the Protagonist called currentProtagonist
		Protagonist currentProtagonist = new Protagonist(nameSelection);
		
		// Declare primitives with values for an instance of current Protagonist method that do character creation
		int amout = 0;
		int times = 5;
			
		// Call Protagonist Character Creation Method in Protagonist class
		currentProtagonist.GetProtagonistCreation(currentProtagonist, amout, times);
			
		// Declare and Construct an instance of the Antagonist called currentAntagonist
		String randomName = RandomGenerator.getRandomName(); // placeholder
		Antagonist currentAntagonist = new Antagonist(randomName);
		    
		// Call Protagonist Character Creation Method in Protagonist class
	    currentAntagonist.GetAntagonistCreation(currentAntagonist);
	}
}
