package se.lexicon.daniel.ArenaFighter_Assignment3.util;
import java.util.Scanner;

/**
 * Created by Daniel Henriksen.
 */

public abstract class KeyboardInput {
	
	// Scanner function and Random function.
	static Scanner keyboard = new Scanner(System.in);

    public static String getString(String inputString) {
        System.out.print(inputString);
        return keyboard.nextLine();
    }
    
    public static int getInt(String inputNumber) {
        System.out.print(inputNumber);
        return keyboard.nextInt();
    }
}