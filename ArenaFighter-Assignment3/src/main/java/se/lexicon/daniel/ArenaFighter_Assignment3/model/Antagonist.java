package se.lexicon.daniel.ArenaFighter_Assignment3.model;
import se.lexicon.daniel.ArenaFighter_Assignment3.util.RandomGenerator;

/**
 * Created by Daniel Henriksen.
 */

public class Antagonist extends Combatant implements CombatantSignatures {

	public Antagonist(String name) {
		super(name);
		System.out.println("");
		System.out.println("|------" + name.replaceAll("[a-zA-Z\\s]", "-") + "--------------------------|");
		System.out.println("| " + name + " ready for character creation! |");
		System.out.println("|------" + name.replaceAll("[a-zA-Z\\s]", "-") + "--------------------------|");
		System.out.println("");
	}

	public void GetAntagonistCreation(CombatantSignatures self) {
		self.setStrenght(RandomGenerator.getRandomDecimal());
		self.setAgility(RandomGenerator.getRandomDecimal());
		self.setConstitution(RandomGenerator.getRandomDecimal());
		self.setPerception(RandomGenerator.getRandomDecimal());
		self.setCharisma(RandomGenerator.getRandomDecimal());
		self.setWill(RandomGenerator.getRandomDecimal());
		getAttributes();
	}



}
