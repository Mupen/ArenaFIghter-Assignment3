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
	
	public Characters Initiative(Protagonist currentProtagonist, Antagonist currentAntagonist) {
		
		Characters initiativeWinner = currentProtagonist.RollInitiative(currentProtagonist, currentAntagonist);
		return initiativeWinner;
	}

	public void Fight(Protagonist currentProtagonist, Antagonist currentAntagonist, Characters initiativeWinner) {
		if(initiativeWinner.equals(currentProtagonist)) {
    		String selection = KeyboardInput.getString(
    				"\n |------------" + currentProtagonist.getName() + " Character Action ------------| \n" +
    				" What action do you want to take? \n" +
    				"\n" +
    				" [a] Attack \n" +
    				" [s] Dodge \n" +
    				" [d] Beg \n" +
    				" [f] Brag \n" +
    				" [g] investigate \n" +
    				" [h] Hold turn \n" +
    				"\n" +
    				" Your selection... "
    				);
    		
    		switch (selection.toLowerCase()) {
				case "a":
					currentProtagonist.MeleeAttack(currentAntagonist);
					break;
				case "s":
					System.out.println("Its is meaningless to dodge when it's your turn...");
					break;
				case "d":
					System.out.println("Its is meaningless to beg when you dont even know how to...");
					break;
				case "f":
					System.out.println("Its is meaningless to brag when you dont even know how to...");
					break;
				case "g":
					System.out.println("Its is meaningless as you can only attack but if you realy want it...");
					currentAntagonist.getAttributes();
					break;
				case "h":
					System.out.println("this is not complicated the only thing working in this game is attacking action do that next turn...");
					break;
				default:
					break;
    		}
		}
		
		if(initiativeWinner.equals(currentAntagonist)) {
    		int selection = RandomGenerator.getRandomDecimal();
    		
    		switch (selection) {
				case 1:
				case 2:
				case 3:
				case 4:
					currentProtagonist.MeleeAttack(currentAntagonist);
					break;
				case 6:
					System.out.println("Its is meaningless to dodge when it's your turn...");
					break;
				case 7:
					System.out.println("Its is meaningless to beg when you dont even know how to...");
					break;
				case 8:
					System.out.println("Its is meaningless to brag when you dont even know how to...");
					break;
				case 9:
					System.out.println("Its is meaningless as you can only attack but if you realy want it...");
					currentAntagonist.getAttributes();
					break;
				case 10:
					System.out.println("this is not complicated the only thing working in this game is attacking action do that next turn...");
					break;
				default:
					break;
    		}
		}
		
/*		// while both is alive it will continue when it will say that the one that is alive.
		// is the victor of the round and post it to the log.
		while(currentProtagonist.isAlive(currentProtagonist) 
				&& currentAntagonist.isAlive(currentAntagonist)) {
			if(initiativeWinner.equals(currentProtagonist)) {
				currentProtagonist.MeleeAttack(currentAntagonist);
			}
			else {
				currentAntagonist.MeleeAttack(currentProtagonist);
			}
		}*/
	}
}
