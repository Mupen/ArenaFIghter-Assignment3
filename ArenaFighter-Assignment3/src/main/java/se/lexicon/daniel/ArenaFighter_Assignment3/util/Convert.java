package se.lexicon.daniel.ArenaFighter_Assignment3.util;

/**
 * Created by Daniel Henriksen.
 */

public class Convert {

    public static int StringToInt(String inputString) {
		if(inputString.equals(null) || inputString.equals("") || !inputString.matches("[0-9]+")) {
			System.out.println("Not a valid input...");
			return StringToInt(KeyboardInput.getString("Please enter a valid input: "));
		}
		else {
			int intNumber = Integer.parseInt(inputString);
			return intNumber;
		}
    }
}
