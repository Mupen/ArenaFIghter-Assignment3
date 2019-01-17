package se.lexicon.daniel.ArenaFighter_Assignment3.controller;

import se.lexicon.daniel.ArenaFighter_Assignment3.model.Antagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.model.Protagonist;
import se.lexicon.daniel.ArenaFighter_Assignment3.service.Arena;
import se.lexicon.daniel.ArenaFighter_Assignment3.service.CharacterAction;

public class FightingController {
	private Arena arena;
	private boolean running;
	private Protagonist currentProtagonist = null;
	private Antagonist currentAntagonist = null;
	private CharacterAction initiativeWinner = null;
	
		
	public FightingController() {
		arena = new Arena();
		running = true;
	}

	public boolean isRunning() {
		return running;
	}
	
	public boolean isStoping() {
		return running = false;
	}
	
	public void run() {
		
		// If null initializen objects 
		if(currentProtagonist == null) {currentProtagonist = arena.ProtagonistCreation();}
		if(currentAntagonist == null) {currentAntagonist = arena.AntagonistCreation();}
		
		// Start Initiative Conflicts
		if(initiativeWinner == null) {
			initiativeWinner = arena.Initiative(currentProtagonist, currentAntagonist);
		}
		
		// start Melee conflicts
		arena.Fight(currentProtagonist, currentAntagonist, initiativeWinner);
		
		isStoping();
	}
}