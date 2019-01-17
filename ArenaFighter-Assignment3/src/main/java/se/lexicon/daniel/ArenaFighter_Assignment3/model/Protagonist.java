package se.lexicon.daniel.ArenaFighter_Assignment3.model;
import se.lexicon.daniel.ArenaFighter_Assignment3.service.Characters;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.KeyboardInput;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

/**
 * Created by Daniel Henriksen.
 */

public class Protagonist extends Combatant implements Characters {
	
    public Protagonist(String name) {
        super(name);
        System.out.println("");
    	System.out.println("|------" + name.replaceAll("[a-zA-Z\\s]", "-") + "--------------------------|");
    	System.out.println("| " + name + " ready for character creation! |");
    	System.out.println("|------" + name.replaceAll("[a-zA-Z\\s]", "-") + "--------------------------|");
    	System.out.println("");
    }
    
    public void GetProtagonistCreation(Characters self, int amout, int times) {
		while((amout < times)) {
			amout++;
    		String selection = KeyboardInput.getString(
    				"\n ------------" + getName() + " Character Menu ------------ \n" +
    				" Character Creation will allow you to add \n" +
    				" Five times before it close. If you level \n" +
    				" upp it will give you one one more \n" +
    				"\n" +
    				" [a] add 2 out of 10 to strength \n" +
    				" [s] add 2 out of 10 to agilty \n" +
    				" [d] add 2 out of 10 to constitution \n" +
    				" [f] add 2 out of 10 to charisma\n" +
    				" [g] add 2 out of 10 to perception\n" +
    				" [h] add 2 out of 10 to will\n" +
    				"\n" +
    				" Your selection... "
    				);
    		
    		switch (selection.toLowerCase()) {
				case "a":
					self.gainStrenght(2);
					break;
				case "s":
					self.gainAgility(2);
					break;
				case "d":
					self.gainConstitution(2);
					break;
				case "f":
					self.gainCharisma(2);
					break;
				case "g":
					self.gainPerception(2);
					break;
				case "h":
					self.gainWill(2);
					break;
				default:
					break;
    		}
		}
		getAttributes();
    }
    
    @Override
	public Characters RollInitiative(Protagonist currentProtagonist, Antagonist currentAntagonist) {
    	System.out.println("");
    	System.out.println("|---------------------|");
    	System.out.println("| Roll For Initiative |");
    	System.out.println("|---------------------|");
    	System.out.println("");

		int selfInitiative = getInitiative() + RandomGenerator.getRandomDecimal();
		int opponentInitiative = currentAntagonist.getInitiative() + RandomGenerator.getRandomDecimal();
	      
		System.out.println("[" + getName() + "]: <Starts> " + "randomDescriptiveInitiativeStringArray");
		
		System.out.println("[" + getName() + "]: Try to take the initiative [" + selfInitiative + "]");
		
		System.out.println("[" + currentAntagonist.getName() + "]: Try to take the initiative [" + opponentInitiative + "]");
	      
		if (selfInitiative > opponentInitiative) {
			System.out.println("[" + getName() + "]: Result: as victor");
	        System.out.println("");
	    	System.out.println("|------" + getName().replaceAll("[a-zA-Z\\s]", "-") + "--------------------------|");
	    	System.out.println("| " + getName() + " What will he do? |");
	    	System.out.println("|------" + getName().replaceAll("[a-zA-Z\\s]", "-") + "--------------------------|");
	    	System.out.println("");
			return currentProtagonist;


	 	}
		else {
			System.out.println("[" + currentAntagonist.getName() + "]: Result: as victor");
	        System.out.println("");
	    	System.out.println("|------" + currentAntagonist.getName().replaceAll("[a-zA-Z\\s]", "-") + "--------------------------|");
	    	System.out.println("| " + currentAntagonist.getName() + " What will you do? |");
	    	System.out.println("|------" + currentAntagonist.getName().replaceAll("[a-zA-Z\\s]", "-") + "--------------------------|");
	    	System.out.println("");
			return currentAntagonist;

		}
	}

    @Override
    public void MeleeAttack(Characters opponent) {
    	System.out.println("");
    	System.out.println("|--------------------------|");
    	System.out.println("| Melee Attack Start Check |");
    	System.out.println("|--------------------------|");
    	System.out.println("");

      int meleeAttack = getMeleeAttack() + RandomGenerator.getRandomDecimal();
      int meleeDefence = opponent.getDodgeAttack() + RandomGenerator.getRandomDecimal();
      
      System.out.println("[" + getName() + "]: <Starts> " + "randomDescriptiveFightingStringArray");
      
	  System.out.println("[" + getName() + "]: <Melee Attack> [" + opponent.getName() + "] with [" + meleeAttack + "]");
	  
	  System.out.println("[" + opponent.getName() + "]: Dodge: [" + getName() + "] with [" + meleeDefence + "]");
      
	  if (meleeAttack >= meleeDefence) {
	      int meleeDamage = getMeleeDamage();
    	  System.out.println("[" + getName() + "]: Result: as victor and deal [" + meleeDamage + "]");
    	  opponent.decreaseHealth(meleeDamage);
      }
	}

	public boolean isAlive(Protagonist currentProtagonist) {
		if(currentProtagonist.getHealth() > 0) {
			setAlive(true);
			return this.isAlive();
		}
		if(getHealth() < (-10)) {
			System.out.println(currentProtagonist.getName() + " have died...");
			setAlive(false);
			currentProtagonist = null;
			return this.isAlive();
		}
		else {
			System.out.println(getName() + " have fallen un conscious...");
			setAlive(true);
			return this.isAlive();
		}
	}
}