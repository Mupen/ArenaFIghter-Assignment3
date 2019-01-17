package se.lexicon.daniel.ArenaFighter_Assignment3.model;
import se.lexicon.daniel.ArenaFighter_Assignment3.service.CharacterAction;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

/**
 * Created by Daniel Henriksen.
 */

public class Antagonist extends Combatant implements CharacterAction{
	
    public Antagonist(String name) {
        super(name);
        System.out.println("");
    	System.out.println("|------" + name.replaceAll("[a-zA-Z\\s]", "-") + "--------------------------|");
    	System.out.println("| " + name + " ready for character creation! |");
    	System.out.println("|------" + name.replaceAll("[a-zA-Z\\s]", "-") + "--------------------------|");
    	System.out.println("");
    }

    public void GetAntagonistCreation(CharacterAction self) {
    	self.setStrenght(RandomGenerator.getRandomDecimal());
    	self.setAgility(RandomGenerator.getRandomDecimal());
    	self.setConstitution(RandomGenerator.getRandomDecimal());
    	self.setPerception(RandomGenerator.getRandomDecimal());
    	self.setCharisma(RandomGenerator.getRandomDecimal());
    	self.setWill(RandomGenerator.getRandomDecimal());
    	getAttributes();
    }
    
    @Override
	public CharacterAction RollInitiative(Protagonist currentProtagonist, Antagonist currentAntagonist) {
    	System.out.println("");
    	System.out.println("|-----------------------------|");
    	System.out.println("| Roll Initiative Start Check |");
    	System.out.println("|-----------------------------|");
    	System.out.println("");

		int selfInitiative = getInitiative() + RandomGenerator.getRandomDecimal();
		int opponentInitiative = currentProtagonist.getInitiative() + RandomGenerator.getRandomDecimal();
	      
		System.out.println("[" + getName() + "]: <Starts> " + "randomDescriptiveInitiativeStringArray");
		
		System.out.println("[" + getName() + "]: Try to take the initiative [" + selfInitiative + "]");
		
		System.out.println("[" + currentProtagonist.getName() + "]: Try to take the initiative [" + opponentInitiative + "]");
	      
		if (selfInitiative < opponentInitiative) {
			System.out.println("[" + getName() + "]: Result: as victor");
			return currentAntagonist;
	 	}
		else {
			System.out.println("[" + currentProtagonist.getName() + "]: Result: as victor");
			return currentProtagonist;
		}
	}
    
    @Override
    public void MeleeAttack(CharacterAction opponent) {
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

	public boolean isAlive(Antagonist currentAntagonist) {
		if(currentAntagonist.getHealth() > 0) {
			setAlive(true);
			return this.isAlive();
		}
		if(getHealth() < (-10)) {
			System.out.println(currentAntagonist.getName() + " have died...");
			setAlive(false);
			currentAntagonist = null;
			return this.isAlive();
		}
		else {
			System.out.println(getName() + " have fallen un conscious...");
			setAlive(true);
			return this.isAlive();
		}
	}
}
