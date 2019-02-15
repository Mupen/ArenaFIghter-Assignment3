package se.lexicon.daniel.ArenaFighter_Assignment3;

import se.lexicon.daniel.ArenaFighter_Assignment3.controller.FightingController;

public class Main {
    public static void main( String[] args ) {
    	FightingController ui = new FightingController();
    	while(ui.isRunning()) {
    		ui.run();
    	}
    }
}
