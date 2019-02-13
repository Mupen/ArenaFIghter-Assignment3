package se.lexicon.daniel.ArenaFighter_Assignment3.model;
import java.util.List;

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
		self.setStrenght(RandomGenerator.getRandomDecimal(1, 10));
		self.setAgility(RandomGenerator.getRandomDecimal(1, 10));
		self.setConstitution(RandomGenerator.getRandomDecimal(1, 10));
		self.setPerception(RandomGenerator.getRandomDecimal(1, 10));
		self.setCharisma(RandomGenerator.getRandomDecimal(1, 10));
		self.setWill(RandomGenerator.getRandomDecimal(1, 10));
		getAttributes();
	}


}
