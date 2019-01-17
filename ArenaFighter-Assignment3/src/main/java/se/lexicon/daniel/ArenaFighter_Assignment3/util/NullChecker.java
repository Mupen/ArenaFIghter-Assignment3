package se.lexicon.daniel.ArenaFighter_Assignment3.util;

/**
 * Created by Daniel Henriksen.
 */

public class NullChecker {
	
	public static boolean nullCheck(Object... objects) {
		for(Object obj: objects) {
			if(obj == null) {
				return true;
			}
		}
		return false;
	}

}
