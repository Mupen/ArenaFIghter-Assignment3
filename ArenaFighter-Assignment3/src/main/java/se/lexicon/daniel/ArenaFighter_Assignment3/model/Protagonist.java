package se.lexicon.daniel.ArenaFighter_Assignment3.model;
import java.util.List;

import se.lexicon.daniel.ArenaFighter_Assignment3.util.KeyboardInput;

/**
 * Created by Daniel Henriksen.
 */

public class Protagonist extends Combatant implements CombatantSignatures {

	public Protagonist(String name) {
		super(name);
		System.out.println("");
		System.out.println("|------" + name.replaceAll("[a-zA-Z\\s]", "-") + "--------------------------|");
		System.out.println("| " + name + " ready for character creation! |");
		System.out.println("|------" + name.replaceAll("[a-zA-Z\\s]", "-") + "--------------------------|");
		System.out.println("");
	}

	public void GetProtagonistCreation(CombatantSignatures self, int amout, int times) {
		System.out.println(
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
						"\n");
		
		while((amout < times)) {
			amout++;
			String selection = KeyboardInput.getString(" Your selection... ");
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

}