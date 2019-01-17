package se.lexicon.daniel.ArenaFighter_Assignment3.util;

import java.util.Random;

/**
 * Created by Daniel Henriksen.
 */

public class RandomGenerator {
	static Random generator = new Random();

	//String array
	public static String getRandomName() {
		String[] arrayStrings = {"Tetraites", "Priscus ", "Verus", "Spiculus", "Marcus Attilius", "Carpophorus", "Crixus", "Flamma", "Commodus", "Spartacus", "Achilles", "Genghis Khan", "Marcus Cassius Scaeva", "Hannibal Barca", "Tlahuicole", "Miyamoto Musashi", "Alexander the Great", "Pyrrhus of Epirus", "Vald the Impaler", "Leonidas of Sparta", "Hercules", "Arminnius", "Spartacus", "Miltiades", "Attila The Hun", "Erik The Red", "Sun Tzu"};
		int randomIndex = generator.nextInt(arrayStrings.length);
		return arrayStrings[randomIndex];
	}
	
    public static int getRandomDecimal() {
        return generator.nextInt(10-1) + 1;
    }
}
